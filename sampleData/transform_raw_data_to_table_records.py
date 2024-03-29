import glob
import json
import csv

def write_list_data_to_file(data, filename):
    with open(filename, "w") as file:
        file.write(json.dumps(data))

def write_dictionary_data_to_file(data, filename):
    write_list_data_to_file(list(data.values()), filename)

def find_code(code_dict, code_item_name):
    for code_item in list(code_dict.values()):
        if code_item["code_item_name"] == code_item_name:
            return code_item["code"]
    
    return ''

status_set = set()
status_dict = dict()
genre_dict = dict()
company_dict = dict()
country_dict = dict()
collection_dict = dict()
language_dict = dict()
movie_list = list()
content_production_company_list = list()
content_spoken_language_list = list()
content_genre_list = list()
content_vote_summary_list = list()

source_file_names = glob.glob("./movie/movie_*.json")
for source_file_name in source_file_names:
    with open(source_file_name, encoding="UTF-8") as source_file:
        print(source_file_name + " opened")

        json_data = json.load(source_file)
        
        status = json_data["status"]
        count_before_add = len(status_dict)
        status_set.add(status)

        if len(status_set) > count_before_add:
            status_dict[count_before_add + 1] = {
                "code_category_id": 0,
                "code_item_name": status,
                "code": count_before_add
            }
        
        production_countries = json_data["production_countries"]
        for production_country in production_countries:
            country_dict[production_country["iso_3166_1"]] = {
                "country_name": production_country["name"],
                "iso_3166_1": production_country["iso_3166_1"]
            }

        collection = json_data["belongs_to_collection"]
        if collection:
            collection_dict[collection["id"]] = {
                "name": collection["name"],
                "poster_path": collection["poster_path"],
                "backdrop_path": collection["backdrop_path"]
            }
        
        original_language = json_data['original_language']
        movie = {
            "movie_collection_id": f"movie_collection_name_start {collection['name']} movie_collection_name_end" if collection and collection['name'] else '',
            "original_language_id": f"original_language_start {original_language} original_language_end" if original_language else '',
            "imdb_id": json_data["imdb_id"],
            "original_title": json_data["original_title"],
            "overview": json_data["overview"],
            "homepage": json_data["homepage"],
            "backdrop_path": json_data["backdrop_path"],
            "poster_path": json_data["poster_path"],
            "release_date": json_data["release_date"],
            "release_status_code": find_code(status_dict, status) if status else '',
            "budget": json_data["budget"],
            "revenue": json_data["revenue"],
            "runtime": json_data["runtime"],
            "popularity": json_data["popularity"],
            "adult": json_data["adult"],
            "video": json_data["video"]
        }
        movie_list.append(movie)

        production_companies = json_data["production_companies"]
        for production_company in production_companies:
            company_dict[production_company["id"]] = {
                "company_name": production_company["name"],
                "logo_path": production_company["logo_path"],
                "company_country_id": production_company["origin_country"]
            }

            content_production_company_list.append({
                "production_movie_id": f"production_movie_name_start {movie['original_title']} production_movie_name_end release_date_start {movie['release_date']} release_date_end",
                "production_company_id": f"production_company_name_start {production_company['name']} production_company_name_end",
                "content_type_code": 0
            })
        
        spoken_languages = json_data["spoken_languages"]
        for language in spoken_languages:
            language_dict[language["iso_639_1"]] = language
            language["language_name"] = language["name"]
            del language["name"]

            content_spoken_language_list.append({
                "movie_id": f"movie_name_start {movie['original_title']} movie_name_end release_date_start {movie['release_date']} release_date_end",
                "spoken_language_id": f"iso_639_1_start {language['iso_639_1']} iso_639_1_end",
                "content_type_code": 0
            })
        
        genres = json_data["genres"]
        for genre in genres:
            genre_dict[genre["id"]] = {
                "code_category_id": 0,
                "code_item_name": genre["name"],
                "code": genre["id"]
            }

            content_genre_list.append({
                "movie_id": f"movie_name_start {movie['original_title']} movie_name_end release_date_start {movie['release_date']} release_date_end",
                "content_type_code": 0,
                "genre_code": genre["id"]
            })
        
        content_vote_summary_list.append({
            "movie_id": f"movie_name_start {movie['original_title']} movie_name_end release_date_start {movie['release_date']} release_date_end",
            "content_type_code": 0,
            "vote_average_rating": json_data["vote_average"],
            "vote_count": json_data["vote_count"]
        })

write_list_data_to_file(content_vote_summary_list, "content_vote_summaries.json")
write_list_data_to_file(content_genre_list, "content_genres.json")
write_list_data_to_file(content_spoken_language_list, "content_spoken_languages.json")
write_list_data_to_file(content_production_company_list, "content_production_companies.json")
write_list_data_to_file(movie_list, "movies.json")
write_dictionary_data_to_file(collection_dict, "collections.json")
write_dictionary_data_to_file(company_dict, "companies.json")
write_dictionary_data_to_file(country_dict, "countries.json")
write_dictionary_data_to_file(status_dict, "release_status.json")
write_dictionary_data_to_file(genre_dict, "genres.json")
write_dictionary_data_to_file(language_dict, "languages.json")
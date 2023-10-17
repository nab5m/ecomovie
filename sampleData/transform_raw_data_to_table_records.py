import glob
import json
import csv

def write_list_data_to_file(data, filename):
    with open(filename, "w") as file:
        file.write(json.dumps(data))

def write_dictionary_data_to_file(data, filename):
    write_list_data_to_file(list(data.values()), filename)

def find_status_code(status_dict, status):
    for code_item in list(status_dict.values()):
        if code_item["code_item_name"] == status:
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
        
        genres = json_data["genres"]
        for genre in genres:
            genre_dict[genre["id"]] = {
                "code_category_id": 0,
                "code_item_name": genre["name"],
                "code": genre["id"]
            }

        production_companies = json_data["production_companies"]
        for production_company in production_companies:
            company_dict[production_company["id"]] = {
                "company_name": production_company["name"],
                "logo_path": production_company["logo_path"],
                "company_country_id": production_company["origin_country"]
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
        
        spoken_languages = json_data["spoken_languages"]
        for language in spoken_languages:
            language_dict[language["iso_639_1"]] = language
            language["language_name"] = language["name"]
            del language["name"]
        
        original_language = json_data['original_language']
        movie_list.append({
            "movie_collection_id": f"movie_collection_name_start {collection['name']} movie_collection_name_end" if collection and collection['name'] else '',
            "original_language_id": f"original_language_start {original_language} original_language_end" if original_language else '',
            "imdb_id": json_data["imdb_id"],
            "original_title": json_data["original_title"],
            "overview": json_data["overview"],
            "homepage": json_data["homepage"],
            "backdrop_path": json_data["backdrop_path"],
            "poster_path": json_data["poster_path"],
            "release_date": json_data["release_date"],
            "release_status_code": find_status_code(status_dict, status) if status else '',
            "budget": json_data["budget"],
            "revenue": json_data["revenue"],
            "runtime": json_data["runtime"],
            "popularity": json_data["popularity"],
            "adult": json_data["adult"],
            "video": json_data["video"]
        })

write_list_data_to_file(movie_list, "movies.json")
write_dictionary_data_to_file(collection_dict, "collections.json")
write_dictionary_data_to_file(company_dict, "companies.json")
write_dictionary_data_to_file(country_dict, "countries.json")
write_dictionary_data_to_file(status_dict, "release_status.json")
write_dictionary_data_to_file(genre_dict, "genres.json")
write_dictionary_data_to_file(language_dict, "languages.json")
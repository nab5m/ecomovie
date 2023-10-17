import glob
import json
import csv

def write_dictionary_data_to_file(data, filename):
    language_list = list(data.values())

    with open(filename, "w") as file:
        file.write(json.dumps(language_list))

status_set = set()
genre_dict = dict()
company_dict = dict()
country_dict = dict()
collection_dict = dict()
language_dict = dict()

source_file_names = glob.glob("./movie/movie_*.json")
for source_file_name in source_file_names:
    with open(source_file_name, encoding="UTF-8") as source_file:
        print(source_file_name + " opened")

        json_data = json.load(source_file)
        
        status_set.add(json_data["status"])
        
        genres = json_data["genres"]
        for genre in genres:
            genre_dict[genre["id"]] = genre["name"]

        production_companies = json_data["production_companies"]
        for production_company in production_companies:
            company_dict[production_company["id"]] = production_company
        
        production_countries = json_data["production_countries"]
        for production_country in production_countries:
            country_dict[production_country["iso_3166_1"]] = production_country["name"]

        collection = json_data["belongs_to_collection"]
        if collection:
            collection_dict[collection["id"]] = collection
        
        spoken_languages = json_data["spoken_languages"]
        for language in spoken_languages:
            language_dict[language["iso_639_1"]] = language
            language["language_name"] = language["name"]
            del language["name"]

print(status_set)
print(genre_dict)
print(company_dict)
print(country_dict)
print(collection_dict)

write_dictionary_data_to_file(language_dict, "languages.json")
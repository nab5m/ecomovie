import glob
import json
import csv

status_list = set()
genre_list = dict()
company_list = dict()
country_list = dict()
collection_list = dict()
language_list = dict()

source_file_names = glob.glob("./movie/movie_*.json")
for source_file_name in source_file_names:
    with open(source_file_name, encoding="UTF-8") as source_file:
        print(source_file_name + " opened")

        json_data = json.load(source_file)
        
        status_list.add(json_data["status"])
        
        genres = json_data["genres"]
        for genre in genres:
            genre_list[genre["id"]] = genre["name"]

        production_companies = json_data["production_companies"]
        for production_company in production_companies:
            company_list[production_company["id"]] = production_company
        
        production_countries = json_data["production_countries"]
        for production_country in production_countries:
            country_list[production_country["iso_3166_1"]] = production_country["name"]
            

        collection = json_data["belongs_to_collection"]
        if collection:
            collection_list[collection["id"]] = collection
        
        spoken_languages = json_data["spoken_languages"]
        for language in spoken_languages:
            language_list[language["iso_639_1"]] = language

print(status_list)
print(genre_list)
print(company_list)
print(country_list)
print(collection_list)
print(language_list)

language_list = list(language_list.values())
for language in language_list:
    language["language_name"] = language["name"]
    del language["name"]

with open("languages.json", "w") as file:
    file.write(json.dumps(language_list))
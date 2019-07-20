from elasticsearch import Elasticsearch
import time
from datetime import timezone, datetime
import json
import random

es = Elasticsearch([{"host": "localhost", "port": 9200}])

if not es.indices.exists(index="fishing-data-general"):
    mapping = {
        "mappings":{
            "doc":{
            'properties' : {'timestamp': {'type': 'date'} }
        }
        }
    }
    es.indices.create(index="fishing-data-general", ignore=400, body=mapping)

cities = ["Mumbai", "Malvan", "Kolhapur", "Ratnagiri", "Jaigad"]

def general_view():
    timestamp = 1527811200 # 1st June 2018
    for i in range(1, 366):
        location = random.choice(cities)
        cities_ponds_hash = {
            "Mumbai": random.randint(100, 600),
            "Malvan": random.randint(500, 1000),
            "Kolhapur": random.randint(900, 2500),
            "Ratnagiri": random.randint(200, 900),
            "Jaigad": random.randint(2500, 3000)
        }
        cities_farmers_hash = {
            "Mumbai": random.randint(100, 200),
            "Malvan": random.randint(500, 700),
            "Kolhapur": random.randint(900, 1500),
            "Ratnagiri": random.randint(300, 550),
            "Jaigad": random.randint(2000, 3000)
        }
        geo_data = {
            "timestamp": timestamp*(10**3),
            "location": location,
            "number_of_ponds": cities_ponds_hash[location],
            "number_of_farmers": cities_farmers_hash[location]
        }
        es.index(index="fishing-data-general", doc_type="doc", body=geo_data)
        timestamp += 60*60*24*10

def pond_detailed():
    timestamp = 1543622410 # 1st December 2018
    for i in range(1, 5001):
        soil_ph = round(random.uniform(0, 7), 2)
        water_ph = soil_ph+1
        fishes = random.randint(100, 5000)
        pond_data = {
            "timestamp": timestamp*(10**3),
            "location": random.choice(cities),
            "pond_size": random.randint(200, 4000),
            "pond_depth": round(random.uniform(1, 3.5), 2),
            "pond_owner": random.choice([chr(i) for i in range(ord('A'), ord('Z')+1)]),
            "temprature": random.randint(15, 50),
            "water_ph": water_ph,
            "soil_ph": soil_ph,
            "lime_dose": random.randint(200, 1000),
            "fish_breed": random.choice(["Wallago", "Pabda", "Channa Striata", "Calbasu", "Trout"]),
            "number_of_fishes": fishes,
            "type_of_feed": random.choice(["Brood Stock", "Mustard Cake", "Rice Bran", "Ground Nut Cake"]),
            "feed_quantity": fishes*random.randint(1, 10)
        }
        es.index(index="fishing-data-general", doc_type="doc", body=pond_data)
        timestamp += 60*60

def farmer_detailed():
    timestamp = 1527811200


#general_view()
#pond_detailed()
farmer_detailed()
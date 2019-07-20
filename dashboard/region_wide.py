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

timestamp = 1527811200
for i in range(1, 366):
    geo_data = {
        "timestamp": timestamp*(10**3),
        "location": random.choice(cities),
        "number_of_ponds": random.randint(2500, 3000),
        "number_of_farmers": random.randint(500, 3000)
    }
    timestamp += 60*60*24*10
    es.index(index="fishing-data-general", doc_type="doc", body=geo_data)
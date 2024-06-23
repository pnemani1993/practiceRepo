import requests
import os
import sys
import json

GOOGLE_API_KEY= ""
AUTH_QUERY = ""
LOCATION_BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json"
LOCATION_ADDRESS_QUERY = "?address="
print(GOOGLE_API_KEY, AUTH_QUERY)

WEATHER_BASE_URL = "https://api.weather.gov/points/"
HEADERS = {'User-Agent': '(myweatherapp.com, contact@myweatherapp.com)'}

def _location_setup() -> str:
    assert(os.environ['G_KEY'])
    GOOGLE_API_KEY=os.environ['G_KEY']
    AUTH_QUERY= f'&key={GOOGLE_API_KEY}'
    print(GOOGLE_API_KEY, AUTH_QUERY)
    return AUTH_QUERY

def _sendGeoLocationRequest(address: str, auth_query: str ): 
    url = f'{LOCATION_BASE_URL}{LOCATION_ADDRESS_QUERY}{address}{auth_query}'
    print(url)
    locationResponse = requests.get(url)
    print(locationResponse.text)
    jsonResponse = locationResponse.json()
    latitude = jsonResponse['results'][0]['geometry']['location']['lat']
    longitude = jsonResponse['results'][0]['geometry']['location']['lng']
    return (latitude, longitude)

def runApp(address: str):
    auth_query = _location_setup()
    lat, lng = _sendGeoLocationRequest(address, auth_query)
    print (f'Latitude: {lat}, Longitude: {lng}')
    _getWeatherURLfromLocation(_formatCoordinates(lat, lng))

def _formatCoordinates(lat: str, lng: str):
    return {"Lat": str(round(float(lat), 4)), "Lng": str(round(float(lng), 4))}

def _getWeatherURLfromLocation(location: dict):
    lat = location['Lat']
    lng = location['Lng']
    jsonResponse = requests.get(f'{WEATHER_BASE_URL}{lat},{lng}', headers=HEADERS)
    print(jsonResponse.text)
    return jsonResponse.json()
# Instructions on how to initiate a project #

Instructions: 
```
# First Command
hatch new "api-reader"
# this creates a project named api-reader in the current working directory. 

# Enter into the created directory of api-reader: use this command in terminal -> cd api-reader
# Second Command
python -m venv venv (or) use: py -m venv venv
# This sets up a venv for using python libraries

# Third Command
venv/bin/pip install requests
# This installs the requests library required for interacting with the api

# Fourth Command





```
## Open AI integration ##
Organization ID: `org-W9JIdVm3RCNUNx86KYgrMst8`

Project ID: `proj_Hb1HaGDeFxL5o937fivD2hSv`
> To access the Default project in an organization, leave out the OpenAI-Project header
Example curl request to send: 
```curl
curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -d '{
     "model": "gpt-3.5-turbo",
     "messages": [{"role": "user", "content": "Say this is a test!"}],
     "temperature": 0.7
   }'
```

Expected response: 
```json
{
    "id": "chatcmpl-abc123",
    "object": "chat.completion",
    "created": 1677858242,
    "model": "gpt-3.5-turbo-0613",
    "usage": {
        "prompt_tokens": 13,
        "completion_tokens": 7,
        "total_tokens": 20
    },
    "choices": [
        {
            "message": {
                "role": "assistant",
                "content": "\n\nThis is a test!"
            },
            "logprobs": null,
            "finish_reason": "stop",
            "index": 0
        }
    ]
}
```

## Google API ##
[How to create API keys?](https://developers.google.com/maps/documentation/geocoding/get-api-key)

My Google API_KEY="$G_KEY"

[Google Geo-Coding API docs](https://developers.google.com/maps/documentation/geocoding/requests-geocoding)
[Geo-Coding FAQ](https://developers.google.com/maps/faq#geocoder_queryformat)

`https://maps.googleapis.com/maps/api/geocode/outputFormat?parameters&key=API_KEY`

```
curl "https://maps.googleapis.com/maps/api/geocode/json?address=1525%20Lincoln%20Cir%20Mclean%20VA&key=$G_KEY"

curl "https://maps.googleapis.com/maps/api/geocode/json?address=8083%20Stonebrook%20Pkwy%20Frisco%20TX&key=$G_KEY"

```

Response: 
```json
{
  "results": [
    {
      "address_components": [
        {
          "long_name": "1525",
          "short_name": "1525",
          "types": [
            "street_number"
          ]
        },
        {
          "long_name": "Lincoln Circle",
          "short_name": "Lincoln Cir",
          "types": [
            "route"
          ]
        },
        {
          "long_name": "McLean",
          "short_name": "McLean",
          "types": [
            "locality",
            "political"
          ]
        },
        {
          "long_name": "Fairfax County",
          "short_name": "Fairfax County",
          "types": [
            "administrative_area_level_2",
            "political"
          ]
        },
        {
          "long_name": "Virginia",
          "short_name": "VA",
          "types": [
            "administrative_area_level_1",
            "political"
          ]
        },
        {
          "long_name": "United States",
          "short_name": "US",
          "types": [
            "country",
            "political"
          ]
        },
        {
          "long_name": "22102",
          "short_name": "22102",
          "types": [
            "postal_code"
          ]
        }
      ],
      "formatted_address": "1525 Lincoln Cir, McLean, VA 22102, USA",
      "geometry": {
        "bounds": {
          "northeast": {
            "lat": 38.9287512,
            "lng": -77.23067
          },
          "southwest": {
            "lat": 38.9278398,
            "lng": -77.2315967
          }
        },
        "location": {
          "lat": 38.9283098,
          "lng": -77.2313084
        },
        "location_type": "ROOFTOP",
        "viewport": {
          "northeast": {
            "lat": 38.92964458029149,
            "lng": -77.2297843697085
          },
          "southwest": {
            "lat": 38.9269466197085,
            "lng": -77.2324823302915
          }
        }
      },
      "place_id": "ChIJPZUkMo1KtokRwAQtRKtquMA",
      "types": [
        "premise"
      ]
    }
  ],
  "status": "OK"
}
```

```json
{
   "results" : 
   [
      {
         "address_components" : 
         [
            {
               "long_name" : "8083",
               "short_name" : "8083",
               "types" : 
               [
                  "street_number"
               ]
            },
            {
               "long_name" : "Stonebrook Parkway",
               "short_name" : "Stonebrook Pkwy",
               "types" : 
               [
                  "route"
               ]
            },
            {
               "long_name" : "Enclave At Stonebrook",
               "short_name" : "Enclave At Stonebrook",
               "types" : 
               [
                  "neighborhood",
                  "political"
               ]
            },
            {
               "long_name" : "Frisco",
               "short_name" : "Frisco",
               "types" : 
               [
                  "locality",
                  "political"
               ]
            },
            {
               "long_name" : "Collin County",
               "short_name" : "Collin County",
               "types" : 
               [
                  "administrative_area_level_2",
                  "political"
               ]
            },
            {
               "long_name" : "Texas",
               "short_name" : "TX",
               "types" : 
               [
                  "administrative_area_level_1",
                  "political"
               ]
            },
            {
               "long_name" : "United States",
               "short_name" : "US",
               "types" : 
               [
                  "country",
                  "political"
               ]
            },
            {
               "long_name" : "75034",
               "short_name" : "75034",
               "types" : 
               [
                  "postal_code"
               ]
            },
            {
               "long_name" : "7203",
               "short_name" : "7203",
               "types" : 
               [
                  "postal_code_suffix"
               ]
            }
         ],
         "formatted_address" : "8083 Stonebrook Pkwy, Frisco, TX 75034, USA",
         "geometry" : 
         {
            "location" : 
            {
               "lat" : 33.1394222,
               "lng" : -96.8135489
            },
            "location_type" : "ROOFTOP",
            "viewport" : 
            {
               "northeast" : 
               {
                  "lat" : 33.1408705302915,
                  "lng" : -96.8122234197085
               },
               "southwest" : 
               {
                  "lat" : 33.1381725697085,
                  "lng" : -96.81492138029151
               }
            }
         },
         "place_id" : "ChIJswH3Wf89TIYRuADaczA0FBk",
         "plus_code" : 
         {
            "compound_code" : "45QP+QH Frisco, TX",
            "global_code" : "865545QP+QH"
         },
         "types" : 
         [
            "street_address"
         ]
      }
   ],
   "status" : "OK"
}
```

## Weather API ##
[Weather API FAQs](https://weather-gov.github.io/api/general-faqs)

API_URL: `https://api.weather.gov/points/{lat},{lon}`
Headers: `User-Agent: (myweatherapp.com, contact@myweatherapp.com)`
`"detail": "The precision of latitude/longitude points is limited to 4 decimal digits for efficiency. The location attribute contains your request mapped to the nearest supported point. If your client supports it, you will be redirected."`

```
curl "https://api.weather.gov/points/33.1394,-96.8135" -H "User-Agent: (myweatherapp.com, contact@myweatherapp.com)"
```

```json
{
  "@context": [
    "https://geojson.org/geojson-ld/geojson-context.jsonld",
    {
      "@version": "1.1",
      "wx": "https://api.weather.gov/ontology#",
      "s": "https://schema.org/",
      "geo": "http://www.opengis.net/ont/geosparql#",
      "unit": "http://codes.wmo.int/common/unit/",
      "@vocab": "https://api.weather.gov/ontology#",
      "geometry": {
        "@id": "s:GeoCoordinates",
        "@type": "geo:wktLiteral"
      },
      "city": "s:addressLocality",
      "state": "s:addressRegion",
      "distance": {
        "@id": "s:Distance",
        "@type": "s:QuantitativeValue"
      },
      "bearing": {
        "@type": "s:QuantitativeValue"
      },
      "value": {
        "@id": "s:value"
      },
      "unitCode": {
        "@id": "s:unitCode",
        "@type": "@id"
      },
      "forecastOffice": {
        "@type": "@id"
      },
      "forecastGridData": {
        "@type": "@id"
      },
      "publicZone": {
        "@type": "@id"
      },
      "county": {
        "@type": "@id"
      }
    }
  ],
  "id": "https://api.weather.gov/points/33.1394,-96.8135",
  "type": "Feature",
  "geometry": {
    "type": "Point",
    "coordinates": [
      -96.8135,
      33.1394
    ]
  },
  "properties": {
    "@id": "https://api.weather.gov/points/33.1394,-96.8135",
    "@type": "wx:Point",
    "cwa": "FWD",
    "forecastOffice": "https://api.weather.gov/offices/FWD",
    "gridId": "FWD",
    "gridX": 89,
    "gridY": 120,
    "forecast": "https://api.weather.gov/gridpoints/FWD/89,120/forecast",
    "forecastHourly": "https://api.weather.gov/gridpoints/FWD/89,120/forecast/hourly",
    "forecastGridData": "https://api.weather.gov/gridpoints/FWD/89,120",
    "observationStations": "https://api.weather.gov/gridpoints/FWD/89,120/stations",
    "relativeLocation": {
      "type": "Feature",
      "geometry": {
        "type": "Point",
        "coordinates": [
          -96.822596,
          33.155427
        ]
      },
      "properties": {
        "city": "Frisco",
        "state": "TX",
        "distance": {
          "unitCode": "wmoUnit:m",
          "value": 1973.093316882
        },
        "bearing": {
          "unitCode": "wmoUnit:degree_(angle)",
          "value": 154
        }
      }
    },
    "forecastZone": "https://api.weather.gov/zones/forecast/TXZ104",
    "county": "https://api.weather.gov/zones/county/TXC085",
    "fireWeatherZone": "https://api.weather.gov/zones/fire/TXZ104",
    "timeZone": "America/Chicago",
    "radarStation": "KFWS"
  }
}
```

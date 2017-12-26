## Backend Core for Crowd Sourcing

This is the backend server for crowd-sourcing data for enriching Bengali Wordnet.

## Requirements

* Java 1.8

## Using the API

The server provides API for adding new Application, User and Adding Data.
* Add the following header:
`Content-Type: application/x-www-form-urlencoded`
* Use `json` as String Parameter or Key
* Data encoded in `x-www-form-urlencoded` format is only supported for now.

#### 1. Adding a new Application:
Send a `POST` request to the following URL:
```
http://localhost:8080/app/add
```
Use the following JSON format to add a new application.
* Please use package name as application name(for android apps).
* For apps (i.e. webapps) please use the the following format.

```
{
    "name": "com.yoursite.appname",
    "type": "typeOfApplication",
    "email": "aaa@example.com"
}
```
If the request is successful a token will be sent in `JSON`:
```
{
    "status":"ee977806d7286510da8b9a7492ba58e2484c0ecc"
}
```
If the request fails the following message will be sent in `JSON`:
```
{
    "status":"ERROR"
}
```

#### 2. Adding a new User:
Send a `POST` request to the following URL:
```
http://localhost:8080/user/add
```
Use the following JSON format to add a new application.
* Currently only user is allowed for type.
* Please use `ISO 3166-1 alpha-2` format for country codes.
No other format is accepted.

```
{
  "name": "yourRealName",
  "email": "yourRealName@example.com",
  "type": "user",
  "fullName": "yourRealName",
  "dateOfBirth": "1997-11-07 00:00:00",
  "gender": "maleOrFemalOrNeutralOrOther",
  "address": "youraddress",
  "phone": "01234567890",
  "age": 99,
  "country": "BD",
  "education": "latestDegree"
}
```
If the request is successful a token will be sent in `JSON`:
```
{
    "status":"ee977806d7286510da8b9a7492ba58e2484c0ecc"
}
```
If the request fails the following message will be sent in `JSON`:
```
{
    "status":"ERROR"
}
```

#### 3. Sending data to server:
Send a `POST` request to the following URL:
```
http://localhost:8080/data/add
```
Use the following JSON format to add a new application.
* Please use application key received as token.
* Please use user key received as token.

```
{  
    "appKey":"system_hash",
    "userKey":"system_hash",
    "location":{  
        "name":"",
        "longitude":12.33,
        "latitude":222.36,
        "altitude":10,
        "elevation":10,
        "type":"location_type"
    },
    "region":{  
        "name":"name_of_region",
        "type":"type_of_region"
    }
}
```
If the request is successful the following message will be sent in `JSON`:
```
{
    "status":"OK"
}
```
If the request fails the following message will be sent in `JSON`:
```
{
    "status":"ERROR"
}
```
## Authors

* **Farhan Ar Rafi** - *Architecture and Development* - [Personal Site](https://farhanarrafi.com)
* **Sk. Golam Mohammad Hasnain** - *Development* - [Profile](https://github.com/Oithe)


## License

All rights reserved.

The JWI Library is under the copyright of [Mark A. Finlayson](https://users.cs.fiu.edu/~markaf/)
# crudapp
 This is basic spring boot crud application with rest api

API endpoints

##### GET

`http://localhost:8080/api/v1/getusers`

`http://localhost:8080/api/v1/getuser/1`

`http://localhost:8080/api/v1/getlast5`

##### POST

`http://localhost:8080/api/v1/adduser`

{
        "name": "kumara",
        "email": "kumara@gmail.com",
        "phone": "07112345678",
        "role": "SE",
        "password": "852pwd"
}

##### PUT

`http://localhost:8080/api/v1/updateuser`

{
        "id": 1,
        "name": "kumara",
        "email": "kumara@gmail.com",
        "phone": "07112345678",
        "role": "Senior SE",
        "password": "852pwd"
}

##### delete

`http://localhost:8080/api/v1/deleteuser/1`


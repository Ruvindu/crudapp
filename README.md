# crudapp
 This is basic spring boot crud application with rest api

API endpoints

##### GET

`http://localhost:8080/api/v1/getusers`

`http://localhost:8080/api/v1/getuser/1`

`http://localhost:8080/api/v1/getlast5`

##### POST

`http://localhost:8080/api/v1/adduser`

<pre>
{   "user":{
        "name":"nuwan",
        "email":"nuwan@gmail.com",
        "password":"pwd652",
        "phone":"0711234657",
        "role":"BA",
        "locations":[
            {
                "id":1,
                "address":"No.101/2,Gall road,Moratuwa.",
                "zipcode":"10025"
            },
            {
                "id":2,
                "address":"No.105,Gamudawa,Kamburupiyiya.",
                "zipcode":"12025"
            }
        ]
    }
}
</pre>


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


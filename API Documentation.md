### `-----------------` _Restaurant_ `-----------------`
## Get list of Restaurants (Admin)

### Request

`GET /ballot/rest/admin/restaurants`

    curl -s http://localhost:8080/ballot/rest/admin/restaurants --user admin@gmail.com:admin

### Response

    HTTP/1.1 200 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Mon, 03 Jun 2019 15:32:08 GMT
    
    [{"id":100003,"title":"Starbucks","address":"Spb, Tulskay ul, d.96","dishes":null,"votes":null},
    {"id":100004,"title":"Tokyo City","address":"Spb, pr. Tvorskogo, d.11","dishes":null,"votes":null}]

## Get a specific Restaurant (Admin)

### Request

`GET /ballot/rest/admin/restaurants/{restaurantId}`

    curl -s http://localhost:8080/ballot/rest/admin/restaurants/100003 --user admin@gmail.com:admin

### Response

    HTTP/1.1 200 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Mon, 03 Jun 2019 15:34:18 GMT
    
    {"id":100003,"title":"Starbucks","address":"Spb, Tulskay ul, d.96",
    "dishes":[{"id":100014,"title":"Cheese Toast","price":110,"date":"2018-12-04","menu":true},
                {"id":100013,"title":"Espresso","price":100,"date":"2018-12-04","menu":true},
                {"id":100011,"title":"Steak","price":350,"date":"2018-12-04","menu":true},
                {"id":100012,"title":"Tomato soup","price":150,"date":"2018-12-04","menu":true}],
    "votes":null}
    

## Create another new Restaurant (Admin)

### Request

`POST /ballot/rest/admin/restaurants`

    curl -s -X POST -d '{"title":"New Restaurant","address":"New Street, 42"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/ballot/rest/admin/restaurants --user admin@gmail.com:admin

### Response

    HTTP/1.1 201 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Mon, 03 Jun 2019 15:37:03 GMT
    
    {"id":100023,"title":"New Restaurant","address":"New Street, 42"}
    
## Update a Restaurant's state (Admin)

### Request

`PUT /ballot/rest/admin/restaurants/{restaurantId}`

    curl -s -X PUT -d '{"title":"Updated restaurant","address":"Spb, Tulskay ul, d.96"}' -H 'Content-Type: application/json' http://localhost:8080/ballot/rest/admin/restaurants/100003 --user admin@gmail.com:admin

### Response

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Mon, 03 Jun 2019 15:41:43 GMT


## Delete a specific Restaurant (Admin)

### Request

`DELETE /ballot/rest/admin/restaurants/100003/{restaurantId}`

    curl -s -X DELETE http://localhost:8080/ballot/rest/admin/restaurants/100003 --user admin@gmail.com:admin

### Response

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Mon, 03 Jun 2019 15:43:14 GMT


### `-----------------` _Dish_ `-----------------`

## Get list of Dishes From a specific Restaurant (Admin)

### Request

`GET /ballot/rest/admin/restaurants/{restaurantId}/dishes`

    curl -s http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes --user admin@gmail.com:admin

### Response

    HTTP/1.1 200 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Mon, 03 Jun 2019 15:50:38 GMT
    
    [{"id":100014,"title":"Cheese Toast","price":110,"date":"2018-12-04","menu":true},
    {"id":100008,"title":"Coca-Cola","price":50,"date":"2018-12-03","menu":false},
    {"id":100013,"title":"Espresso","price":100,"date":"2018-12-04","menu":true},
    {"id":100005,"title":"Mussels","price":450,"date":"2018-12-02","menu":false},
    {"id":100011,"title":"Steak","price":350,"date":"2018-12-04","menu":true},
    {"id":100012,"title":"Tomato soup","price":150,"date":"2018-12-04","menu":true}]


## Get a specific Dish (Admin)

### Request

`GET /ballot/rest/admin/restaurants/{restaurantId}/dishes/{dishId}`

    curl -s http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes/100005 --user admin@gmail.com:admin

### Response

    HTTP/1.1 200 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Mon, 03 Jun 2019 15:53:27 GMT
    
    {"id":100005,"title":"Mussels","price":450,"date":"2018-12-02","menu":false}



## Create another new Dish (Admin)

### Request

`POST /ballot/rest/admin/restaurants/{restaurantId}/dishes`

    curl -s -X POST -d '{"title":"New dish","price":330,"date":"2019-01-02"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes --user admin@gmail.com:admin

### Response

    HTTP/1.1 201 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: application/json;charset=UTF-8
    Transfer-Encoding: chunked
    Date: Mon, 03 Jun 2019 15:55:23 GMT
    
    {"id":100023,"title":"New dish","price":330,"date":"2019-01-02","menu":false}
    
## Update a Dish's state (Admin)

### Request

`PUT /ballot/rest/admin/restaurants/{restaurantId}/dishes/{dishId}`

    curl -s -X PUT -d '{"title":"Updated dish","price":200,"date":"2018-12-02","menu":true}' -H 'Content-Type: application/json' http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes/100005 --user admin@gmail.com:admin

### Response

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Mon, 03 Jun 2019 15:56:52 GMT

## Delete a specific Dish (Admin)

### Request

`DELETE /ballot/rest/admin/restaurants/{restaurantId}/dishes/{dishId}`

    curl -s -X DELETE http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes/100005 --user admin@gmail.com:admin

### Response

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Mon, 03 Jun 2019 15:57:27 GMT
    
### `-----------------` _Vote_ `-----------------`

## Vote (Create) For a specific Restaurant (User)

### Request

`GET /ballot//rest/profile/votes/{restaurantId}`

    curl -s http://localhost:8080/ballot/rest/profile/votes/100004 --user user1@yandex.ru:password

### Response

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Mon, 03 Jun 2019 16:01:25 GMT

## ReVote (Update) For a specific Restaurant (User)

### Request

`GET /ballot//rest/profile/votes/{restaurantId}`

    curl -s http://localhost:8080/ballot/rest/profile/votes/100004 --user user1@yandex.ru:password

### Response

##### (If before 11:00)

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Mon, 03 Jun 2019 10:01:25 GMT

##### (If after 11:00)

    HTTP/1.1 406 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: text/html;charset=utf-8
    Content-Language: ru
    Content-Length: 1226
    Date: Mon, 03 Jun 2019 16:03:46 GMT
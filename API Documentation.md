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
    Date: Wed, 09 Jan 2019 11:21:45 GMT

    [{"id":100003,"title":"Starbucks","address":"Spb, Tulskay ul, d 96","dishes":null,"votes":null},
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
    Date: Wed, 09 Jan 2019 11:23:56 GMT

    {"id":100003,"title":"Starbucks","address":"Spb, Tulskay ul, d.96","dishes":null,"votes":null}
    

## Get a specific Dish (Admin)

### Request

`GET /ballot/rest/admin/restaurants/{restaurantId}/dishes/{dishId}`

    curl -s http://localhost:8080/ballot/rest/admin/restaurants/100004/dishes/100010 
    --user admin@gmail.com:admin

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
    Date: Wed, 09 Jan 2019 11:26:48 GMT

    {"id":100010,"restaurant":null,"description":"Fish","price":250,"date":"2018-12-04T07:00:00"}


## Delete a specific Dish (Admin)

### Request

`DELETE /ballot/rest/admin/restaurants/{restaurantId}/dishes/{dishId}`

    curl -s -X DELETE http://localhost:8080/ballot/rest/admin/restaurants/100004/dishes/100010 
    --user admin@gmail.com:admin

### Response

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Wed, 09 Jan 2019 11:30:12 GMT

## Create another new Restaurant (Admin)

### Request

`POST /ballot/rest/admin/restaurants`

    curl -s -X POST -d '{"title":"New Restaurant","address":"New Street, 42"}' -H 
    'Content-Type:application/json;charset=UTF-8' http://localhost:8080/ballot/rest/admin/restaurants 
    --user admin@gmail.com:admin

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
    Date: Wed, 09 Jan 2019 11:47:30 GMT

    {"id":100018,"title":"New Restaurant","address":"New Street, 42"}

## Update a Dish's state (Admin)

### Request

`PUT /ballot/rest/admin/restaurants/{restaurantId}/dishes/{dishId}`

    curl -s -X PUT -d '{"description":"Updated Dish" ,"price":200, "date":"2019-01-02T07:00"}' 
    -H 'Content-Type: application/json' http://localhost:8080/ballot/rest/admin/restaurants/100004/dishes/100010 
    --user admin@gmail.com:admin

### Response

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Wed, 09 Jan 2019 11:50:08 GMT

## Get list of Restaurants (User)

### Request

`GET /ballot/rest/profile/restaurants`

    curl -s http://localhost:8080/ballot/rest/profile/restaurants --user user1@yandex.ru:password

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
    Date: Wed, 09 Jan 2019 11:53:37 GMT

    [{"id":100003,"title":"Starbucks","address":"Spb, Tulskay ul, d.96","dishes":null,"votes":null},
    {"id":100004,"title":"Tokyo City","address":"Spb, pr. Tvorskogo, d.11","dishes":null,"votes":null}]

## Get list of Dishes From a specific Restaurant (User)

### Request

`GET /ballot/rest/profile/restaurants/{restaurantId}/dishes`

    curl -s http://localhost:8080/ballot/rest/profile/restaurants/100004/dishes 
    --user user1@yandex.ru:password

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
    Date: Wed, 09 Jan 2019 11:55:50 GMT

    [{"id":100013,"restaurant":null,"description":"Cheesecake","price":130,"date":"2018-12-04T07:00:00"},
    {"id":100010,"restaurant":null,"description":"Fish","price":250,"date":"2018-12-04T07:00:00"},
    {"id":100012,"restaurant":null,"description":"Gazpacho","price":300,"date":"2018-12-04T07:00:00"},
    {"id":100011,"restaurant":null,"description":"Ice tea","price":70,"date":"2018-12-04T07:00:00"},
    {"id":100009,"restaurant":null,"description":"Vegetable salad","price":200,"date":"2018-12-04T07:00:00"}]

## Vote (Create Or Update) For a specific Restaurant (User)

### Request

`GET /ballot/rest/profile/restaurants/{restaurantId}/vote`

    curl -s http://localhost:8080/ballot/rest/profile/restaurants/100004/vote 
    --user user1@yandex.ru:password

### Response

# (If after 11:00)

    HTTP/1.1 406 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Content-Type: text/html;charset=utf-8
    Content-Language: en
    Content-Length: 1209
    Date: Wed, 09 Jan 2019 11:58:55 GMT

# (If before 11:00)

    HTTP/1.1 204 
    Cache-Control: no-cache, no-store, max-age=0, must-revalidate
    Pragma: no-cache
    Expires: 0
    X-XSS-Protection: 1; mode=block
    X-Frame-Options: DENY
    X-Content-Type-Options: nosniff
    Date: Wed, 09 Jan 2019 12:00:46 GMT

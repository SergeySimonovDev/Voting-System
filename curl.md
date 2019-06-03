### curl samples (application deployed in application context `ballot`).
> For windows use `Git Bash`

#### _RestaurantAdminRestController_

#### get All Restaurants 
`curl -s http://localhost:8080/ballot/rest/admin/restaurants --user admin@gmail.com:admin`

#### get Restaurant 100003 with dishes (menu) 
`curl -s http://localhost:8080/ballot/rest/admin/restaurants/100003 --user admin@gmail.com:admin`

#### create Restaurant
`curl -s -X POST -d '{"title":"New Restaurant","address":"New Street, 42"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/ballot/rest/admin/restaurants --user admin@gmail.com:admin`

#### update Restaurant 100003
`curl -s -X PUT -d '{"title":"Updated restaurant","address":"Spb, Tulskay ul, d.96"}' -H 'Content-Type: application/json' http://localhost:8080/ballot/rest/admin/restaurants/100003 --user admin@gmail.com:admin`

#### delete Restaurant 100003 
`curl -s -X DELETE http://localhost:8080/ballot/rest/admin/restaurants/100003 --user admin@gmail.com:admin`

#### _RestaurantUserRestController_

#### get Restaurant 100003 with dishes (menu) 
`curl -s http://localhost:8080/ballot/rest/profile/restaurants/100003 --user user1@yandex.ru:password`

#### get All Restaurants
`curl -s http://localhost:8080/ballot/rest/profile/restaurants --user user1@yandex.ru:password`

#### _DishRestController_

#### get All Dishes by Restaurant 100003
`curl -s http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes --user admin@gmail.com:admin`

#### get Dish 100005
`curl -s http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes/100005 --user admin@gmail.com:admin`

#### create Dish
`curl -s -X POST -d '{"title":"New dish","price":330,"date":"2019-01-02"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes --user admin@gmail.com:admin`

#### update Dish 100005
`curl -s -X PUT -d '{"title":"Updated dish","price":200,"date":"2018-12-02","menu":true}' -H 'Content-Type: application/json' http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes/100005 --user admin@gmail.com:admin`

#### delete Dish 100005 
`curl -s -X DELETE http://localhost:8080/ballot/rest/admin/restaurants/100003/dishes/100005 --user admin@gmail.com:admin`

#### _VoteRestController_

#### vote (Create Or Update) For Restaurant 100004 From User 100000 (Update, if it is before 11:00))
`curl -s http://localhost:8080/ballot/rest/profile/votes/100004 --user user1@yandex.ru:password`



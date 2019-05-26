### curl samples (application deployed in application context `ballot`).
> For windows use `Git Bash`

#### get All Restaurants (By Admin)
`curl -s http://localhost:8080/ballot/rest/admin/restaurants --user admin@gmail.com:admin`

#### get All Restaurants (By User)
`curl -s http://localhost:8080/ballot/rest/profile/restaurants --user user1@yandex.ru:password`

#### get Restaurants 100003 (By Admin)
`curl -s http://localhost:8080/ballot/rest/admin/restaurants/100003 --user admin@gmail.com:admin`

#### get All Dishes From Restaurants 100004 (By User)
`curl -s http://localhost:8080/ballot/rest/profile/restaurants/100004/dishes --user user1@yandex.ru:password`

#### get Dishes 100010 From Restaurants 100004 (By Admin)
`curl -s http://localhost:8080/ballot/rest/admin/restaurants/100004/dishes/100010 --user admin@gmail.com:admin`

#### get Dishes 100044 not found (By User)
`curl -s http://localhost:8080/ballot/rest/profile/restaurants/100004/dishes/100044 --user user1@yandex.ru:password`

#### delete Dishes 100010 (By Admin)
`curl -s http://localhost:8080/ballot/rest/profile/restaurants/100004/dishes/100044 --user user1@yandex.ru:password`

#### create Restaurants (By Admin)
`curl -s -X POST -d '{"title":"New Restaurant","address":"New Street, 42"}' -H 'Content-Type:application/json;charset=UTF-8' http://localhost:8080/ballot/rest/admin/restaurants --user admin@gmail.com:admin`

#### update Dishes 100010 From Restaurants 100004 (By Admin)
`curl -s -X PUT -d '{"description":"Updated Dish" ,"price":200, "date":"2019-01-02T07:00"}' -H 'Content-Type: application/json' http://localhost:8080/ballot/rest/admin/restaurants/100004/dishes/100010 --user admin@gmail.com:admin`

#### vote (Create Or Update) For Restaurant 100004 From User 100000 (If it is before 11:00, By User))
`curl -s http://localhost:8080/ballot/rest/profile/restaurants/100004/vote --user user1@yandex.ru:password`



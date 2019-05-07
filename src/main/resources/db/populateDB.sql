DELETE FROM votes;
DELETE FROM dishes;
DELETE FROM restaurants;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password, role) VALUES
  ('TestUser1', 'user1@yandex.ru', 'password', 'ROLE_USER'),
  ('TestUser2', 'user2@yandex.ru', 'password', 'ROLE_USER'),
  ('Admin', 'admin@gmail.com', 'admin', 'ROLE_ADMIN');
  
INSERT INTO restaurants (title, address) VALUES
  ('Starbucks', 'Spb, Tulskay ul, d.96'),
  ('Tokyo City', 'Spb, pr. Tvorskogo, d.11');
  
INSERT INTO dishes (restaurant_id, description, price, date_time) VALUES
  (100003, 'Steak', 350,           '2018-12-04 06:00:00'),
  (100003, 'Tomato soup', 150,     '2018-12-04 06:00:00'),
  (100003, 'Espresso', 100,        '2018-12-04 06:00:00'),
  (100003, 'Cheese Toast', 110,    '2018-12-04 06:00:00'),
  (100004, 'Vegetable salad', 200, '2018-12-04 07:00:00'),
  (100004, 'Fish', 250,            '2018-12-04 07:00:00'),
  (100004, 'Ice tea', 70,          '2018-12-04 07:00:00'),
  (100004, 'Gazpacho', 300,        '2018-12-04 07:00:00'),
  (100004, 'Cheesecake', 130,      '2018-12-04 07:00:00');
  
INSERT INTO votes (user_id, restaurant_id, date) VALUES
  (100000, 100003, '2018-12-03'),
  (100001, 100004, '2018-12-03'),
  (100000, 100004, '2018-12-04'),
  (100001, 100003, '2018-12-04');
INSERT INTO USERS(USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES
    ('CaseyRHarding', 'Casey', 'Casey', 'Harding', 'casey.r.harding@gmail.com', 'I like birthdays'),
    ('AnnaAnna', 'Anna', 'Anna', 'L', 'Anna@anna.com', 'I love birthdays');

INSERT INTO BIRTHDAYS (CREATOR, TITLE, DESCRIPTION, TOTAL_GIVEN)
VALUES
    (1, 'It is my birthday!', 'Please give me lots of gifts....', 0),
    (2, 'I really just want a new car.', 'Theres no real celebration I guess...except for me getting a new car.', 0);

 INSERT INTO GIFTS (TITLE, DESCRIPTION, BIRTHDAY_ID, AMOUNT)
VALUES
    ('Car', 'This is a really cool car!', 1, 50000),
    ('Cake', 'All I want is cake...', 2, 100);
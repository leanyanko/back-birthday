INSERT INTO USERS(USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES
    ('CaseyRHarding', 'Casey', 'Casey', 'Harding', 'casey.r.harding@gmail.com', 'I like birthdays'),
    ('AnnaAnna', 'Anna', 'Anna', 'L', 'Anna@anna.com', 'I love birthdays');

INSERT INTO BIRTHDAYS (CREATOR, TOTAL_GIVEN)
VALUES
    (1, 0),
    (2, 0);

 INSERT INTO GIFTS (TITLE, DESCRIPTION, BIRTHDAY_ID, AMOUNT)
VALUES
    ('Car', 'This is a really cool car!', 1, 50000),
    ('Cake', 'All I want is cake...', 2, 100);
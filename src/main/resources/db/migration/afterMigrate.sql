INSERT INTO USERS(USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, ABOUT_ME)
VALUES
    ('CRHarding', 'Casey', 'Casey', 'Harding', 'casey.r.harding@gmail.com', 'I like birthdays'),
    ('AnnaAnna', 'Anna', 'L', 'Anna@anna.com', 'I love birthdays');

INSERT INTO BIRTHDAYS (CREATOR, WANTED_GIFTS)
VALUES
    (1, 1),
    (2, 2);

INSERT INTO GIFTS (TITLE, DESCRIPTION, AMOUNT)
VALUES
    ('Car', 'This is a really cool car!', 50000),
    ('Cake', 'All I want is cake...', 100);

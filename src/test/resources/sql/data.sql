INSERT INTO users (id, username, name, gender, birth_date, weight)
VALUES (1, 'david@mail.ru', 'David', 'MAN', '1992-11-02', 76.5),
       (2, 'alina@mail.ru', 'Alina', 'WOMAN', '1995-10-08', 60.5),
       (3, 'sveta@mail.ru', 'Sveta', 'WOMAN', '1999-10-10', 60.7);
SELECT SETVAL('users_id_seq', (SELECT MAX(id) FROM users));

INSERT INTO nutrition (id, protein, carbohydrates, fats, date, user_id)
VALUES (1, 103, 1100, 30, '2024-08-20', 1),
       (2, 30, 500, 21, '2024-08-21', 1),
       (3, 111, 542, 28, '2024-08-23', 1),
       (4, 20, 324, 27, '2024-08-18', 2),
       (5, 88, 851, 22, '2024-08-17', 3);
SELECT SETVAL('nutrition_id_seq', (SELECT MAX(id) FROM nutrition));


INSERT INTO workouts (id, date, user_id)
VALUES (1, '2024-08-20', 1),
       (2, '2024-08-21', 1),
       (3, '2024-08-23', 1),
       (4, '2024-08-18', 2),
       (5, '2024-08-17', 3);
SELECT SETVAL('workouts_id_seq', (SELECT MAX(id) FROM workouts));


INSERT INTO exercises (id, workout_id, name, weight, distance, report, repeat)
VALUES (1, 1, 'Штанга на грудь', 27.5, null, '3 подхода, сил было мало', 15),
       (2, 2, 'Штанга на спину', 27.5, null, '3 подхода, нормально чувствовал', 12),
       (3, 3, 'Подъём на ноги', 50.5, null, '3 подхода, всё хорошо', 12),
       (4, 4, 'Бег', null, 1.2, 'Пробежка для разогрева', null);
SELECT SETVAL('exercises_id_seq', (SELECT MAX(id) FROM exercises));
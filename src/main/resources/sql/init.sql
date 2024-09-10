CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY ,
    username VARCHAR(64) NOT NULL UNIQUE ,
    name VARCHAR(64) ,
    gender VARCHAR(32) ,
    birth_date DATE ,
    weight DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS nutrition
(
    id BIGSERIAL PRIMARY KEY ,
    protein SMALLINT ,
    carbohydrates SMALLINT ,
    fats SMALLINT ,
    date DATE NOT NULL ,
    user_id BIGINT NOT NULL REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS workouts
(
    id BIGSERIAL PRIMARY KEY ,
    date DATE NOT NULL ,
    user_id BIGINT NOT NULL REFERENCES users (id)
);

CREATE TABLE IF NOT EXISTS exercises
(
    id BIGSERIAL PRIMARY KEY ,
    workout_id BIGINT NOT NULL REFERENCES workouts (id) ,
    name VARCHAR(64) ,
    weight DOUBLE PRECISION ,
    distance DOUBLE PRECISION ,
    report VARCHAR(64) ,
    repeat SMALLINT
);


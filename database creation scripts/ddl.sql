CREATE TABLE Member (
    member_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    weight_goal INTEGER,
    time_goal INTEGER,
    resting_heart_rate INTEGER,
    BMI DECIMAL (10,2)
);

CREATE TABLE Dashboard (
    dashboard_id SERIAL PRIMARY KEY,
    member_id INTEGER REFERENCES Member(member_id),
    km_to_run INTEGER,
    number_of_pushups INTEGER,
    weight_lost INTEGER,
    steps_walked_per_day INTEGER,
    resting_heart_rate INTEGER,
    BMI DECIMAL (10,2)
);

CREATE TABLE Trainer (
    trainer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Training_Session (
    session_id SERIAL PRIMARY KEY,
    type_PG VARCHAR(255) NOT NULL,
    time_slot VARCHAR(255) NOT NULL,
    trainer_id INTEGER REFERENCES Trainer(trainer_id),
    member_id INTEGER
);

CREATE TABLE Admin_Info (
    admin_id SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE Payment (
    payment_id SERIAL PRIMARY KEY,
    amount DECIMAL (10,2),
    status_update VARCHAR(255) NOT NULL,
    date_record DATE,
    member_id INTEGER REFERENCES Member(member_id)
);

CREATE TABLE Room (
    room_id SERIAL PRIMARY KEY,
    name_info VARCHAR(255) NOT NULL,
    status_update VARCHAR(255) NOT NULL,
    capacity INTEGER
);

CREATE TABLE Equipment (
    equipment_id SERIAL PRIMARY KEY,
    name_info VARCHAR(255) NOT NULL,
    status_update VARCHAR(255) NOT NULL,
    last_maintanence_date DATE
);
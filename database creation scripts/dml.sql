INSERT INTO Member (first_name, last_name, weight_goal, time_goal, resting_heart_rate, BMI)
VALUES 
('John', 'Smith', 80, 50, 62, 18.5),
('Patrick', 'Kane', 76, 60, 70, 20.3),
('Emily', 'White', 78, 65, 75, 22.5);

INSERT INTO Dashboard (member_id, km_to_run, number_of_pushups, weight_lost, steps_walked_per_day, resting_heart_rate, BMI)
VALUES 
(1, 5, 10, 6, 7000, 62, 18.5),
(2, 6, 11, 7, 8300, 70, 20.3),
(3, 7, 12, 8, 6800, 75, 22.5);

INSERT INTO Trainer (first_name, last_name, email)
VALUES 
('Jay', 'Patel', 'jay.patel@fitness.com'),
('Mark', 'Jerry', 'mark.jerry@fitness.com'),
('Ali', 'Khan', 'ali.khan@fitness.com');

INSERT INTO Training_Session (type_PG, time_slot, trainer_id, member_id)
VALUES 
('personal', '10:00-1:30', 1, 0),
('group', '11:00-12:30', 2, 0),
('personal', '2:00-3:30', 3, 0);

INSERT INTO Admin_Info (first_name, last_name, email)
VALUES 
('Charles', 'Fall', 'charles.fall@fitness.com'),
('Diya', 'Shah', 'diya.shah@fitness.com'),
('Hanna', 'Gabriel', 'hanna.gabriel@fitness.com');

INSERT INTO Payment (amount, status_update, date_record, member_id)
VALUES 
(81.46, 'Paid', '2024-03-25', 1),
(82.54, 'Pending', '2024-03-27', 2),
(83.04, 'Paid', '2024-03-29', 3);

INSERT INTO Room (name_info, status_update, capacity)
VALUES 
('Weights', 'Available', 101),
('Cardiovascular', 'Occupied', 75),
('Stretching', 'Available', 110);

INSERT INTO Equipment (name_info, status_update, last_maintanence_date)
VALUES 
('Treadmill', 'not clean', '2024-03-25'),
('Elliptical', 'clean', '2024-03-31'),
('Stationary Bike', 'not clean', '2024-03-03');
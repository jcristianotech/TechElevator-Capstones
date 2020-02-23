BEGIN TRANSACTION;

INSERT INTO users (first_name, last_name, email, password)
VALUES ('Luke', 'Tuch', 'luketheduke39@gmail.com', 'Lukeingforpotholes');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Hunter', 'Strand', 'hutingstrand@gmail.com', 'potholeHunter');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Chase', 'Yoder', 'theyoderler53@gmail.com', 'YoderLayHeeHoo');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Danny', 'Weight', 'ohdannyboy29@gmail.com', 'WeightLifter');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Brock', 'Faber', 'Fabercated34@gmail.com', 'FaberFarAway');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Eamon', 'Powell', 'eamonp46@gmail.com', 'EamonPassThePuck');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Connor', 'Kelley', 'kelleyc@gmail.com', 'KelleyTheBoy');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Tyler', 'Kleven', 'KlevenScores@gmail.com', 'KlevenGameStreak');
INSERT INTO users (first_name, last_name, email, password)
VALUES ('Daniel', 'Laatsch', 'laatschd@gmail.com', 'DoubleAFun');


INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (1, 'Jack', 'Hughes', 'jhughes@cityofdetroit.net', 'Potholehockey');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (2, 'Spencer', 'Knight', 'sknight@cityofdetroit.net', 'FillthHole');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (3, 'Trevor', 'Zegras', 'tzegras@cityofdetroit.net', 'Password135');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (4, 'Cole', 'Caufield', 'ccaufield@cityofdetroit.net', 'Edvat@%$re');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (5, 'Case', 'McCarthy', 'cmccarthy@cityofdetroit.net', 'onTheCase');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (6, 'Alex', 'Turcotte', 'aturcotte@cityofdetroit.net', 'TurcotteAWarrior');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (7, 'Matthew', 'Boldy', 'mboldy@cityofdetroit.net', 'BoldyPatching');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (8, 'Cam', 'York', 'cyork@cityofdetroit.net', 'YorkyDoodle');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (9, 'John', 'Beecher', 'jbeecher@cityofdetroit.net', 'BeecherBum');
INSERT INTO staff (staff_id, first_name, last_name, email, password)
VALUES (10, 'Bobby', 'Brink', 'bbrink@cityofdetroit.net', 'onTheBrink');


SELECT users.user_id FROM users
JOIN potholes ON potholes.user_id = users.user_id;
SELECT staff.staff_id FROM staff
JOIN potholes ON potholes.staff_id = staff.staff_id;

INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (1, '42.365920', '-83.072291', 10, '2019-08-20', '2019-08-21', null, 2, 'Minor pothole, should be an easy fix.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (4, '42.328155', '-83.050504', 1, '2019-08-20',  '2019-08-21', null, 5, 'This pothole is a danger to all drivers and should be repaired ASAP.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (4, '42.364670', '-83.067960', 8, '2019-08-20', '2019-08-21', null, 1, 'An inconvenience, but not urgent.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (2, '42.320814', '-83.077144', 9, '2019-08-20', '2019-08-21', null, 5, 'Deep pothole, rebar visible. Needs urgent repairs.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (1, '42.365920', '-83.072291', 4, '2019-08-20', '2019-08-22', '2019-08-23', 5, 'This pothole is a danger to all drivers and should be repaired ASAP. This pothole has been repaired.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (4, '42.328155', '-83.050504', null, '2019-08-20', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (4, '42.364670', '-83.067960', 6, '2019-08-20', '2019-08-21', null, 4, 'Not too deep, but in a hard location to repair.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (2, '42.320814', '-83.077144', null,'2019-08-20', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (6, '42.377177', '-83.114662', null,'2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (1, '42.390152', '-83.082859', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (2, '42.346950', '-83.001916', 7, '2019-08-26', '2019-08-26', null, 5, 'Deep pothole.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (4, '42.353364', '-82.995971', null,'2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (7, '42.360482', '-82.996036', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (9, '42.379927', '-83.032891', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (3, '42.434644', '-83.155623', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (3, '42.433882', '-83.153908', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (3, '42.433519', '-83.153091', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (1, '42.431454', '-83.154278', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (6, '42.365041', '-83.067135', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (6, '42.375570', '-83.113658', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (3, '42.377725', '-83.115056', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (1, '42.377626', '-83.115079', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (1, '42.359896', '-83.137799', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (1, '42.347440', '-83.165924', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (4, '42.417211', '-83.137845', null, '2019-08-26', null, null, null, null);
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (5, '42.446112', '-83.141148', 5, '2019-08-26', '2019-08-26', null, 2, 'Minor pothole, should be an easy fix. Located on Detroit side of 8 Mile Rd.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (6, '42.445858', '-83.150864', 5, '2019-08-26', '2019-08-26', null, 4, 'Severe pothole, fix during non-rush hours. Located on Detroit side of 8 Mile Rd.');
INSERT INTO potholes (user_id, latitude, longitude, staff_id, date_reported, date_inspected, date_repaired, rank, description) VALUES (7, '42.375463', '-83.110126', null, '2019-08-26', null, null, null, null);


COMMIT TRANSACTION;  
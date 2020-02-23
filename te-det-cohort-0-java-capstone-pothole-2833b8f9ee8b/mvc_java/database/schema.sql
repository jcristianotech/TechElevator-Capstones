BEGIN TRANSACTION;

CREATE TABLE users
(
        user_id SERIAL,
		first_name VARCHAR (40),
		last_name VARCHAR (30),
        email VARCHAR (40) NOT NULL,
        password VARCHAR (32) NOT NULL,
        salt VARCHAR (256),
        
        CONSTRAINT pk_users PRIMARY KEY (user_id)
);

CREATE TABLE staff
(
        staff_id INTEGER,
		first_name VARCHAR (40),
		last_name VARCHAR (30),
        email VARCHAR (40) NOT NULL,
        password VARCHAR (32) NOT NULL,
        salt VARCHAR (256),
        
        CONSTRAINT pk_staff PRIMARY KEY (staff_id)
);

CREATE TABLE potholes
(
        pothole_id SERIAL,
        user_id INTEGER NOT NULL,
		latitude NUMERIC NOT NULL,
		longitude NUMERIC NOT NULL,
		staff_id INTEGER,
		date_reported TIMESTAMP(6) WITHOUT TIME ZONE,		
        date_inspected DATE,
		date_repaired DATE,
		rank INTEGER,
		description VARCHAR (500),

        
        CONSTRAINT pk_potholes PRIMARY KEY (pothole_id),
        CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users (user_id),
		CONSTRAINT fk_staff FOREIGN KEY (staff_id) REFERENCES staff (staff_id)
);
COMMIT TRANSACTION;
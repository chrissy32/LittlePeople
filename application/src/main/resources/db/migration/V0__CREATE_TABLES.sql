CREATE TABLE IF NOT EXISTS Hospital(id SERIAL PRIMARY KEY,
      name VARCHAR(50) NOT NULL,
      city VARCHAR(50) NOT NULL,
      address VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS Leader(id serial PRIMARY KEY,
      username VARCHAR(50) UNIQUE NOT NULL,
      password VARCHAR(100) NOT NULL,
      email VARCHAR(100) UNIQUE NOT NULL,
      phone VARCHAR(15) UNIQUE,
      firstName VARCHAR(100),
      surname VARCHAR(100));

CREATE TABLE IF NOT EXISTS Volunteer(id serial PRIMARY KEY,
      username VARCHAR(50) UNIQUE NOT NULL,
      password VARCHAR(100) NOT NULL,
      email VARCHAR(100) UNIQUE NOT NULL,
      phone VARCHAR(15) UNIQUE,
      firstName VARCHAR(100),
      surname VARCHAR(100),
      hospital INT,
      FOREIGN KEY(hospital) REFERENCES Hospital(id));

CREATE TABLE IF NOT EXISTS Proposal(id serial PRIMARY KEY,
      proposedBy VARCHAR(100) NOT NULL,
      description VARCHAR(255) NOT NULL,
      category VARCHAR(50),
      title VARCHAR(100),
      status VARCHAR(10) NOT NULL,
      hospital INT,
      FOREIGN KEY(hospital) REFERENCES Hospital(id));

CREATE TABLE IF NOT EXISTS Activity(id serial PRIMARY KEY,
      description VARCHAR(255) NOT NULL,
      category VARCHAR(50) NOT NULL,
      title VARCHAR(100) NOT NULL,
      status VARCHAR(12) NOT NULL,
      dateAndTime TIMESTAMP NOT NULL,
      hospital INT,
      FOREIGN KEY(hospital) REFERENCES Hospital(id));

CREATE TABLE IF NOT EXISTS Report(id serial PRIMARY KEY,
      description VARCHAR(255) NOT NULL,
      category VARCHAR(50) NOT NULL,
      title VARCHAR(100) NOT NULL,
      text VARCHAR(255) NOT NULL,
      hospital INT,
      activity INT,
      FOREIGN KEY(hospital) REFERENCES Hospital(id),
      FOREIGN KEY(activity) REFERENCES Activity(id));

CREATE TABLE IF NOT EXISTS Hospital_Leader(id serial PRIMARY KEY,
      hospital int NOT NULL,
      leader int NOT NULL,
      UNIQUE(hospital, leader),
      FOREIGN KEY(hospital) REFERENCES Hospital(id),
      FOREIGN KEY(leader) REFERENCES Leader(id));

CREATE TABLE IF NOT EXISTS Activity_Volunteer(id serial PRIMARY KEY,
      activity int NOT NULL,
      volunteer int NOT NULL,
      UNIQUE(activity, volunteer),
      FOREIGN KEY(activity) REFERENCES Activity(id),
      FOREIGN KEY(volunteer) REFERENCES Volunteer(id));
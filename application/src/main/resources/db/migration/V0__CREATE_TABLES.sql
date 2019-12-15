CREATE TABLE IF NOT EXISTS Hospital(id SERIAL PRIMARY KEY,
      name VARCHAR(50) NOT NULL,
      city VARCHAR(50) NOT NULL,
      address VARCHAR(255) NOT NULL);

CREATE TABLE IF NOT EXISTS User(id serial PRIMARY KEY,
      username VARCHAR(50) UNIQUE NOT NULL,
      password VARCHAR(100) NOT NULL,
      email VARCHAR(100) UNIQUE NOT NULL,
      phone VARCHAR(15) UNIQUE,
      firstName VARCHAR(100),
      surname VARCHAR(100),
      city VARCHAR(100),
      isAdmin BOOLEAN,
      hospital BIGINT UNSIGNED,
      FOREIGN KEY(hospital) REFERENCES Hospital(id));

CREATE TABLE IF NOT EXISTS Proposal(id serial PRIMARY KEY,
      proposedBy VARCHAR(100) NOT NULL,
      description VARCHAR(255) NOT NULL,
      category VARCHAR(50),
      title VARCHAR(100),
      status VARCHAR(10) NOT NULL,
      hospital BIGINT UNSIGNED,
      FOREIGN KEY(hospital) REFERENCES Hospital(id));

CREATE TABLE IF NOT EXISTS Activity(id serial PRIMARY KEY,
      description VARCHAR(255) NOT NULL,
      category VARCHAR(50) NOT NULL,
      title VARCHAR(100) NOT NULL,
      status VARCHAR(12) NOT NULL,
      dateAndTime TIMESTAMP NOT NULL,
      hospital BIGINT UNSIGNED,
      FOREIGN KEY(hospital) REFERENCES Hospital(id));

CREATE TABLE IF NOT EXISTS Report(id serial PRIMARY KEY,
      description VARCHAR(255) NOT NULL,
      category VARCHAR(50) NOT NULL,
      title VARCHAR(100) NOT NULL,
      text VARCHAR(255) NOT NULL,
      hospital BIGINT UNSIGNED,
      activity BIGINT UNSIGNED,
      FOREIGN KEY(hospital) REFERENCES Hospital(id),
      FOREIGN KEY(activity) REFERENCES Activity(id));


CREATE TABLE IF NOT EXISTS Activity_User(id serial PRIMARY KEY,
      activity BIGINT UNSIGNED NOT NULL,
      user BIGINT UNSIGNED NOT NULL,
      UNIQUE(activity, user),
      FOREIGN KEY(activity) REFERENCES Activity(id),
      FOREIGN KEY(user) REFERENCES User(id));

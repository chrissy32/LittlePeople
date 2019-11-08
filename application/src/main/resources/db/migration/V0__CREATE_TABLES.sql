CREATE TABLE Users(id SERIAL PRIMARY KEY,
      username VARCHAR(100),
      email VARCHAR(100) UNIQUE,
      password VARCHAR(255),
      isAdmin BOOLEAN);

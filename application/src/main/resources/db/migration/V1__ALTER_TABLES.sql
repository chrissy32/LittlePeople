CREATE TABLE Hospitals(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  city VARCHAR(255)
);

ALTER TABLE Users ADD hospitalId SERIAL;
ALTER TABLE Users ADD FOREIGN KEY (hospitalId) REFERENCES Hospitals(id);
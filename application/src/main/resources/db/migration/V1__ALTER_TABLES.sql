CREATE TABLE Hospitals(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255),
  city VARCHAR(255)
);

ALTER TABLE Users ADD hospital INT;
ALTER TABLE Users ADD FOREIGN KEY (hospital) REFERENCES Hospitals(id);
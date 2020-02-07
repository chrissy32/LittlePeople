INSERT INTO Hospital(name, city, address) VALUES
          ('Pediatric Oncology Unit in the Oncology Institute “Prof. Dr. I. Chiricuta”', 'Cluj-Napoca', 'Strada Republicii no. 34-36'),
          ('Pediatric Oncology Unit in the Clinic Children’s Hospital, Pediatric Clinic II', 'Cluj-Napoca', 'Strada Crisan no. 3-5'),
          ('Hematology and Oncology Department in the Emergency Clinical Hospital for Children “Louis Turcanu”', 'Timisoara', 'Strada Doctor Iosif Nemoianu no. 2'),
          ('Hematology and Oncology Department in the Emergency Hospital for Children “Sf. Maria”', 'Iasi', 'Strada Vasile Lupu no. 62'),
          ('Pediatric Oncology Department in the Emergency Clinical Hospital for Children “Maria Sklodowska Curie”', 'Bucharest', 'Bulevardul Constantin Brâncoveanu no. 20'),
          ('Pediatric Oncology Department in the Oncology Institute “Prof. Dr. Al. Trestioreanu”', 'Bucharest', 'Soseaua Fundeni no. 252' ),
          ('Hematology and Oncology Department, Pediatric Clinic 2 in the Clinical Institute', 'Bucharest', ' Calea București no. 258'),
          ('Pediatric Department in the Mureș County Hospital', 'Targu Mures', 'Dr. Gh. Marinescu street no. 50'),
          ('Hematology Department and Pediatric Oncology Department in the Oncology Institute', 'Chisinau', 'Strada Nicolae Testemitanu 30');

INSERT INTO User(username, password, email, phone, firstName, surname, city, isAdmin, hospital) VALUES
          ('leader1', '1234', 'leader1@gmail.com', '0720321456', 'firstName', 'surname', 'Cluj-Napoca',true,null);

INSERT INTO User(username, password, email, phone, firstName, surname, city, isAdmin, hospital)  VALUES
          ('moisit', '1234', 'moisit@gmail.com', '0720321458', 'Teofana', 'Moisi','Cluj-Napoca',false, 1);

INSERT INTO Proposal(proposedBy, description, category, title, status, startDateAndTime, endDateAndTime, hospital) VALUES
('moisit', 'description1', 'games', 'title1', 'PENDING', '2020-01-01 12:17:55','2020-01-01 14:17:55', 2);

INSERT INTO Activity(description, category, title, status, startDateAndTime, endDateAndTime, hospital) VALUES
('description1', 'games', 'title1', 'IN_PROGRESS', '2019-12-12 12:17:55','2019-12-12 14:00:00', 1);

INSERT INTO Report(description, category, title, text,  activity) VALUES
          ('description1', 'games', 'title1', 'text1', 1);

INSERT INTO Activity_User(activity, user) VALUES
          (1, 1);



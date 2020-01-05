INSERT INTO Hospital(name, city, address) VALUES
          ('Spitalul Clinic de Urgenta pentru Copii', 'Cluj-Napoca', 'Calea Motilor nr. 68'),
          ('Regina Maria', 'Cluj-Napoca', 'Strada Louis Pasteur nr. 24/72');

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



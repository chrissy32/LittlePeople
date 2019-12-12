INSERT INTO Hospital(name, city, address) VALUES
          ('Spitalul Clinic de Urgenta pentru Copii', 'Cluj-Napoca', 'Calea Motilor nr. 68'),
          ('Regina Maria', 'Cluj-Napoca', 'Strada Louis Pasteur nr. 24/72');

INSERT INTO Leader(username, password, email, phone, firstName, surname) VALUES
          ('leader1', '$2y$10$lK90q8vjo.kvsgF2GcLf0O0ECs0bWOmr.4.GKKb3vBXfX0XL9kizG', 'leader1@gmail.com', '0720321456', 'firstName', 'surname');

INSERT INTO Volunteer(username, password, email, phone, firstName, surname, hospital) VALUES
          ('moisit', '$2y$10$QbdSAzvUI/2MwE.kIyLdQOKDhSmgFmuSFL.nq8Eh.tXX2IjFNcJD.', 'moisit@gmail.com', '0720321458', 'Teofana', 'Moisi', 1);

INSERT INTO Proposal(proposedBy, description, category, title, status, hospital) VALUES
          ('moisit', 'description1', 'games', 'title1', 'PENDING', 2);

INSERT INTO Activity(description, category, title, status, dateAndTime, hospital) VALUES
          ('description1', 'games', 'title1', 'IN_PROGRESS', '2019-12-12 12:17:55', 1);


INSERT INTO Report(description, category, title, text, hospital, activity) VALUES
          ('description1', 'games', 'title1', 'text1', 1, 1);

INSERT INTO Hospital_Leader(hospital, leader) VALUES
          (1, 1),
          (2, 1);

INSERT INTO Activity_Volunteer(activity, volunteer) VALUES
          (1, 1);



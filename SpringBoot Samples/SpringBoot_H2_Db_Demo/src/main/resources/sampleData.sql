
INSERT INTO Feeds(UserId, Title, Content)
VALUES
('user1@email.com','Spring Boot Demo', ' Demonstrating how spring boot works step-by-step'),
('user2@email.com','GCP', ' GCP Fundamental: Core'),
('user3@email.com','AWS', ' Fundamental of AWS services');

UPDATE Feeds SET Title = 'Spring Boot H2 Demo' WHERE UserId = 'user1@email.com'
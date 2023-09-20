-- Inserting user data
INSERT INTO User (username, password, email, role, first_name, last_name, date_of_birth, address, phone_number, employee_id)
VALUES ('john_doe', 'password123', 'john.doe@email.com', 'Employee', 'John', 'Doe', '1990-05-15', '123 Main St', '555-123-4567', 101),
       ('jane_smith', 'securepass', 'jane.smith@email.com', 'Customer', 'Jane', 'Smith', '1985-12-10', '456 Oak Ave', '555-987-6543', 201),
       ('robert_wilson', 'pass1234', 'robert.w@email.com', 'Employee', 'Robert', 'Wilson', '1988-07-25', '789 Elm Rd', '555-789-1234', 102);

-- 1. Insert into 'assessment'
INSERT IGNORE INTO assessment (id, title, total_marks, duration) 
VALUES (1, 'Java Fundamentals', 100, 60);

-- 2. Insert into 'question'
INSERT IGNORE INTO question (id, assessment_id, question_text, correct_answer, marks, optiona, optionb, optionc, optiond) 
VALUES (1, 1, 'Which keyword is used for inheritance?', 'extends', 10, 'implements', 'extends', 'inherits', 'includes');

INSERT IGNORE INTO question (id, assessment_id, question_text, correct_answer, marks, optiona, optionb, optionc, optiond) 
VALUES (2, 1, 'Default value of boolean?', 'false', 10, 'true', 'false', 'null', '0');

-- 3. Insert into 'users'
INSERT IGNORE INTO users (id, email, password, role, full_name) 
VALUES (1, 'admin@test.com', '$2a$10$8.UnVuG9HHgffUDAlk8qn.6nQH22LumWOnvSTui95KP1nADUXYY4W', 'ADMIN', 'System Admin');

-- 4. NEW: Pre-load finished results so you can use GET immediately
INSERT IGNORE INTO attempt (id, assessment_id, candidate_name, candidate_email, status, score) 
VALUES (101, 1, 'Ananta Balia', 'ananta@test.com', 'SUBMITTED', 20);

INSERT IGNORE INTO attempt (id, assessment_id, candidate_name, candidate_email, status, score) 
VALUES (102, 1, 'Demo Student', 'demo@test.com', 'SUBMITTED', 10);
INSERT INTO department_entity (id, name) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Human Resources'),
    ('22222222-2222-2222-2222-222222222222', 'Sales'),
    ('33333333-3333-3333-3333-333333333333', 'Engineering'),
    ('44444444-4444-4444-4444-444444444444', 'Systems');


INSERT INTO profile_entity
(id, user_id, email, first_name, last_name, birthday, start_date, position, salary, department_id)
VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
 '10000000-0000-0000-0000-000000000001',
 'john.doe@example.com',
 'John',
 'Doe',
 '1988-05-14',
 '2020-03-01',
 'HR Specialist',
 52000,
 '11111111-1111-1111-1111-111111111111'),

('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
 '10000000-0000-0000-0000-000000000002',
 'sarah.smith@example.com',
 'Sarah',
 'Smith',
 '1992-11-22',
 '2021-07-15',
 'Sales Manager',
 68000,
 '22222222-2222-2222-2222-222222222222'),

('cccccccc-cccc-cccc-cccc-cccccccccccc',
 '10000000-0000-0000-0000-000000000003',
 'alex.jones@example.com',
 'Alex',
 'Jones',
 '1995-01-09',
 '2019-09-10',
 'Software Engineer',
 87000,
 '33333333-3333-3333-3333-333333333333'),

('dddddddd-dddd-dddd-dddd-dddddddddddd',
 '10000000-0000-0000-0000-000000000004',
 'maria.garcia@example.com',
 'Maria',
 'Garcia',
 '1987-04-03',
 '2018-01-20',
 'System Administrator',
 74000,
 '44444444-4444-4444-4444-444444444444'),

('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee',
 '10000000-0000-0000-0000-000000000005',
 'kevin.brown@example.com',
 'Kevin',
 'Brown',
 '1990-09-17',
 '2022-02-01',
 'Recruiter',
 49000,
 '11111111-1111-1111-1111-111111111111');

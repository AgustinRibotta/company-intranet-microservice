INSERT INTO department_entity (id, name) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Human Resources'),
    ('22222222-2222-2222-2222-222222222222', 'Sales'),
    ('33333333-3333-3333-3333-333333333333', 'Engineering'),
    ('44444444-4444-4444-4444-444444444444', 'Systems');


INSERT INTO profile_entity
(id, user_id, email, first_name, last_name, birthday, start_date, position, salary, department_id)
VALUES
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa',
 'bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1',
 'alice.admin@example.com',
 'Alice Admin',
 'Doe',
 '1988-05-14',
 '2020-03-01',
 'HR Specialist',
 52000,
 '11111111-1111-1111-1111-111111111111'),

('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb',
 'bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2',
 'bob.manager@example.com',
 'Bob Manager',
 'Smith',
 '1992-11-22',
 '2021-07-15',
 'Sales Manager',
 68000,
 '22222222-2222-2222-2222-222222222222'),

('cccccccc-cccc-cccc-cccc-cccccccccccc',
 'bbbbbbb3-bbbb-bbbb-bbbb-bbbbbbbbbbb3',
 'charlie.user@example.com',
 'Charlie User',
 'Jones',
 '1995-01-09',
 '2019-09-10',
 'Software Engineer',
 87000,
 '33333333-3333-3333-3333-333333333333');


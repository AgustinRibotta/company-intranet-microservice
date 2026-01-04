-- PERMISSIONS
INSERT INTO permission_entity (id, name) VALUES
    ('10000000-0000-0000-0000-000000000001', 'READ_USERS'),
    ('10000000-0000-0000-0000-000000000002', 'CREATE_USERS'),
    ('10000000-0000-0000-0000-000000000003', 'UPDATE_USERS'),
    ('10000000-0000-0000-0000-000000000004', 'DELETE_USERS'),
    ('10000000-0000-0000-0000-000000000005', 'READ_ROLES'),
    ('10000000-0000-0000-0000-000000000006', 'CREATE_ROLES'),
    ('10000000-0000-0000-0000-000000000007', 'UPDATE_ROLES'),
    ('10000000-0000-0000-0000-000000000008', 'DELETE_ROLES'),
    ('10000000-0000-0000-0000-000000000009', 'READ_PROFILE'),
    ('10000000-0000-0000-0000-000000000011', 'UPDATE_PROFILE'),
    ('10000000-0000-0000-0000-000000000012', 'DELETE_PROFILE'),
    ('10000000-0000-0000-0000-000000000013', 'READ_DP'),
    ('10000000-0000-0000-0000-000000000014', 'CREATE_DP'),
    ('10000000-0000-0000-0000-000000000015', 'UPDATE_DP'),
    ('10000000-0000-0000-0000-000000000016', 'DELETE_DP');

-- ROLES
INSERT INTO role_entity (id, name) VALUES
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', 'ADMIN'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', 'RH'),
    ('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3', 'USER');

-- ROLE_PERMISSIONS
INSERT INTO role_permissions (role_id, permission_id) VALUES
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000001'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000002'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000003'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000004'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000005'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000006'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000007'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000008'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000009'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000011'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000012'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000013'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000014'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000015'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '10000000-0000-0000-0000-000000000016'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '10000000-0000-0000-0000-000000000009'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '10000000-0000-0000-0000-000000000011'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '10000000-0000-0000-0000-000000000012'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '10000000-0000-0000-0000-000000000013'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '10000000-0000-0000-0000-000000000014'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '10000000-0000-0000-0000-000000000015'),
    ('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3', '10000000-0000-0000-0000-000000000001');

-- USERS
INSERT INTO user_entity (id, name, email, password) VALUES
    ('bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1', 'Alice Admin', 'alice.admin@example.com', '$2a$12$GHKyaKjm9Hf6LVFLN2U88OGUuvqv8JwgSqQAf/q9n2YhTsfev60.O'),
    ('bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2', 'Bob Manager', 'bob.manager@example.com', '$2a$12$GHKyaKjm9Hf6LVFLN2U88OGUuvqv8JwgSqQAf/q9n2YhTsfev60.O'),
    ('bbbbbbb3-bbbb-bbbb-bbbb-bbbbbbbbbbb3', 'Charlie User', 'charlie.user@example.com', '$2a$12$GHKyaKjm9Hf6LVFLN2U88OGUuvqv8JwgSqQAf/q9n2YhTsfev60.O');

-- USER_ROLES
INSERT INTO user_roles (user_id, role_id) VALUES
    ('bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1', 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1'),

    ('bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2', 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2'),

    ('bbbbbbb3-bbbb-bbbb-bbbb-bbbbbbbbbbb3', 'aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3');

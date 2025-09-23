-- =======================
-- PERMISSIONS
-- =======================
INSERT INTO permission (id, name) VALUES
    ('11111111-1111-1111-1111-111111111111', 'READ_USERS'),
    ('22222222-2222-2222-2222-222222222222', 'WRITE_USERS'),
    ('33333333-3333-3333-3333-333333333333', 'DELETE_USERS'),
    ('44444444-4444-4444-4444-444444444444', 'READ_ROLES'),
    ('55555555-5555-5555-5555-555555555555', 'WRITE_ROLES');

-- =======================
-- ROLES
-- =======================
INSERT INTO role_entity (id, name) VALUES
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', 'ADMIN'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', 'MANAGER'),
    ('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3', 'USER');

-- =======================
-- ROLE_PERMISSIONS
-- =======================
-- ADMIN tiene todos los permisos
INSERT INTO role_permissions (role_id, permission_id) VALUES
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '11111111-1111-1111-1111-111111111111'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '22222222-2222-2222-2222-222222222222'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '33333333-3333-3333-3333-333333333333'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '44444444-4444-4444-4444-444444444444'),
    ('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1', '55555555-5555-5555-5555-555555555555');

-- MANAGER solo puede leer y escribir usuarios
INSERT INTO role_permissions (role_id, permission_id) VALUES
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '11111111-1111-1111-1111-111111111111'),
    ('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2', '22222222-2222-2222-2222-222222222222');

-- USER solo puede leer usuarios
INSERT INTO role_permissions (role_id, permission_id) VALUES
    ('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3', '11111111-1111-1111-1111-111111111111');

-- =======================
-- USERS
-- =======================
INSERT INTO user_entity (id, name, email, password) VALUES
    ('bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1', 'Alice Admin', 'alice.admin@example.com', '{noop}admin123'),
    ('bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2', 'Bob Manager', 'bob.manager@example.com', '{noop}manager123'),
    ('bbbbbbb3-bbbb-bbbb-bbbb-bbbbbbbbbbb3', 'Charlie User', 'charlie.user@example.com', '{noop}user123');

-- =======================
-- USER_ROLES
-- =======================
-- Alice es ADMIN
INSERT INTO user_roles (user_id, role_id) VALUES
    ('bbbbbbb1-bbbb-bbbb-bbbb-bbbbbbbbbbb1', 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaa1');

-- Bob es MANAGER
INSERT INTO user_roles (user_id, role_id) VALUES
    ('bbbbbbb2-bbbb-bbbb-bbbb-bbbbbbbbbbb2', 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaa2');

-- Charlie es USER
INSERT INTO user_roles (user_id, role_id) VALUES
    ('bbbbbbb3-bbbb-bbbb-bbbb-bbbbbbbbbbb3', 'aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaa3');

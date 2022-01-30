INSERT INTO profiles VALUES (1, 'ADMIN');
INSERT INTO profiles VALUES (2, 'COMMON');

// password: [admin]. It saves the encripted version.
INSERT INTO users VALUES (1, 'admin', 'ADMIN', '$2a$10$ubpqqxoFNkfJlsMbRuZazOBBjVGPJtk3zlsAF7tBlfRABhx4whSvS');

INSERT INTO profile_users (1, 1);
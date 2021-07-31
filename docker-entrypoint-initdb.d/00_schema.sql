-- CREATE TABLE users
-- (
--     id       BIGSERIAL PRIMARY KEY,
--     username TEXT NOT NULL
-- );

CREATE TABLE payments
(
    id       BIGSERIAL PRIMARY KEY,
    sender_id BIGINT NOT NULL,
    amount   BIGINT NOT NULL,
    comment  TEXT   NOT NULL
);


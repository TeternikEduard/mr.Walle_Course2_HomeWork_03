CREATE SCHEMA vote_app AUTHORIZATION postgres;
CREATE TABLE vote_app.vote
(
    dt_create timestamp(6) without time zone NOT NULL,
    artist character varying NOT NULL,
    genre_1 character varying NOT NULL,
    genre_2 character varying NOT NULL,
    genre_3 character varying NOT NULL,
    genre_4 character varying,
    genre_5 character varying,
    about text NOT NULL
);

ALTER TABLE IF EXISTS vote_app.vote
    OWNER to postgres;
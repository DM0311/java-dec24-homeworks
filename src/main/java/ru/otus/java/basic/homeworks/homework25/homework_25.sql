drop database if exists test_library;

create database test_library;

\c test_library;

drop schema if exists otus_homework;

create schema otus_homework;

alter role "otus_usr" with login;

drop role if exists otus_usr;

create role otus_usr with password '1234';

grant connect on database test_library to otus_usr;

grant all privileges on schema otus_homework to otus_usr;

DROP TABLE if exists otus_homework.tests;

CREATE TABLE otus_homework.tests (
	id serial NOT NULL,
	test_descr varchar NOT NULL,
	CONSTRAINT tests_pk PRIMARY KEY (id)
);

DROP TABLE if exists otus_homework.questions;

CREATE TABLE otus_homework.questions (
	id serial NOT NULL,
	"text" varchar NOT NULL,
	CONSTRAINT question_pk PRIMARY KEY (id),

);

DROP TABLE if exists otus_homework.answers;

CREATE TABLE otus_homework.answers (
	id serial NOT NULL,
	text_ans varchar NOT NULL,
	CONSTRAINT answers_pk PRIMARY KEY (id)
);

DROP TABLE if exists otus_homework.test_keys;

CREATE TABLE otus_homework.test_keys (
	id serial NOT NULL,
	id_test int4 NOT NULL,
	id_question int4 NOT NULL,
	id_answer int4 NOT NULL,
	is_true bool NOT NULL,
	CONSTRAINT test_keys_pk PRIMARY KEY (id),
	CONSTRAINT test_keys_answers_fk FOREIGN KEY (id_answer) REFERENCES otus_homework.answers(id) ON DELETE CASCADE,
	CONSTRAINT test_keys_questions_fk FOREIGN KEY (id_question) REFERENCES otus_homework.questions(id) ON DELETE CASCADE,
	CONSTRAINT test_keys_tests_fk FOREIGN KEY (id_test) REFERENCES otus_homework.tests(id) ON DELETE CASCADE,
	CREATE INDEX idx_questions_test_id ON otus_homework.questions(id_test),
    CREATE INDEX idx_answers_question_id ON otus_homework.answers(id_question)
);
-- create sequence hibernate_sequence minvalue 1 start with 1;
drop table if exists workout_category;
create table workout_category (
                                  id serial not null constraint workout_category_pkey primary key,
                                  category_name varchar(100) not null);


drop table if exists workout_type;
create table workout_type (
                              id serial not null constraint workout_type_pkey primary key,
                              workout_title varchar(100) not null,
                              workout_note varchar(500),
                              calories_burn_per_min double precision,
                              category_id bigint constraint workout_type_workout_category_id_fkey
                                  references workout_category);


drop table if exists sport_activity;
create table sport_activity (
                                id serial not null constraint sport_activity_pkey primary key,
                                start_time time,
                                start_date timestamp,
                                end_time time,
                                comment varchar(500),
                                status varchar(20) not null,
                                workout_type_id bigint constraint sport_activity_workout_type_id_fkey
                                    references workout_type);
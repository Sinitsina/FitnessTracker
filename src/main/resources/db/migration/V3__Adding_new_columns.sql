alter table sport_activity
    add column is_deleted boolean;

alter table workout_category
    add column is_deleted boolean;

alter table workout_type
    add column is_deleted boolean;
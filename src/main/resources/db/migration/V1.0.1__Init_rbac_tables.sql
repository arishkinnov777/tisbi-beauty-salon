grant usage on schema salon to beauty_salon_application;

-- создаем таблицу для хранения пользователей
create table if not exists salon.users
(
    id        uuid         not null primary key unique,
    full_name varchar(255),
    username  varchar(63)  not null unique,
    password  varchar(100) not null,
    email     varchar(255),
    phone     varchar(11),
    active    boolean default false
);

grant delete, trigger, insert, select, update on salon.users to beauty_salon_application;

-- создаем таблицу для хранения ролей
create table if not exists salon.role
(
    id   uuid         not null primary key unique,
    code varchar(63)  not null unique,
    name varchar(255) not null
);

grant delete, trigger, insert, select, update on salon.role to beauty_salon_application;


-- создаем таблицу для хранения разрешений
create table if not exists salon.privilege
(
    id   uuid         not null primary key unique,
    code varchar(63)  not null unique,
    name varchar(255) not null
);

grant delete, trigger, insert, select, update on salon.privilege to beauty_salon_application;

-- создаем таблицу для хранения связей ролей и разрешений
create table if not exists salon.role_privileges
(
    id           uuid not null primary key unique,
    role_id      uuid references role (id),
    privilege_id uuid references privilege (id)
);

grant delete, trigger, insert, select, update on salon.role_privileges to beauty_salon_application;

-- создаем таблицу для хранения связей ролей и пользователей
create table if not exists salon.user_roles
(
    id      uuid not null primary key unique,
    role_id uuid references role (id),
    user_id uuid references users (id)
);

grant delete, trigger, insert, select, update on salon.user_roles to beauty_salon_application;

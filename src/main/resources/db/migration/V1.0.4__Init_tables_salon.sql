-- создаем таблицу для мастеров, которые работают в салоне
create table if not exists salon.masters
(
    id          uuid not null primary key unique,
    user_id     uuid references users (id),
    description text
);
grant delete, trigger, insert, select, update on salon.masters to beauty_salon_application;


-- создаем таблицу для услуг, которые предоставляют в салоне
create table if not exists salon.service
(
    id          uuid not null primary key unique,
    name        varchar(255),
    description text,
    duration    time,
    price       integer
);
grant delete, trigger, insert, select, update on salon.service to beauty_salon_application;


-- создаем таблицу для услуг, которыми владеет мастер
create table if not exists salon.master_services
(
    id         uuid not null primary key unique,
    master_id  uuid references masters (id),
    service_id uuid references service (id)
);
grant delete, trigger, insert, select, update on salon.master_services to beauty_salon_application;


-- создаем таблицу для временных слотов, в которые могут выполнять работы мастера
create table if not exists salon.timeslot
(
    id         uuid not null primary key unique,
    time_start time,
    time_stop  time
);
grant delete, trigger, insert, select, update on salon.timeslot to beauty_salon_application;


-- создаем таблицу для расписания доступности мастеров
create table if not exists salon.schedule
(
    id            uuid not null primary key unique,
    master_id     uuid references masters (id),
    timeslot_id   uuid references timeslot (id),
    date_timeslot date,
    status        varchar(100)
);
grant delete, trigger, insert, select, update on salon.schedule to beauty_salon_application;


-- создаем таблицу для заказов оставленых клиентами
create table if not exists salon.orders
(
    id          serial primary key,
    code        uuid unique,
    service_id  uuid references service (id),
    user_id     uuid references users (id),
    price       integer,
    status      varchar(100),
    created_at  timestamp,
    updated_at  timestamp,
    schedule_id uuid references schedule (id)
);
grant delete, trigger, insert, select, update on salon.orders to beauty_salon_application;
grant delete, trigger, insert, select, update on salon.orders_id_seq to beauty_salon_application;

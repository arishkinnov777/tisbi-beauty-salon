CREATE USER beauty_salon_owner WITH ENCRYPTED PASSWORD 'beauty_salon_owner';
CREATE USER beauty_salon_application WITH ENCRYPTED PASSWORD 'beauty_salon_application';

CREATE DATABASE beauty_salon OWNER beauty_salon_owner;
CREATE SCHEMA IF NOT EXISTS salon AUTHORIZATION beauty_salon_owner;

grant connect on database beauty_salon to beauty_salon_application;
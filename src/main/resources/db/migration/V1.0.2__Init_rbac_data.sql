INSERT INTO salon.role (id, code, name) VALUES ('ca5dabe7-6c0f-4129-81a5-891eee6169f7', 'owner', 'Владелец');
INSERT INTO salon.role (id, code, name) VALUES ('cc7b9f2e-15cd-4032-9472-ff31b6131922', 'master', 'Мастер');
INSERT INTO salon.role (id, code, name) VALUES ('bae4f343-4790-483f-b529-87d3104629d5', 'visitor', 'Посетитель');

INSERT INTO salon.privilege (id, code, name) VALUES ('d84205bd-8c9f-4296-b6f6-e549f3aaa216', 'canUserCabinetUse', 'Есть право на использование кабинета пользователя');
INSERT INTO salon.privilege (id, code, name) VALUES ('b0735c42-5fda-430b-8e86-8c8ef8c45f38', 'canMasterCabinetUse', 'Есть право на использование кабинета мастера');
INSERT INTO salon.privilege (id, code, name) VALUES ('c659ad5d-80b5-4244-a899-5473cf945a01', 'canAdminPanelUse', 'Есть право на использование административной панели сайта');

INSERT INTO salon.role_privileges (id, role_id, privilege_id) VALUES ('bbeb868b-446a-4ec6-92d6-87a0acd77c8b', 'bae4f343-4790-483f-b529-87d3104629d5', 'd84205bd-8c9f-4296-b6f6-e549f3aaa216');
INSERT INTO salon.role_privileges (id, role_id, privilege_id) VALUES ('1bd16839-194b-4c97-b213-9c2751bbdb58', 'cc7b9f2e-15cd-4032-9472-ff31b6131922', 'd84205bd-8c9f-4296-b6f6-e549f3aaa216');
INSERT INTO salon.role_privileges (id, role_id, privilege_id) VALUES ('8642903f-227b-4854-b591-eafdc19e7da1', 'cc7b9f2e-15cd-4032-9472-ff31b6131922', 'b0735c42-5fda-430b-8e86-8c8ef8c45f38');
INSERT INTO salon.role_privileges (id, role_id, privilege_id) VALUES ('7320f299-3f87-42f0-ae23-87ad9e53c3ba', 'ca5dabe7-6c0f-4129-81a5-891eee6169f7', 'd84205bd-8c9f-4296-b6f6-e549f3aaa216');
INSERT INTO salon.role_privileges (id, role_id, privilege_id) VALUES ('fa33d949-2c02-4c2c-9340-7637f10b7328', 'ca5dabe7-6c0f-4129-81a5-891eee6169f7', 'b0735c42-5fda-430b-8e86-8c8ef8c45f38');
INSERT INTO salon.role_privileges (id, role_id, privilege_id) VALUES ('8c0104da-0729-45ef-8993-e445da498cf3', 'ca5dabe7-6c0f-4129-81a5-891eee6169f7', 'c659ad5d-80b5-4244-a899-5473cf945a01');

INSERT INTO salon.users (id, full_name, username, password, email, phone, active) VALUES ('eb66b962-e31f-48dd-a894-3336e475db23', 'Арина', 'admin', '{noop}admin', 'admin@beauty.ru', '79000000000', true);
INSERT INTO salon.users (id, full_name, username, password, email, phone, active) VALUES ('e81b28a9-8512-435b-bf24-b4afe91d7378', 'Настя', 'master_nastya', '{noop}master_nastya', 'master_nastya@beauty.ru', '79000000001', true);
INSERT INTO salon.users (id, full_name, username, password, email, phone, active) VALUES ('bab69454-b39b-49b3-8d69-96fd8cdfe93b', 'Камилла', 'master_kamilla', '{noop}master_kamilla', 'master_kamilla@beauty.ru', '79000000002', true);
INSERT INTO salon.users (id, full_name, username, password, email, phone, active) VALUES ('fc9d7a37-d0d4-4617-855c-1bde404ee61c', 'Таня', 'master_tanya', '{noop}master_tanya', 'master_tanya@beauty.ru', '79000000003', true);
INSERT INTO salon.users (id, full_name, username, password, email, phone, active) VALUES ('20ebde16-f551-48b8-aac0-241159911e7e', 'Регина', 'master_regina', '{noop}master_regina', 'master_regina@beauty.ru', '79000000004', true);

INSERT INTO salon.user_roles (id, role_id, user_id) VALUES ('26b62e93-a803-4ea8-ba2e-c48281bef884', 'ca5dabe7-6c0f-4129-81a5-891eee6169f7', 'eb66b962-e31f-48dd-a894-3336e475db23');
INSERT INTO salon.user_roles (id, role_id, user_id) VALUES ('4ba56709-8ef4-4266-b616-452bec98341d', 'cc7b9f2e-15cd-4032-9472-ff31b6131922', 'e81b28a9-8512-435b-bf24-b4afe91d7378');
INSERT INTO salon.user_roles (id, role_id, user_id) VALUES ('1e057098-61f3-4c27-9cce-e8eadc17b251', 'cc7b9f2e-15cd-4032-9472-ff31b6131922', 'bab69454-b39b-49b3-8d69-96fd8cdfe93b');
INSERT INTO salon.user_roles (id, role_id, user_id) VALUES ('984e816d-f25c-45d0-bad2-6e8cd8241732', 'cc7b9f2e-15cd-4032-9472-ff31b6131922', 'fc9d7a37-d0d4-4617-855c-1bde404ee61c');
INSERT INTO salon.user_roles (id, role_id, user_id) VALUES ('370d4f32-d077-4dbc-9924-3a0e6bfdbcf0', 'cc7b9f2e-15cd-4032-9472-ff31b6131922', '20ebde16-f551-48b8-aac0-241159911e7e');
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('71152b0b-fc9b-4651-acd0-59de9bdb66e4', 'Маникюр', 'Гель, лак, наращивание, японский маникюр, персональный дизайн. Сделаем все, что вы сможете себе представить. И посоветуем то, что вы даже не представляли.', '01:00:00', 500);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('d71767f6-9fb1-4d42-ab4c-269fba93d687', 'Педикюр', 'Сделаем так, что после выхода из студии вам скорее захочется надеть любимые босоножки. А ваши стопы станут мягкими как никогда.', '01:00:00', 700);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('66c28d59-5159-4067-a85d-a4cf775d899f', 'Брови', 'Бережно удалим лишнее, скорректируем форму, окрасим в натуральный оттенок. Учтем форму лица, стрижку и цвет волос, чтобы создать брови, которые сделают ваш образ еще ярче.', '00:30:00', 500);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('3e12662c-ce9a-4db3-bd66-146bdc6bb524', 'Ресницы', 'Найдем идеальный способ подчеркнуть ваши глаза. Вы сможете тратить меньше времени на утренний макияж, забудете о подтеках туши, раздражении и аллергии.', '01:00:00', 1000);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('36a086e2-cbce-4856-81b5-9feeea0013c2', 'Перманент', 'Перманентный макияж в натуральных техниках помогает добиться естественного эффекта, который лишь подчеркнет вашу природную красоту.', '02:00:00', 5000);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('e9cfeca9-46cb-4022-847b-4a1fb50c3b23', 'Стрижки', 'Делаем так, чтобы через несколько недель стрижка смотрелась так же классно, как после выхода из студии. Учтем структуру волос, пропорции лица и предложим образ, который максимально подчеркнет ваш стиль.', '01:00:00', 1000);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('da9358ee-3324-4518-818c-35bdbf142c9a', 'Окрашивание', 'Делаем так, чтобы через несколько недель стрижка смотрелась так же классно, как после выхода из студии. Учтем структуру волос, пропорции лица и предложим образ, который максимально подчеркнет ваш стиль.', '05:00:00', 9000);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('d3aced70-551a-4e0f-9eb9-024790a337b2', 'Макияж и прически', 'В самые важные дни вашей жизни хочется выглядеть безупречно. Берем эту ответственность на себя.', '02:00:00', 3000);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('6c45bdd4-be14-45cd-b7fd-cecd5bfddcd2', 'Эпиляция', 'Мы используем диодный лазер. Это последнее поколение оборудования для лазерной эпиляции, которое помогает убрать волосы на теле на 2−5 лет без дискомфорта и рисков для здоровья.', '02:00:00', 3500);
INSERT INTO salon.service (id, name, description, duration, price) VALUES ('c1fabc29-34fe-4e81-8543-8a653d6d1f2d', 'Косметология', 'В первую очередь заботимся о здоровье и тонусе кожи лица. Омоложение — это приятный побочный эффект.', '01:00:00', 3000);

INSERT INTO salon.masters (id, user_id, description) VALUES ('14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'e81b28a9-8512-435b-bf24-b4afe91d7378', 'парикмахер стилист');
INSERT INTO salon.masters (id, user_id, description) VALUES ('06f472d3-3535-494e-ab9c-215da67bb8b3', 'bab69454-b39b-49b3-8d69-96fd8cdfe93b', 'мастер ногтевого сервиса');
INSERT INTO salon.masters (id, user_id, description) VALUES ('58fd64f7-6b36-491b-84b1-abcb13246191', 'fc9d7a37-d0d4-4617-855c-1bde404ee61c', 'мастер brow-сервиса');
INSERT INTO salon.masters (id, user_id, description) VALUES ('da701122-36a9-4ff7-bc89-1a64515294a2', '20ebde16-f551-48b8-aac0-241159911e7e', 'мастер по наращиванию ресниц');

INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('1754fa6f-785e-42bb-849a-9c67d9693706', '09:00:00', '10:00:00');
INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('98877acf-fa35-419c-ace1-1ceddfc41411', '10:00:00', '11:00:00');
INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('218a9928-51f5-406c-a8e1-3c73aedd3957', '11:00:00', '12:00:00');
INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('d9340e96-f28d-47ca-92df-60ab4ee0463e', '11:00:00', '13:00:00');
INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('106ad3c2-8e9a-433d-9323-90076441460b', '14:00:00', '15:00:00');
INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('734246b2-383e-4b2a-bfad-151892852eb7', '15:00:00', '16:00:00');
INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('dd94bb80-aab2-431c-9a60-68f21e1b1f78', '16:00:00', '17:00:00');
INSERT INTO salon.timeslot (id, time_start, time_stop) VALUES ('f92a389c-2465-4bde-b33e-f18caeab5ad3', '17:00:00', '18:00:00');

INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('4819e30f-c62b-4d8c-923d-ae4975ea3b9c', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'e9cfeca9-46cb-4022-847b-4a1fb50c3b23');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('b48ce8a4-936a-4cdb-8bf0-c1d8c2e1a828', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'd3aced70-551a-4e0f-9eb9-024790a337b2');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('237c5380-5b88-4dc0-958f-8206674d15ba', '06f472d3-3535-494e-ab9c-215da67bb8b3', '71152b0b-fc9b-4651-acd0-59de9bdb66e4');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('691d1b43-c6db-42af-9f7e-da0fbf99e2e6', '06f472d3-3535-494e-ab9c-215da67bb8b3', 'd71767f6-9fb1-4d42-ab4c-269fba93d687');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('9cef754b-76c9-4fbd-ae7b-8bb6a15df251', '58fd64f7-6b36-491b-84b1-abcb13246191', '66c28d59-5159-4067-a85d-a4cf775d899f');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('548ce5c6-eb30-47fa-a61a-208634840319', 'da701122-36a9-4ff7-bc89-1a64515294a2', '3e12662c-ce9a-4db3-bd66-146bdc6bb524');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('4909770e-ce48-4f4a-9b53-64295b6639cc', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '66c28d59-5159-4067-a85d-a4cf775d899f');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('6f6b4e23-7613-45fd-934f-867626d9438a', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '3e12662c-ce9a-4db3-bd66-146bdc6bb524');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('5163def7-8639-4efa-b59a-6117baeb53cf', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '36a086e2-cbce-4856-81b5-9feeea0013c2');
INSERT INTO salon.master_services (id, master_id, service_id) VALUES ('7eee0a7e-da15-4cf5-89df-d9fbfefd3c16', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'da9358ee-3324-4518-818c-35bdbf142c9a');

INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('da5e1c8b-24a7-4d88-8938-bc7858a99990', '58fd64f7-6b36-491b-84b1-abcb13246191', '106ad3c2-8e9a-433d-9323-90076441460b', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('ae2a4164-41df-4111-9c09-e6777877ffd3', '58fd64f7-6b36-491b-84b1-abcb13246191', '734246b2-383e-4b2a-bfad-151892852eb7', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('363ba6df-6305-4d42-a0d2-d34fe240d59e', '58fd64f7-6b36-491b-84b1-abcb13246191', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('5972d318-32ef-469c-ad71-65a18cc0dbd7', '58fd64f7-6b36-491b-84b1-abcb13246191', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('f885baca-8380-4452-9e4d-3ac263707da6', 'da701122-36a9-4ff7-bc89-1a64515294a2', '1754fa6f-785e-42bb-849a-9c67d9693706', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('fbe58758-b29a-4968-a672-dcce49f31d74', 'da701122-36a9-4ff7-bc89-1a64515294a2', '98877acf-fa35-419c-ace1-1ceddfc41411', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('fd9bed20-b6ef-4b7a-9126-ed5e6b28f9b8', 'da701122-36a9-4ff7-bc89-1a64515294a2', '218a9928-51f5-406c-a8e1-3c73aedd3957', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('dc6462eb-5787-4707-8c93-aae92f184e87', 'da701122-36a9-4ff7-bc89-1a64515294a2', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('b032d004-3259-4af6-9c9e-7c7b7f4ee2b8', 'da701122-36a9-4ff7-bc89-1a64515294a2', '106ad3c2-8e9a-433d-9323-90076441460b', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('90e75152-e64a-4ac6-a277-d7be82e6c515', 'da701122-36a9-4ff7-bc89-1a64515294a2', '734246b2-383e-4b2a-bfad-151892852eb7', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('f3aab1c9-cea3-4906-a541-edf50795aca1', 'da701122-36a9-4ff7-bc89-1a64515294a2', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('53115ed4-bad9-4a64-9948-081ff6607289', 'da701122-36a9-4ff7-bc89-1a64515294a2', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', '2022-05-21', false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('5710904d-aaff-4872-8b61-5bc418814425', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '1754fa6f-785e-42bb-849a-9c67d9693706', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('e645cc7d-bd4d-4675-9dbd-4da9e3ad46cf', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '98877acf-fa35-419c-ace1-1ceddfc41411', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('d1ccd87a-535c-4144-a665-7929c4a7c047', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '218a9928-51f5-406c-a8e1-3c73aedd3957', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('628a7c01-0033-4c3b-8979-a9afdfbfd964', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('85bbceda-cee4-4674-a10a-ada84354a502', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '106ad3c2-8e9a-433d-9323-90076441460b', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('806f905d-d986-40bc-93fd-ecf6d72f4fe6', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '734246b2-383e-4b2a-bfad-151892852eb7', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('1f83a9b9-6df5-41c7-997a-f1278bf7d8e7', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('f80f7d43-1219-4c0d-9759-38eb1ce0a67d', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('130b851d-c99b-4dfa-b128-f69c253f5457', '06f472d3-3535-494e-ab9c-215da67bb8b3', '1754fa6f-785e-42bb-849a-9c67d9693706', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('6c1aeafa-b543-4956-81eb-f583eaa16ec3', '06f472d3-3535-494e-ab9c-215da67bb8b3', '98877acf-fa35-419c-ace1-1ceddfc41411', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('cad4a593-6329-4b64-9beb-c4b0d56a3ce1', '06f472d3-3535-494e-ab9c-215da67bb8b3', '218a9928-51f5-406c-a8e1-3c73aedd3957', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('45d534e2-59bd-40fb-9da8-bfadc7983aac', '06f472d3-3535-494e-ab9c-215da67bb8b3', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('ab6e0c8f-5e4e-4e93-b186-66e04f955b00', '06f472d3-3535-494e-ab9c-215da67bb8b3', '106ad3c2-8e9a-433d-9323-90076441460b', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('3a4c7cdc-b946-4fda-ad81-44ceb26b4e56', '06f472d3-3535-494e-ab9c-215da67bb8b3', '734246b2-383e-4b2a-bfad-151892852eb7', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('b5cf5131-29d0-46d9-b33c-9d0602db96c3', '06f472d3-3535-494e-ab9c-215da67bb8b3', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('92f5c779-87fa-4daf-aa0c-0b627c037fdf', '06f472d3-3535-494e-ab9c-215da67bb8b3', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('c9300754-49b3-4f67-bc0e-8d90bef5e20d', '58fd64f7-6b36-491b-84b1-abcb13246191', '1754fa6f-785e-42bb-849a-9c67d9693706', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('bd04450d-2297-42a2-8435-6bb4d1371c9b', '58fd64f7-6b36-491b-84b1-abcb13246191', '98877acf-fa35-419c-ace1-1ceddfc41411', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('39e6ffdb-e5f3-4944-ab33-3f75cddee181', '58fd64f7-6b36-491b-84b1-abcb13246191', '218a9928-51f5-406c-a8e1-3c73aedd3957', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('59e54a3c-8228-4da1-90e4-7fbd5d798b43', '58fd64f7-6b36-491b-84b1-abcb13246191', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('375071da-f88b-4376-b868-4dae82419699', '58fd64f7-6b36-491b-84b1-abcb13246191', '106ad3c2-8e9a-433d-9323-90076441460b', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('3c2a5b9b-88f1-46c6-80d1-6a19c43a295c', '58fd64f7-6b36-491b-84b1-abcb13246191', '734246b2-383e-4b2a-bfad-151892852eb7', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('65d8bf6e-5487-4ff3-accb-dd8c6452c527', '58fd64f7-6b36-491b-84b1-abcb13246191', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('5006b752-ac33-47f8-ae19-4f5a4fe4066d', '58fd64f7-6b36-491b-84b1-abcb13246191', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('0decb02c-a1df-43b0-93f0-242c386724d4', 'da701122-36a9-4ff7-bc89-1a64515294a2', '1754fa6f-785e-42bb-849a-9c67d9693706', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('3714bafd-353e-4d72-b29e-c61d383386de', 'da701122-36a9-4ff7-bc89-1a64515294a2', '98877acf-fa35-419c-ace1-1ceddfc41411', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('98dfab54-b6a9-46bf-9950-b1382c7d2710', 'da701122-36a9-4ff7-bc89-1a64515294a2', '218a9928-51f5-406c-a8e1-3c73aedd3957', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('b17df75c-65c5-48f5-bcfe-a666e6432f19', 'da701122-36a9-4ff7-bc89-1a64515294a2', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('9141c1b1-8cd5-467a-b6cc-8dea2a7fcd39', 'da701122-36a9-4ff7-bc89-1a64515294a2', '106ad3c2-8e9a-433d-9323-90076441460b', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('4c9f8ef9-c5b5-41ec-becb-7d820c3c2c07', 'da701122-36a9-4ff7-bc89-1a64515294a2', '734246b2-383e-4b2a-bfad-151892852eb7', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('c8c8bd83-d4ad-463c-82d4-78c87e0c8d5c', 'da701122-36a9-4ff7-bc89-1a64515294a2', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('0b5c5ffa-91c4-4817-803c-6c8f6d34edd7', 'da701122-36a9-4ff7-bc89-1a64515294a2', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', now(), false);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('515a5dc7-50e8-4c41-b9d0-2a4cb905c196', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('9ac94b1f-6b81-45ef-8f9c-b882b07b29aa', '58fd64f7-6b36-491b-84b1-abcb13246191', '1754fa6f-785e-42bb-849a-9c67d9693706', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('cf18b83a-1a39-47a6-a3c1-2617391fca07', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('ab8c4b60-e9bc-4301-88ff-9f37e4f57d23', '06f472d3-3535-494e-ab9c-215da67bb8b3', '106ad3c2-8e9a-433d-9323-90076441460b', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('bac8ee53-16ff-4cfc-a24c-a07111d738f5', '06f472d3-3535-494e-ab9c-215da67bb8b3', 'dd94bb80-aab2-431c-9a60-68f21e1b1f78', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('30babfbc-c008-4257-957d-d274c19ff082', '58fd64f7-6b36-491b-84b1-abcb13246191', '218a9928-51f5-406c-a8e1-3c73aedd3957', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('611c00ed-a241-40c3-b3f1-05271941262a', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '106ad3c2-8e9a-433d-9323-90076441460b', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('3d4768f7-48d0-438a-9962-7bd2e9997602', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('1d71f2dc-af1b-4471-9dd3-9f75ae1c3424', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '98877acf-fa35-419c-ace1-1ceddfc41411', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('39b2b8e1-6ca7-408a-8b2e-7d657e3df773', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '734246b2-383e-4b2a-bfad-151892852eb7', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('2f7d703c-5559-45eb-b75d-317577056b79', '06f472d3-3535-494e-ab9c-215da67bb8b3', '98877acf-fa35-419c-ace1-1ceddfc41411', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('10b6bf98-0800-4d63-ae6c-5811f4421412', '06f472d3-3535-494e-ab9c-215da67bb8b3', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('253d5a08-f43d-45bb-a2d8-f39ab774885b', '06f472d3-3535-494e-ab9c-215da67bb8b3', 'f92a389c-2465-4bde-b33e-f18caeab5ad3', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('027d2202-fe2d-45e4-811f-7d195fbf84d2', '06f472d3-3535-494e-ab9c-215da67bb8b3', '734246b2-383e-4b2a-bfad-151892852eb7', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('246ab689-7730-443e-9e60-866bc2c0e86f', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '218a9928-51f5-406c-a8e1-3c73aedd3957', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('c924ebe9-270e-4a5b-9d08-2154006c7931', '58fd64f7-6b36-491b-84b1-abcb13246191', '98877acf-fa35-419c-ace1-1ceddfc41411', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('6d6c8fa1-1986-4304-b9fb-f25b1da0f859', '58fd64f7-6b36-491b-84b1-abcb13246191', 'd9340e96-f28d-47ca-92df-60ab4ee0463e', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('aec46c85-99ec-46df-87c5-5127bc687f4e', '06f472d3-3535-494e-ab9c-215da67bb8b3', '1754fa6f-785e-42bb-849a-9c67d9693706', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('d3dc73b1-b3fa-40fc-a850-eaf38b16ed38', '06f472d3-3535-494e-ab9c-215da67bb8b3', '218a9928-51f5-406c-a8e1-3c73aedd3957', '2022-05-21', true);
INSERT INTO salon.schedule (id, master_id, timeslot_id, date_timeslot, is_reserved) VALUES ('84358cba-4f0d-459f-a111-1f4ffa7eecf5', '14b36ffc-2f9b-4538-8482-b1ed2d85a026', '1754fa6f-785e-42bb-849a-9c67d9693706', '2022-05-21', true);






























DROP TABLE IF EXISTS app.payment;
CREATE TABLE app.payment (

	codNatureExpense INT,
	descNatureExpense TEXT,
	description TEXT,
	date DATE,
	value DOUBLE
);

INSERT INTO app.payment VALUES (44905224,'EQUIPAMENTO DE PROTEÇÃO SEGURANÇA E SOCORRO','Alarme','2020-05-01',1000);
INSERT INTO app.payment VALUES (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Cortina de sala','2020-05-02',1000);
INSERT INTO app.payment VALUES (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Bandeiras','2020-05-03',500);
INSERT INTO app.payment VALUES (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Guarda Sol','2020-05-04',500);
INSERT INTO app.payment VALUES (33903016,'MATERIAL DE EXPEDIENTE','Resma de Papel A4','2020-05-01',2000);
INSERT INTO app.payment VALUES (33903016,'MATERIAL DE EXPEDIENTE','Cartucho Impressora','2020-05-10',2000);
INSERT INTO app.payment VALUES (44905218,'COLEÇÕES E MATERIAIS BIBLIOGRÁFICOS','Dicionários','2020-05-12',4000);
INSERT INTO app.payment VALUES (44905218,'COLEÇÕES E MATERIAIS BIBLIOGRÁFICOS','Livro de Algoritmos','2020-05-11',4000);
INSERT INTO app.payment VALUES (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Amianto','2020-05-13',8000);
INSERT INTO app.payment VALUES (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Aparelhos Sanitários','2020-05-11',6000);
INSERT INTO app.payment VALUES (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Cimento','2020-05-12',2000);
INSERT INTO app.payment VALUES (33903302,'PASSAGENS PARA O EXTERIOR','Viagem para Las Vegas','2020-05-01',32000);

DROP TABLE IF EXISTS app.client;

CREATE table app.client (
	firstname TEXT,
	lastname TEXT,
    age INT,
	email VARCHAR(50),
	salaryrange DOUBLE,
	primary key(email)
);

DROP TABLE IF EXISTS app.account;

CREATE table app.account (
	id int auto_increment,
	tipo ENUM('SILVER','GOLD','PLATINUM','DIAMOND'),
    limite DOUBLE,
	client_id text,
	primary key(id)
);


INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mariam Reichert PhD', 'Reichert', 56, 'abernier@example.com', '889.2');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Kyra Gutmann', 'Gutmann', 58, 'alexandria.gutmann@example.org', '2084.11');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mrs. Ashlynn Treutel', 'Treutel', 61, 'amani.wuckert@example.net', '395.25');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Cassie Breitenberg', 'Breitenberg', 66, 'ankunding.cheyanne@example.net', '407.48');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Herman Skiles', 'Skiles', 97, 'asimonis@example.net', '522577.31');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Ashly Sawayn I', 'Sawayn', 80, 'bell.botsford@example.org', '584');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Abigail Hagenes', 'Hagenes', 44, 'bernier.junius@example.org', '689550.84');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Denis Schroeder', 'Schroeder', 62, 'berry.heaney@example.net', '297487.77');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Yessenia Rau II', 'Rau', 34, 'bkris@example.org', '7556151.11');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Magali Feil', 'Feil', 30, 'brice52@example.com', '617.38');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Melany Mann', 'Mann', 58, 'bridie93@example.net', '18359059.13');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Emily Bradtke I', 'Bradtke', 80, 'brown.aliya@example.org', '403492464.41');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Miss Rossie Kohler II', 'Kohler', 31, 'buckridge.tiana@example.com', '31118.75');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Reba Grady III', 'III', 78, 'carlie15@example.org', '1590.43');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Brycen Kirlin', 'Kirlin', 89, 'celestino10@example.org', '190891.39');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Ova Hauck', 'Hauck', 28, 'celine.cummerata@example.org', '77999571.99');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Miss Cortney Doyle', 'Doyle', 49, 'cordie.eichmann@example.com', '104.41');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Kristofer Sipes MD', 'MD',  92, 'cronin.theo@example.org', '305397.43');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Benny Denesik Jr.', 'Jr', 57, 'dejon41@example.net', '977.83');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Lea Miller', 'Miller', 37, 'dejuan67@example.com', '85384934.62');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Bryana Hermann', 'Hermann', 47, 'demetrius.fisher@example.net', '443450.12');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Donnell Lind MD', 'MD', 21, 'denesik.ruben@example.com', '14897.49');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Ken Auer II', 'II', 58, 'derek.paucek@example.org', '36583.92');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Leonel Adams', 'Adams', 92, 'destini.marks@example.org', '34276761.76');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Laverna Barrows DDS', 'DDS', 79, 'dkilback@example.org', '695233169.5');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Regan Walter PhD', 'PhD', 83, 'dkoepp@example.com', '2140.55');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Tom Hirthe', 'Hirthe', 32, 'dsanford@example.org', '13564.87');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Stanford Davis', 'Davis', 87, 'ernser.sarah@example.org', '146.82');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Stacy Kilback', 'Kilback', 24, 'farrell.noemy@example.org', '413.61');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mr. Eldred Nikolaus MD', 'MD', 53, 'freddie94@example.org', '130.73');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mr. Zack Wisozk', 'Wisozk', 51, 'freichel@example.net', '163801089.81');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dusty Kunde', 'Kunde', 68, 'freynolds@example.com', '606.36');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Maxie O\'Reilly III', 'III', 62, 'garrison.larson@example.com', '634.82');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mr. Moshe Mraz', 'Mraz', 23, 'gdonnelly@example.org', '352.12');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Barbara Dach', 'Dach', 27, 'geo.dach@example.org', '29984721.28');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Jenifer Muller', 'Muller', 82, 'gleason.daphney@example.com', '151.69');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Frederic Little', 'Little', 96, 'gulgowski.kali@example.com', '62463470.79');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Bert Cummings', 'Cummings', 75, 'halvorson.ivy@example.net', '188671.16');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Ardith Wilkinson', 'Wilkinson', 45, 'harrison.bradtke@example.com', '1467.07');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Twila Stark', 'Stark', 35, 'heaney.meggie@example.org', '7792.28');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Thelma Cormier', 'Cormier', 88, 'hilario79@example.org', '189193721.73');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Van Auer', 'Auer', 22, 'homenick.sydney@example.com', '1250.65');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Palma Spinka', 'Spinka', 28, 'howe.elian@example.net', '26.86');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Norene Ortiz', 'Ortiz', 49, 'ignatius.kuhlman@example.org', '808.06');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Wava Buckridge', 'Buckridge', 49, 'jacobi.megane@example.com', '29.88');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Cameron Keeling', 'Keeling', 75, 'jody41@example.com', '4683692.41');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Zack Stiedemann', 'Stiedemann', 77, 'julian81@example.com', '701.35');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Haven Mann', 'Mann', 66, 'kaley41@example.org', '809.64');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Francisco Swaniawski', 'Swaniawski', 80, 'kariane.marvin@example.org', '204014467.33');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Lavonne King', 'King', 73, 'karianne.wolff@example.org', '199.97');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Keith Hoeger', 'Hoeger', 47, 'klocko.kareem@example.net', '405.51');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mrs. Avis Gerhold', 'Gerhold', 99, 'kunde.kraig@example.org', '1155.96');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Clair Bayer', 'Bayer', 78, 'kunze.aniya@example.com', '32062756.73');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Elyssa Gerhold', 'Gerhold', 60, 'magdalen99@example.org', '964.64');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Anastasia Kemmer', 'Kemmer', 19, 'maiya.boehm@example.org', '984.76');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Maegan Hackett', 'Hackett', 58, 'marilyne.mcglynn@example.net', '3305.84');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Eladio Weber', 'Weber', 58, 'marlene.beahan@example.net', '325997037.21');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Damien Bauch', 'Bauch', 29, 'maurine88@example.org', '10847.18');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Gabe Paucek', 'Paucek', 41, 'medhurst.tiffany@example.net', '3997102.27');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mr. Mustafa Altenwerth', 'Altenwerth', 93, 'mgleason@example.net', '275805079.07');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Madie Bechtelar', 'Bechtelar', 23, 'milford.corkery@example.net', '135858.96');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Gladys Goodwin', 'Goodwin', 27, 'milton.white@example.org', '8217.66');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Moshe Spencer', 'Spencer', 29, 'molly.feil@example.org', '28407202.05');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Ms. Sandrine Nienow', 'Nienow', 62, 'mstehr@example.net', '30658330.39');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Joanie Purdy', 'Purdy', 34, 'ncorkery@example.org', '800.14');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Miss Lila Jacobs Sr.', 'Jacobs', 74, 'nwehner@example.org', '41300639');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Sydnee Koelpin', 'Koelpin', 21, 'octavia.white@example.com', '792.82');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Ibrahim Kiehn MD', 'Kiehn', 33, 'oswald.parisian@example.net', '78729.77');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Adrianna Hilpert', 'Hilpert', 61, 'pfeffer.louisa@example.com', '1802878.73');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Agustin Champlin', 'Champlin', 20, 'pink.schoen@example.com', '839.61');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Elijah Carter', 'Carter', 64, 'qdonnelly@example.net', '33041.46');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Rhiannon Kirlin PhD', 'Kirlin', 20, 'qfahey@example.com', '3830.46');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Keeley Lindgren', 'Lindgren', 98, 'qrau@example.com', '354.53');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Margarita Conn V', 'Margarita', 31, 'quinton.koelpin@example.org', '23164.7');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Tyree Luettgen', 'Luettgen', 43, 'rcorwin@example.org', '3198.02');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Emmanuelle Waelchi', 'Waelchi', 50, 'reilly.emmie@example.net', '14555593.68');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Josh Abbott', 'Abbott', 98, 'rex.frami@example.org', '1151.21');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mrs. Kaylah Wyman DVM', 'DVM', 37, 'roberto09@example.org', '686.48');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Skyla Raynor', 'Raynor', 76, 'rose71@example.net', '902.09');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mr. Baron Hodkiewicz DDS', 'Hodkiewicz', 34, 'rossie25@example.org', '887.3');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Broderick Lueilwitz', 'Lueilwitz', 31, 'rrunolfsdottir@example.org', '6059.99');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dayna Gleichner', 'Gleichner', 65, 'salvador.corwin@example.net', '983.83');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Carli Will', 'Will', 73, 'sophie.grimes@example.org', '1405.43');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Prof. Al Oberbrunner Sr.','Oberbrunner',  34, 'stehr.lane@example.com', '479.21');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Francesco Ankunding', 'Ankunding', 93, 'swaniawski.sophia@example.com', '7607114.09');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Arden Gorczany', 'Gorczany', 64, 'sylvester59@example.com', '440195394.59');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Lesley Lueilwitz', 'Lueilwitz', 64, 'tbernier@example.com', '455.82');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Carrie Hagenes I', 'Hagenes', 29, 'trycia.fay@example.org', '745.03');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Lauren Torphy', 'Torphy', 62, 'ublanda@example.net', '788.06');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Georgianna Hoppe', 'Hoppe', 100, 'uturner@example.com', '1027.07');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Vivien Miller', 'Miller', 42, 'vcremin@example.org', '364854.36');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Verner Walker', 'Walker', 85, 'vlittle@example.com', '845.41');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Noemi Tremblay','Tremblay',  27, 'ward.makenna@example.org', '2110.2');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Erin Dooley', 'Dooley', 32, 'wbruen@example.net', '67165450.91');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Madison Schultz','Schultz',  38, 'winnifred69@example.org', '586.71');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Dr. Gladyce Klocko','Klocko',  73, 'xhomenick@example.com', '20627.86');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Modesta Kiehn', 'Kiehn', 26, 'xschoen@example.org', '11129.81');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Madonna Russel MD','MD', 61, 'yundt.eda@example.net', '33943.39');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Michel Borer', 'Borer', 61, 'zkub@example.org', '41.63');
INSERT INTO `client` (`firstname`,`lastname`, `age`, `email`, `salaryrange`) VALUES ('Mr. Major O\'Connell IV', 'IV', 96, 'zmuller@example.org', '57016018.85');


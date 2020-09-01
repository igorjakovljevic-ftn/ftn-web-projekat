INSERT INTO CINEMA(name,address,phone_number,email) 
VALUES ('bioskop1','adresa1','123123123','bioemail1@gmail.com');

INSERT INTO CINEMA(name,address,phone_number,email) 
VALUES ('bioskop2','adresa2','234234234','bioemail2@gmail.com');


INSERT INTO USER(username,password,name,lastname,phone_number,email,activity,role,date) 
VALUES ( 'korisnicko1','lozinka1','Pera','Peric','423423432','email1@gmail.com',true,0,'1999-02-03');

INSERT INTO USER(username,password,name,lastname,phone_number,email,activity,role,cinema_id,date) 
VALUES ( 'korisnicko2','lozinka2','Mitar','Miric','345345345','email2@gmail.com',true,1,1,'1999-11-12');

INSERT INTO USER(username,password,name,lastname,phone_number,email,activity,role,date)
VALUES ( 'korisnicko3','lozinka3','Nenad','Pavlovic','534534543','email3@gmail.com',true,2,'1994-01-01');

INSERT INTO USER(username,password,name,lastname,phone_number,email,activity,role,date)
VALUES ( 'korisnicko4','lozinka4','Moamir','Bekic','775676765','email4@gmail.com',true,2,'1993-02-02');


INSERT INTO MOVIE(name,description,duration,genre,rating)
VALUES ('Schindlers List','Opis Sindlerove Liste',245,'Ratna Drama',8.9);

INSERT INTO MOVIE(name,description,duration,genre,rating) 
VALUES ('The Boy In The Stripped Pyjamas','Opis Decaka U Prugastoj Pizami',134,'Ratna Drama',7.8);

INSERT INTO MOVIE(name,description,duration,genre,rating) 
VALUES ('The Pianist','Opis Pijaniste',270,'Ratna Drama',8.5);

INSERT INTO MOVIE(name,description,duration,genre,rating) 
VALUES ('The Prestige','Opis Prestiza',130,'Triler Misterija',8.5);

INSERT INTO MOVIE(name,description,duration,genre,rating) 
VALUES ('The Shawshank Redemption','Opis Bekstva iz Sosenka',142,'Krimi Drama',9.3);


INSERT INTO MOVIE_RATING(rating,user_id,movie_id)
VALUES (1,3,1);

INSERT INTO MOVIE_RATING(rating,user_id,movie_id) 
VALUES (2,4,4);

INSERT INTO MOVIE_RATING(rating,user_id,movie_id) 
VALUES (3,3,2);

INSERT INTO MOVIE_RATING(rating,user_id,movie_id) 
VALUES (4,4,2);

INSERT INTO MOVIE_RATING(rating,user_id,movie_id) 
VALUES (0,3,3);

INSERT INTO MOVIE_RATING(rating,user_id,movie_id) 
VALUES (10,3,5);


INSERT INTO ROOM(capacity,mark,cinema_id) 
VALUES (10,'Sala A',1);

INSERT INTO ROOM(capacity,mark,cinema_id) 
VALUES (20,'Sala B',1);

INSERT INTO ROOM(capacity,mark,cinema_id) 
VALUES (30,'Sala C',1);

INSERT INTO ROOM(capacity,mark,cinema_id) 
VALUES (40,'Sala D',1);

INSERT INTO ROOM(capacity,mark,cinema_id) 
VALUES (50,'Sala E',1);


INSERT INTO PROJECTION(day,time,price,cinema_id,movie_id) 
VALUES ('2020-09-12','19:00',500,1,3);

INSERT INTO PROJECTION(day,time,price,cinema_id,movie_id) 
VALUES ('2020-09-24','16:30',500,2,4);

INSERT INTO PROJECTION(day,time,price,cinema_id,movie_id) 
VALUES ('2020-09-04','20:00',500,2,5);

INSERT INTO PROJECTION(day,time,price,cinema_id,movie_id) 
VALUES ('2020-09-03','22:00',500,1,2);


INSERT INTO ROOM_PROJECTION(room_id,projection_id) VALUES (1,1);
INSERT INTO ROOM_PROJECTION(room_id,projection_id) VALUES (2,3);
INSERT INTO RESERVATIONS(user_id,projection_id) VALUES (3,1);
INSERT INTO RESERVATIONS(user_id,projection_id) VALUES (4,1);


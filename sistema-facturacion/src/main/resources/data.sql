
--creo la tabla empresa--
create table company ( company_id int not null auto_increment, company_name varchar(255) not null,company_business_name varchar(255) not null, company_heading varchar(255) not null, PRIMARY KEY(company_id) );

--creo la tabla cliente--
create table client ( client_id int not null auto_increment, client_name varchar(255) not null, client_last_name varchar(255) not null, client_dni varchar(255) not null, client_direction varchar(255) not null, PRIMARY KEY(client_id) );

--creo la tabla producto--
create table product (product_id int not null auto_increment, product_name varchar(255) not null, product_price float not null, product_amount int not null, product_description varchar(255) not null,PRIMARY KEY(product_id) );

--creo la tabla factura--
create table factura (factura_id int not null auto_increment, fecha date not null, client_id int not null, product_id int not null, product_price float,product_amount int not null, PRIMARY KEY(factura_id), FOREIGN KEY(client_id) references client(client_id),FOREIGN KEY(product_id) references product(product_id));


--inserto los valores en la tabla empresa--
insert into company ( company_name , company_business_name, company_heading)
values ('Almacen 3D', 'Almacen 3D S.A', 'Articulos generales 3D');

--inserto los valores en la tabla cliente--
insert into client ( client_name , client_last_name ,client_dni, client_direction)
values ('Juan','Bartolo', 20346789,'Av Mitre 200'),
       ('Maria','Del Barrio',10366778,'calle 99'),
       ('Marlon','Sacarias',30344589,'calle 39'),
       ('Lara','Penia',40789789,'calle 190'),
       ('Totoro','Astro',20896749,'Cocoro 123');

--inserto los valores en la tabla producto--
insert into product (product_name, product_price, product_amount, product_description)
values ('Taza', 500, 10, 'Tazas con logos de super heroes'),
       ('Mate', 850, 20, 'Mates 3D varios motivos'),
       ('Termo', 1000, 7, 'Termo 1L'),
       ('Yerbera', 200, 5, 'Yerbera varios colores'),
       ('Soporte Celular', 430, 10, 'Soportes con forma de animales'),
       ('Soporte Auriculares', 850, 9, 'Soporte de pie'),
       ('Lapicero', 350, 10, 'Lacpiceros varios motivos'),
       ('Ajedrez', 1200, 3, 'Ajedrez medival'),
       ('Maceta', 700, 6, 'Maceta de pokemon'),
       ('Azucarera', 200, 5, 'Azucarera varios colores');

--inserto los valores en la tabla factura --
insert into factura ( fecha , client_id, product_id, product_price, product_amount)
values ('2022-07-12', 1, 1, 500, 4);
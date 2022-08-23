
--creo la tabla empresa--
create table company ( company_id int not null auto_increment, company_name varchar(255) not null,company_business_name varchar(255) not null, company_heading varchar(255) not null, PRIMARY KEY(company_id) );

--creo la tabla cliente--
create table client ( client_id int not null auto_increment, client_name varchar(255) not null, client_last_name varchar(255) not null, client_dni varchar(255) not null, client_direction varchar(255) not null, client_password varchar(255) not null , PRIMARY KEY(client_id) );

--creo la tabla producto--
create table product (product_id int not null auto_increment, product_name varchar(255) not null, product_price float not null, product_amount int not null, product_description varchar(255) not null,PRIMARY KEY(product_id) );

--creo la tabla factura--
create table invoice (invoice_id int not null auto_increment, invoice_date date not null,company_id int not null , client_id int not null, amount_total int, price_total float, PRIMARY KEY(invoice_id),FOREIGN KEY(company_id) references company, FOREIGN KEY(client_id) references client);

--creo la tabla factura detalle--
create table invoice_detail (invoice_detail_id int not null auto_increment, invoice_id int , product_name varchar(255) not null, price float, amount int not null, PRIMARY KEY(invoice_detail_id),FOREIGN KEY(invoice_id) references invoice);


--inserto los valores en la tabla empresa--
insert into company ( company_name , company_business_name, company_heading)
values ('Almacen 3D', 'Almacen 3D S.A', 'Articulos generales 3D');

--inserto los valores en la tabla cliente--
insert into client ( client_name , client_last_name ,client_dni, client_direction, client_password )
values ('Juan','Bartolo', 20346789,'Av Mitre 200', '123456789'),
       ('Maria','Del Barrio',10366778,'calle 99', '123456789'),
       ('Marlon','Sacarias',30344589,'calle 39', '123456789'),
       ('Lara','Penia',40789789,'calle 190', '123456789'),
       ('Totoro','Astro',20896749,'Cocoro 123', '123456789');

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

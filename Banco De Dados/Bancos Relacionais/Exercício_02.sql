create database db_ecommerce;
use db_ecommerce;
create table tb_produtos(
id bigint auto_increment,
nome varchar (255) not null,
marca varchar(255),
categoria varchar(50),
quantidade int not null,
preco decimal (10) not null,
primary key (id));

use db_ecommerce;

insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "boneca" , "Entrela" , "brinquedos" , 125 , 75.00);
insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "io-io" , "Matel" , "brinquedos" , 124 , 6.9);
insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "Microondas" , "Eletroluz" , "casa" , 854 , 400);
insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "copo" , "vidropuro" , "casa" , 621 , 8);
insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "xicara" , "Nardir" , "casa" , 12 , 15);
insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "celular" , "Apple" , "Eletronico" , 302 , 7500);
insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "fone de ouvido" , "Xiaome" , "Eletronico" , 451 , 150);
insert into tb_produtos(nome , marca , categoria , quantidade , preco) value ( "Televisao" , "samsung" , "eletronico" , 332 , 4500);

select * from tb_produtos;


select * from tb_produtos where preco>500;

select * from tb_produtos where preco<500;

update tb_produtos set nome = "Barbie" where id=1;





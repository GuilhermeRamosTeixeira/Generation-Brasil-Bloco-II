create database db_farmacia_do_bem;

use db_farmacia_do_bem;

create table tb_Categoria(
id bigint auto_increment,
Tarja varchar(255),
primary key(id)
);

insert into tb_Categoria (Tarja) value ("Amarela");
insert into tb_Categoria (Tarja) value ("Vermelha");
insert into tb_Categoria (Tarja) value ("Preta");

create table tb_Produtos(
id bigint auto_increment,
nome varchar(255) not null,
estoque boolean not null,
quantidade int not null,
Comprimidos int not null,
Categoria_id bigint,
primary key(id),
foreign key(Categoria_id) references tb_Categoria(id)
);

alter table tb_Produtos add valor decimal(4,2) not null;
 
insert into tb_Produtos (nome , estoque , quantidade , comprimidos , Categoria_id , valor )value
("Maracujina" , false , 356 ,24 ,1 , 10.50);
insert into tb_Produtos (nome , estoque , quantidade , comprimidos , Categoria_id , valor )value
("Dorflex" , true , 125 ,12 ,1 , 12.75);
insert into tb_Produtos (nome , estoque , quantidade , comprimidos , Categoria_id , valor )value
("Melhorol" , true , 60 ,4 ,2,50.99);
insert into tb_Produtos (nome , estoque , quantidade , comprimidos , Categoria_id, valor )value
("vomitilha" , true , 45 ,6 ,3,45.25);
insert into tb_Produtos (nome , estoque , quantidade , comprimidos , Categoria_id, valor )value
("tonturol" , true , 60 ,12 ,2, 78.89);
insert into tb_Produtos (nome , estoque , quantidade , comprimidos , Categoria_id, valor )value
("Girassoli" , true , 78 ,24 ,3,36.99);
insert into tb_Produtos (nome , estoque , quantidade , comprimidos , Categoria_id , valor)value
("Lembrol" , true , 100 ,12 ,2 , 65.99);

select * from tb_Produtos where valor >50;

select * from tb_Produtos where valor >=3 and valor <=60;

select * from tb_Produtos where tb_Produtos.nome like "%b%";

select tb_Produtos.nome , tb_Produtos.estoque , tb_Produtos.quantidade , tb_Produtos.comprimidos
, tb_Categoria.Tarja , tb_Produtos.valor from tb_Produtos
inner join tb_categoria on tb_categoria.id = tb_Produtos.Categoria_id

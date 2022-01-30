create database db_RH;
use db_RH;
create table tb_Funcionarios(
id bigint auto_increment,
nome varchar(255) not null,
setor varchar (255) not null,
salario decimal not null,
primary key(id));

alter table tb_Funcionarios add Registro int (10);

use db_RH;

insert into tb_Funcionarios(nome , setor , salario ,Registro) values ("Calos Silva" , "Limpeza" , 2500 , 125);
insert into tb_Funcionarios(nome , setor , salario ,Registro) values ("Maria Clara" , "Informatica" , 7500 , 458);
insert into tb_Funcionarios(nome , setor , salario ,Registro) values ("Gustavo Mioto" , "administrativo" , 3500 , 698);
insert into tb_Funcionarios(nome , setor , salario ,Registro) values ("Tatuani Creids" , "Manutenção" , 5500 , 754);
insert into tb_Funcionarios(nome , setor , salario ,Registro) values ("GinGin truefalce" , "Limpeza" , 2800 , 325);

select * from tb_Funcionarios;

select * from tb_Funcionarios where salario>2000;

select * from tb_Funcionarios where salario<2000;
use db_RH;
update tb_Funcionarios set salario =3100 where id=2;

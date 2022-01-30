create database db_escola;
use db_escola;
create table tb_estudantes(
id bigint auto_increment,
nome varchar(255) not null,
matricula int not null,
curso varchar(50),
media decimal not null,
faltas int not null,
primary key(id));

select * from tb_estudantes;

use db_escola;

insert into tb_estudantes(nome , matricula , curso , media , faltas) value (" Camila int" , 4589 , "Gastronomia" , 6 , 4);
insert into tb_estudantes(nome , matricula , curso , media , faltas) value (" Lucas toit" , 1589 , "Direito" , 5.0 , 7);
insert into tb_estudantes(nome , matricula , curso , media , faltas) value (" Riyu tay" , 1258 , "Informatica" , 7.8 , 5);
insert into tb_estudantes(nome , matricula , curso , media , faltas) value (" Anderson lordez" , 3269 , "Letras" , 9.5 , 3);
insert into tb_estudantes(nome , matricula , curso , media , faltas) value (" Bruno Celeste" , 1587 , "Economia" , 10 , 10);
insert into tb_estudantes(nome , matricula , curso , media , faltas) value (" Diegu intamaré" , 6581 , "edu . Fisica" , 4.5 , 11);
insert into tb_estudantes(nome , matricula , curso , media , faltas) value ("harry Potter" , 8154 , "Desiner" , 7.1 , 1);
insert into tb_estudantes(nome , matricula , curso , media , faltas) value (" Hermione Granger" , 6259 , "Medicina" , 6.9 , 9);


select * from tb_estudantes where media >7;

select * from tb_estudantes where media <7;

update tb_estudantes set media = 8 where id = 5;

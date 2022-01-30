create database db_Generation_Game_Online;

create table tb_Classe(
id bigint auto_increment,
SerMafico varchar(255),

primary key(id));

alter table tb_Classe drop SerMafico;
alter table tb_Classe add SerMagico varchar(255);
use db_Generation_Game_Online;

insert into tb_Classe (SerMagico) value("Bruxo");
insert into tb_Classe (SerMagico) value( "Doende");
insert into tb_Classe (SerMagico) value( "Elfo");
insert into tb_Classe (SerMagico) value( "Aborto");

use db_Generation_Game_Online;

create table tb_Personagens(
id bigint auto_increment,
nome varchar(255),
ataque int not null,
defesa int not null,
Classe_id bigint not null,
primary key(id),
foreign key(Classe_id) references tb_Classe(id));


insert into tb_Personagens( nome , ataque , defesa , Classe_id ) value ("Harry Potter" , 450 , 560 , 1 );
insert into tb_Personagens( nome , ataque , defesa , Classe_id ) value ("Dobby" , 600 , 800 , 3);
insert into tb_Personagens( nome , ataque , defesa, Classe_id  ) value ("Grampo " , 140 , 160 , 2 );
insert into tb_Personagens( nome , ataque , defesa, Classe_id  ) value ("Ronny Potter" , 350 , 410 , 1 );
insert into tb_Personagens( nome , ataque , defesa, Classe_id  ) value ("Filty " , 40 , 70 , 4);
insert into tb_Personagens( nome , ataque , defesa , Classe_id ) value ("Albus Dumbledore " , 2000 , 2000 , 1 );
insert into tb_Personagens( nome , ataque , defesa, Classe_id  ) value ("Monstro" , 530 , 690  , 3);
insert into tb_Personagens( nome , ataque , defesa , Classe_id ) value ("Senhora Figg" , 0 , 50 , 4 );

update tb_Personagens set Classe_id = 3 where id=7;

select *from tb_personagens where ataque>1000;


select *from tb_personagens where ataque>500 and ataque <1000;

select * from tb_Personagens where nome like "%dum%";

select * from tb_personagens join tb_Classe on tb_Classe.id = tb_Personagens.Classe_id;

select tb_personagens.nome , tb_personagens.ataque , tb_personagens.defesa , tb_classe.SerMagico from tb_personagens 
inner join tb_Classe on tb_Classe.id = tb_Personagens.Classe_id;


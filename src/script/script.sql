
use dcompifmalp3spfjdbcwesley;

show tables;

desc aluno;

desc disciplina;

insert into aluno(nome,endereco,rg,cpf,telefone) values('luis','Turo','646465464','046524569898','9814524654');

select * from aluno where id = 1;

delete from aluno where id=4;

select * from aluno;

insert into curso(nome) values('Sistemas');

select * from curso;

select * from curso where id = 1;

delete from curso where id = 1;

insert into disciplina(nome,ementa,cargahr) values('Estrutura de dados','Ponteiroso','90');

select * from disciplina;

select * from disciplina where id = '1';

delete from disciplina where id = 1;

insert into professor(nome) values('Luna');

select * from professor;

select * from professor where id = '1';

delete from professor where id = 1;

insert into grade(ano,id_curso,id_disciplina) values('2019',2,1);

select * from curso;

select * from disciplina;

select * from grade;

delete from grade where id_curso =1; 

delete from curso where id =14; 

delete from grade where id_curso =1; 

insert into professordisciplina(id_professor,id_disciplina) values(2,2);

desc professordisciplina;

select * from professordisciplina;

select * from matricula;

insert into matricula(id_aluno,id_curso) values(1,1);

select * from matricula;

delete from matricula where id_aluno = 3;

delete from curso where id = 11;

delete from professordisciplina where id_professor = 3;
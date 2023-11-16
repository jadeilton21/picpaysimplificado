create table users(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    sobreNome varchar(100) not null,
    email varchar(100) not null unique,
    passoword varchar(100) not null,
    balance varchar(100),
    typeUser varchar(100),


    primary key(id)



);
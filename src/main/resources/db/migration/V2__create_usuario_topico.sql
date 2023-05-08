create table usuario(
    id bigint not null auto_increment,
    nome varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

insert into usuario values(1, 'Ana da Silva', 'ana@email.com');

create table topico(
    id bigint not null auto_increment,
    titulo varchar(50) not null,
    mensagem varchar(300) not null,
    data_criacao datetime not null,
    status varchar(20) not null,
    curso_id bigint not null,
    autor_id bigint not null,
    primary key(id),
    foreign key(curso_id) references curso(id),
    foreign key(autor_id) references usuario(id)
);

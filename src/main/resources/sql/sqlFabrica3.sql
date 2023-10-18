create database if not exists ControleTechFabrica3;
use ControleTechFabrica3;

drop table if exists produto_has_software;
drop table if exists produto_has_categoria;
drop table if exists produto_has_fornecedor;
drop table if exists users_has_produto;
drop table if exists fornecedor;
drop table if exists categoria;
drop table if exists produto;
drop table if exists subLocal;
drop table if exists localArmazenado;
drop table if exists software;
drop table if exists users;

#user é uma palavra reservada, por isso foi adotado o "users"
create table users(
id				int 			not null		primary key		auto_increment,
nome	 		VARCHAR(100)	not null,
login			VARCHAR(45)		not null,
user_password	VARCHAR(100)	not null,	#Comando MD5 na inserção faz a cryptografia da senha
endereco		VARCHAR(200)	not null
);
create table subLocal(
id				int 			not null		primary key 	auto_increment,
nomeLocal 		VARCHAR(100)	not null,
endereco		VARCHAR(200)	not null,
descricao		VARCHAR(300)	not null
);

create table localArmazenado(
id				int 			not null		primary key 	auto_increment,
nomeLocal 		VARCHAR(100)	not null,
endereco		VARCHAR(200)	not null,
descricao		VARCHAR(300)	not null,
subLocal        int             ,
foreign key(subLocal) references subLocal(id)
);


create table produto(
id				int 			not null		primary key		auto_increment,
nome			VARCHAR(100)	not null,
qntEstoque		int,
valorItem		double			not null,
dataAquisicao	date			not null,
statusAtivo		VARCHAR(50)		not null,
descricao		VARCHAR(300),
idLocalArmazenado		int 			not null,
foreign key (idLocalArmazenado) references localArmazenado (id)

);

create table ativoFisico(
id_ativo	int 	not null	primary key auto_increment,
id_usuario int not null,
id_produto int not null,
foreign key (id_usuario) references users(id),
foreign key (id_produto) references produto(id)
	);
create table software(
id_software 				int 			not null		primary key 	auto_increment,
versao 			VARCHAR(15)		not null,
data_expira		date			not null,
n_licenca         VARCHAR(100),
tipo_OS           VARCHAR(100),
id_produto      int				not null,
foreign key (id_produto) references produto (id)
);


create table categoria(
id 				int 			not null		primary key 	auto_increment,
nome			VARCHAR(100)	not null
);

create table fornecedor(
id 				int 			not null		primary key		auto_increment,
nome			VARCHAR(100)	not null,
endereco		VARCHAR(200)	not null,
cnpj			VARCHAR(45)		not null
);

create table users_has_produto(
id_users		int 			not null,
id_produto		int 			not null,
foreign key (id_users) references users (id),
foreign key (id_produto) references produto (id)
);

create table produto_has_fornecedor(
id_produto			int 			not null,
id_fornecedor		int 			not null,
foreign key (id_produto) references produto (id),
foreign key (id_fornecedor) references fornecedor (id)
);

create table produto_has_categoria(
id_produto			int 			not null,
id_categoria 		int 			not null,
foreign key (id_produto) references produto (id),
foreign key (id_categoria) references categoria (id)
);
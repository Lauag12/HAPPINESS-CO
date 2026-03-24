create user happinessCo identified by happinessCo;
/* DAR PERMISOS */
grant connect, resource to happinessCo;

create table usuarios (
id char (11),
nombre varchar2 (40),
email varchar2 (50),
password varchar2 (20),
constraint pk_usuarios primary key (id)
);

create table Eventos (
id char (11),
fecha date (),
titulo (),
ubicacion (),
descripcion (),
constraint pk_usuarios primary key (id)
);

create table galerias(
id char (),
titulo (),
id evento (),
constraint pk_usuarios primary key (id)
);

create table imagenGalerias(
id char(),
titulo (),
imagen (),
id galeria (),
constraint pk_usuarios primary key (id)
);

create table favoritos (
id usuario char (),
constraint pk_usuarios primary key (id)
);

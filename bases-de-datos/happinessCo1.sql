create user happinessCo1 identified by happinessCo1;
/* DAR PERMISOS */
grant connect, resource to happinessCo1;

grant create view to happinessCo1;
create table usuarios (
id_usuario char (11) not null,
nombre varchar2 (100) not null,
email varchar2 (100) not null unique,
"password" varchar2 (150) not null,
constraint pk_usuarios primary key (id_usuario)
);

create table eventos (
id_eventos varchar2 (2) not null,
fecha date not null,
titulo varchar2(100) not null,
ubicacion varchar2(100) not null,
descripcion varchar2(1000),
constraint pk_eventos primary key (id_eventos)
);

create table galerias(
id_galerias varchar2 (2) not null,
titulo varchar2 (100),
id_evento varchar2 (2) not null,
constraint pk_galerias primary key (id_galerias),
constraint fk_galEven foreign key (id_evento) references eventos (id_eventos)ON DELETE CASCADE
);

create table imagenes(
id_imagen char(11) not null,
titulo varchar2(100) not null,
imagen varchar2(200) not null,
id_galeria  varchar2 (2) not null,
constraint pk_imagenes primary key (id_imagen),
constraint fk_imgGal foreign key (id_galeria) references galerias (id_galerias)ON DELETE CASCADE
);

create table favoritos (
id_usuario char (11) not null,
id_evento  varchar2 (2) not null,
constraint pk_favoritos primary key (id_usuario, id_evento),
constraint fk_favUser foreign key (id_usuario) references  usuarios (id_usuario),
constraint pk_xfavEven foreign key (id_evento) references eventos (id_eventos)
);

/*INFORMACIÓN DE LOS USUARIOS REGISTRADOS*/
INSERT INTO usuarios VALUES (20250912001, 'Carlos Sanchez Moreno', 'carlos@gmail.com', '1234abcd');
INSERT INTO usuarios VALUES (20250912002, 'Carmen Guierres Torres', 'carmen@gmail.com', '123abcd');
INSERT INTO usuarios VALUES (20251020001, 'Laura Peréz Martínez', 'laura@gmail.com', '123896');
INSERT INTO usuarios VALUES (20251024001, 'Carlos Hernandéz Hernandéz', 'carlos1@gmail.com', '123567');
INSERT INTO usuarios VALUES (20251024002, 'Christopher Fernandez Jiménez', 'christopher@gmail.com', '123');
INSERT INTO usuarios VALUES (20251124001, 'Maria Muñoz Álvares', 'maria@gmail.com', '123abcd');
INSERT INTO usuarios VALUES (20251124002, 'Pablo Sanchez Martín', 'pablo@gmail.com', '123abcdjh');
INSERT INTO usuarios VALUES (20251117001, 'Camila Vasquez Velasquez', 'camila@gmail.com', '123abcdef');
INSERT INTO usuarios VALUES (20251117002, 'Lorena Manrique Manrique', 'lorena@gmail.com', '123abcdef');
INSERT INTO usuarios VALUES (20251130001, 'Alberto Blanco Lopez', 'alberto@gmail.com', '123abcdef');
INSERT INTO usuarios VALUES (20251130002, 'Miguel De la Fuente', 'miguel@gmail.com', '123abcdef');
INSERT INTO usuarios VALUES (20251212001, 'Ana Arroyave ', 'ana@gmail.com', '1234');
INSERT INTO usuarios VALUES (20251212002, 'Juan Gonzalez Fuentes', 'juan@gmail.com', '12345');
INSERT INTO usuarios VALUES (20251212003, 'Sandra Gomez Lopez', 'sandra@gmail.com', '123456789');
INSERT INTO usuarios VALUES (20251215001, 'Abby Rincon García', 'abby@gmail.com', '1234567899');
INSERT INTO usuarios VALUES (20251228001, 'Andres Díaz Moreno', 'andres@gmail.com', '123abc');




/*Información de los eventos pasados*/
INSERT INTO eventos VALUES (1, '01-01-2026','Huele a parentesco','Asturias','Experiencia sensorial sobre fermentación');
INSERT INTO eventos VALUES (2, '12-01-2026','Mercado de Avilés','Avilés','Mercado histórico con productos locales');
INSERT INTO eventos VALUES (3, '24-01-2026','Circuito artes escénicas','Asturias','Danza, teatro y espectáculos');

/*Información de enventos próximos*/
INSERT INTO eventos VALUES (4,'27-03-2026','Las mujeres del Huila','Neiva','Música, interpretación de instrumentos');
INSERT INTO eventos VALUES (5,'29-04-2026','Museo de Botero','Bogotá','Arte, Exposición colombiana de 208 obras');
INSERT INTO eventos VALUES (6,'24-05-2026','Museo del oro','Bogotá','Arte y cultura, exhibición de colecciones arqueológicas patrimoniales');
INSERT INTO eventos VALUES (7,'05-06-2026','Corales','Avilés','Exposición sobre corales y cambio climático');
INSERT INTO eventos VALUES (8,'15-06-2026','Agua','Avilés','Fotografía sobre el agua');
INSERT INTO eventos VALUES (9, '25-06-2026','Junio de cine','Avilés','Programa de cine en el Niemeyer');

/*Galerias*/
INSERT INTO galerias VALUES (1,'Galería-Museo de oro',6);
INSERT INTO galerias VALUES (2,'Galería-Museo de Botero',5);
INSERT INTO galerias VALUES (3,'Galería-Centro cultural Neiva',4);
INSERT INTO galerias VALUES (4,'Galería-Centro Niemeyer Cine',9);
INSERT INTO galerias VALUES (5, 'Galería-La Laboral',1);
INSERT INTO galerias VALUES (6, 'Galería-Mercado Áviles',2);
INSERT INTO galerias VALUES (7, 'Galería-Asturias Artes',3);
INSERT INTO galerias VALUES (8, 'Galería-Centro Neymer Corales',7);
INSERT INTO galerias VALUES (9, 'Galería-Centro Neymar Agua',8);
-- Evento 1 Huele a parentesco

INSERT INTO imagenes VALUES (1,'Imagen1','./assets/img/huele-parentesco1.jpg',1);
INSERT INTO imagenes VALUES (2,'Imagen2','./assets/img/huele-parentesco2.jpg',1);
INSERT INTO imagenes VALUES (3,'Imagen3','./assets/img/huele-parentesco3.jpg',1);

-- Evento 2 Mercado Áviles

INSERT INTO imagenes VALUES (4,'Imagen1','./assets/img/mercado.jpg',2);
INSERT INTO imagenes VALUES (5,'Imagen2','./assets/img/mercado1.jpg',2);
INSERT INTO imagenes VALUES (6,'Imagen3','./assets/img/mercado2.jpg',2);

-- Evento 3 Circuito de artes escénicas

INSERT INTO imagenes VALUES (7,'Imagen1','./assets/img/artes-1.jpg',3);
INSERT INTO imagenes VALUES (8,'Imagen2','./assets/img/artes-2.jpg',3);
INSERT INTO imagenes VALUES (9,'Imagen3','./assets/img/artes-3.jpg',3);
 
-- Usuario 1

INSERT INTO favoritos VALUES (20250912001,1);
INSERT INTO favoritos VALUES (20250912001,2);
INSERT INTO favoritos VALUES (20250912001,4);

-- Usuario 2

INSERT INTO favoritos VALUES (20251024002,2);
INSERT INTO favoritos VALUES (20251024002,3);
INSERT INTO favoritos VALUES (20251024002,5);

-- Usuario 3

INSERT INTO favoritos VALUES (20251212002,1);
INSERT INTO favoritos VALUES (20251212002,3);
INSERT INTO favoritos VALUES (20251212002,6);
 
 
 /*Primera Vista, devuelve galerias anteriores de la fecha 28/02/2026*/
CREATE or replace VIEW galerias_anteriores AS
    SELECT galerias.id_galerias, galerias.titulo, eventos.id_eventos, eventos.fecha
    FROM galerias, eventos
    WHERE (eventos.fecha) < to_date('28-02-2026' ,'dd-mm-yyyy')and galerias.id_evento = eventos.id_eventos;
 
 --Visualización de vista
select *
from  galerias_anteriores;
 
 /*Devuelvan los eventos favoritos del usuario 1.    ID del usuario 1 es 20250912001   */
   
CREATE or replace VIEW eventos_favoritos AS
  SELECT eventos.*
  FROM favoritos, eventos
  WHERE (id_usuario = 20250912001) and (eventos.id_eventos=favoritos.id_evento);
  
  SELECT*
  FROM eventos_favoritos;
  
 /*Devuelvan las imágenes de la galería del evento del 12-01-2026 (usar su id para crear la vista, no la fecha).
   El evento de la fecha 12/01/2026 tiene el ID 2 */
   
 CREATE or replace VIEW imagenes_mercado_aviles AS
  SELECT imagenes.*
  FROM imagenes, galerias
  WHERE (galerias.id_evento = 2) and (imagenes.id_galeria = galerias.id_galerias);
  
   SELECT*
  FROM imagenes_mercado_aviles;
  
 /*Devuelvan los eventos favoritos del usuario 2 posteriores al 28-02 2026. 
   ID del usuario 2 es 20251024002*/

CREATE VIEW vista_fav_u2_prox AS
    SELECT eventos.*
    FROM eventos, favoritos
    WHERE (id_usuario = 20251024002) and eventos.fecha >to_date('28-02-2026' ,'dd-mm-yyyy') and (eventos.id_eventos = favoritos.id_evento);
    
      SELECT*
  FROM vista_fav_u2_prox;
  
 

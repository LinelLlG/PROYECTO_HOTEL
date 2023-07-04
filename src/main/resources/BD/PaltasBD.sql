-- BASE DE DATOS (HOTEL - NETBEANS)
--
Create database bd_proyecto_hotel_dawii;
--
Use bd_proyecto_hotel_dawii;
--
/*COMBO BOX*/
create table tb_cargo(
cod_crg		int		primary key		not null,
nom_crg		varchar(50)
);
--
insert into tb_cargo values(1,'Mesero(a)');
insert into tb_cargo values(2,'Limpieza');
insert into tb_cargo values(3,'Recepcionista');
insert into tb_cargo values(4,'Anfitrion(a)');
insert into tb_cargo values(5,'Bartender');
insert into tb_cargo values(6,'Administrador(a)');
--
create table tb_pago(
cod_pago		int		primary key		not null,
des_pago		varchar(50)
);
--
insert into tb_pago values(1,'Tarjeta');
insert into tb_pago values(2,'Efectivo');
insert into tb_pago values(3,'Transferencia');
--
create table tb_origen(
cod_orig		int		primary key		not null,
des_orig		varchar(50)
);
--
insert into tb_origen values(1,'En espera');
insert into tb_origen values(2,'Ocupada');
insert into tb_origen values(3,'Salida');
--
create table tb_estado(
cod_est		int		primary key		not null,
des_est		varchar(50)
);
--
insert into tb_estado values(1,'Saldo 0%');
insert into tb_estado values(2,'Saldo 50%');
insert into tb_estado values(3,'Saldo 100%');
--
create table tb_pais(
cod_pais int primary key auto_increment not null,
nom_pais varchar(30)
);
--
insert into tb_pais values(1,'Peru');
insert into tb_pais values(2,'Argentina');
insert into tb_pais values(3,'España');
insert into tb_pais values(4,'Colombia');
insert into tb_pais values(5,'EEUU');
insert into tb_pais values(6,'Brazil');
--
create table tb_tip_servicio(
cod_tip_serv int primary key auto_increment not null,
nom_tip_serv varchar(30)
);
--
insert into tb_tip_servicio values(1,'Tragos');
insert into tb_tip_servicio values(2,'Almuerzo');
insert into tb_tip_servicio values(3,'Cena');
--
create table tb_sede(
cod_sed		int primary key auto_increment not null,
nom_sed		varchar(30),
cod_pais	int references tb_pais
);
--
insert into tb_sede values(1,'Lima',1);
insert into tb_sede values(null,'Trujillo',1);
insert into tb_sede values(null,'Arequipa',1);
insert into tb_sede values(null,'Ica',1);
insert into tb_sede values(null,'Cuzco',1);
insert into tb_sede values(null,'Piura',1);
insert into tb_sede values(null,'Buenos Aires',2);
insert into tb_sede values(null,'La Plata',2);
insert into tb_sede values(null,'Rosario',2);
insert into tb_sede values(null,'Ciudad de Santa Fe',2);
insert into tb_sede values(null,'Mendoza',2);
insert into tb_sede values(null,'Barcelona',3);
insert into tb_sede values(null,'Madrid',3);
insert into tb_sede values(null,'Valencia',3);
insert into tb_sede values(null,'Sevilla',3);
insert into tb_sede values(null,'Granada',3);
insert into tb_sede values(null,'Medellin',4);
insert into tb_sede values(null,'Cali',4);
insert into tb_sede values(null,'Barranquilla',4);
insert into tb_sede values(null,'Bogota',4);
insert into tb_sede values(null,'Cúcuta',4);
insert into tb_sede values(null,'Washington DC',5);
insert into tb_sede values(null,'New York',5);
insert into tb_sede values(null,'Los Angeles',5);
insert into tb_sede values(null,'Detroit',5);
insert into tb_sede values(null,'Boston',5);
insert into tb_sede values(null,'Brasilia',6);
insert into tb_sede values(null,'Rio de Janeiro',6);
insert into tb_sede values(null,'Manau',6);
insert into tb_sede values(null,'Recife',6);
insert into tb_sede values(null,'Curitiva',6);
insert into tb_sede values(null,'Belén',6);
--
Create table tb_tipoHabitacion(
cod_tip_hab		int		primary key		not null,
nom_tip_hab		varchar(50)
);
--
insert into tb_tipoHabitacion values(1,'Matrimonial');
insert into tb_tipoHabitacion values(2,'Triple');
insert into tb_tipoHabitacion values(3,'Cuadrupe');
insert into tb_tipoHabitacion values(4,'Quintuple');
--
create table tb_pisos(
cod_pis		int		primary key,
nom_pis		varchar(50)
);
--
insert into tb_pisos values(1,'Primer piso');
insert into tb_pisos values(2,'Segundo piso');
insert into tb_pisos values(3,'Tercer piso');
--
create table tb_tipoCliente(
cod_tip_cli	int	primary key,
nom_tip_cli	varchar(50)
);
--
insert into tb_tipoCliente values(1,'Huesped');
insert into tb_tipoCliente values(2,'Full Day');
--
select*from tb_tipoCliente;
--
create table tb_tipo_Stock(
cod_tip_stock		int		primary key,
nom_tip_stock		varchar(50)
);
--
insert into tb_tipo_Stock values(1,'Snacks');
insert into tb_tipo_Stock values(2,'Galletas');
insert into tb_tipo_Stock values(3,'Dulces');
insert into tb_tipo_Stock values(4,'Bebidas');
insert into tb_tipo_Stock values(5,'Licores');
--
Create table tb_disponibilidad(
cod_disp		int		primary key,
disponibilidad	varchar(2)
);
--
insert into tb_disponibilidad values(1,'si');
insert into tb_disponibilidad values(2,'no');
--
select*from tb_disponibilidad;
--
Create table tb_pabellon(
cod_pab		int		primary key,
des_pab		varchar(30)
);
--
insert into tb_pabellon values(1,'P - 1');
insert into tb_pabellon values(2,'P - 2');
insert into tb_pabellon values(3,'P - 3');
--
Create table tb_tipoContrato(
cod_con		int		primary key,
des_con		varchar(30)
);
--
insert into tb_tipocontrato values(1,'Temporal');
insert into tb_tipocontrato values(2,'Part-time');
insert into tb_tipocontrato values(3,'Indeterminado');
--
/*--TABLAS PRINCIPALES--*/
--
Create table tb_habitaciones(
cod_hab			int	primary key		auto_increment,
num_hab			varchar(5), 
nom_hab			varchar(50),
cod_pab			int 	references tb_pabellon,
cod_tip_hab		int		references	tb_tipoHabitacion,
cod_pis			int		references	tb_pisos,
cod_disp		int 	references tb_disponibilidad
);
--
insert into tb_habitaciones values(1,'101','Los Lucumos',2,4,1,1);
--
create table tb_clientes (
cod_cli		int		primary key		auto_increment,
nom_cli		varchar(50),
ape_cli		varchar(50),
dni_cli		char(9),
ruc_cli		char(11),
cel_cli		varchar(9),
email_cli	varchar(50),
dir_cli		varchar(50),
cod_tip_cli	int		references tb_tipoCliente,
cod_disp		int 	references tb_disponibilidad
);
--
insert into tb_clientes values(1,'Leonel','Guzman Ramirez','45251241','12541236524','954854123','leonel@gmail.com','av los paltos 123',1,1);
--
select*from tb_clientes;
create TABLE tb_empleado(
cod_emp			int		primary	key		auto_increment,
nom_emp			varchar(50),
ape_emp			varchar(50),
dni_emp			char(9),
email_emp		varchar(50),
cel_emp			varchar(9),
dir_emp			varchar(50),
fec_nac_emp		date,
hijos_emp		int,
prof_emp		varchar(15),
sueldo_emp		decimal,
cod_crg			int		references		tb_cargo,
cod_con			int 	references tb_tipocontrato,
cod_disp		int 	references tb_disponibilidad
);
--
create table tb_proveedor(
cod_prov 		int primary key auto_increment,
ruc_prov		char(11),
nom_prov		varchar(45),
rep_legal_prov	varchar(45),
dir_prov		varchar(50),
tlf_prov		varchar(12),
email_prov		varchar(45),
fec_reg_prov	date,
cod_pais 		int references tb_pais,
cod_sed 		int references tb_sede,
suc_prov		varchar(30),
cod_disp		int 	references tb_disponibilidad
);
--
insert into tb_proveedor values(1,'10121335321','Coca Cola','Juan Marquina','av centro 124','04495','coca_cola@hotmail.com','2022-10-10',1,1,'centro',1);
--
create table tb_servicio(
cod_serv			int	primary key auto_increment,
des_serv			varchar(50),
cod_tip_serv		int references tb_tip_servicio,
pre_serv			decimal(10,2),
cod_disp		int 	references tb_disponibilidad
);
--
insert into tb_servicio values(1,'Daiquiri',1,20.00,1);
insert into tb_servicio values(2,'Mojito',1,20.00,1);
insert into tb_servicio values(3,'Pato Guisado',2,35.00,1);
--
create table tb_stock(
cod_stock			int	primary key auto_increment,
nom_stock			varchar(50),
cant_stock			int,
cod_tip_stock		int	references tb_tipoStock,
pre_venta_stock		decimal(10,2),
pre_compra_stock	decimal(10,2),
cod_prov			int references tb_proveedor,
cod_disp		int 	references tb_disponibilidad
);
--
create table tb_reserva
(
cod_res 	int primary key auto_increment,
cod_cli		int references tb_clientes,
cod_hab		int references tb_habitaciones,
pre_res		decimal(10,2),
check_in	date,
check_out	date,
cod_orig	int references tb_origen,	
cod_est		int references tb_estado,
cod_pago	int references tb_pago		
);
--
insert into tb_reserva values(1, 1, 1, 250.00, '2023-06-10', '2023-06-08', 1,1,1);
update tb_reserva set cod_orig = 1 where cod_res = 1;
--
/*LOGIN CON ROLES*/
--
--
Create table tb_usuarios(
	cod_usuarios		int		primary key auto_increment,
    username		varchar(50),
    clave		varchar(250)
);
--
insert into tb_usuarios values(1, "admin","$2a$10$TkVh2e32SPAIfnTNQdQCXOPV06vnfFDvYlIsTIBJkcOx8knMP98.q");
insert into tb_usuarios values(2, "recepcion", "$2a$10$83A0gdYaeUBTo7p36ZtycudWS1n1rZn30vHqj6wlImFWIN8V.9cdK");
--
Create table tb_roles(
	cod_roles		int		primary key auto_increment,
    nom_roles		varchar(30),
    cod_usuarios	int 	references	tb_usuarios
);
--
insert into tb_roles values (1, "ROLE_ADMIN", 1);
insert into tb_roles values (2,"ROLE_RECEPCION", 1);
insert into tb_roles values (3, "ROLE_RECEPCION", 2);
--
-- TRIGGER PARA RECALCULAR DISPO
--
delimiter 
create  trigger recalcularStockTrigger
after insert on tb_reserva
for each row
	begin
		declare codHab int ;
        set codHab = new.cod_hab;
		update tb_habitaciones set cod_disp = 2 where cod_hab = codHab;
end

$$

delimiter $$
create  trigger recalcularDispoTrigger
after update on tb_reserva
for each row
    begin
        declare codHab int ;
        set codHab = new.cod_hab;

        if new.cod_orig = 3 
        then
            update tb_habitaciones set cod_disp = 1 where cod_hab = codHab;
        end if;
end;

create table tb_boleta
(
cod_bol 	serial primary key ,
cod_cli		int references tb_clientes,
cod_usuarios	int references tb_usuarios,
fecha		date,
total_bol	decimal(10,2)
);

create table tb_det_boleta
(
cod_bol 	int references tb_boleta,
cod_stock	int references tb_stock,
precio		decimal(10,2),
cantidad 	int,
cod_pago	int references tb_pago,
primary key (cod_bol,cod_stock)
);

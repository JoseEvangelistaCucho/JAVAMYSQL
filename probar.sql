DELIMITER $$
CREATE PROCEDURE agregar(
	IN id int,
	IN nonbre varchar,	
	IN precio NUMERIC(5,2),
	OUT mensaje VARCHAR(50)
)
BEGIN
	
	if(select count(*) from productos where desc_producto=nombre>0,'Se inserto Corecctamente','ERROR : No se inserto');
	INSERT INTO productos
		(id_producto,desc_producto,precio)
		VALUES
		(id,nombre,precio);
	
END$$
DELIMITER;
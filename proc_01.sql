DELIMITER $$
DROP PROCEDURE IF EXISTS calcular_tipo_cambio;
CREATE PROCEDURE calcular_tipo_cambio(
	IN monto numeric(6,2),
	OUT monto_final NUMERIC(6,2)
)
 BEGIN 
	DECLARE tipo_cambio NUMERIC(6,2); 
	DECLARE cantidad INT;
	DECLARE nombre VARCHAR(30);
	DECLARE id INT;
	
	SELECT COUNT(1)
	INTO cantidad
	FROM productos;
	SET monto_final=monto*cantidad;
	SELECT LEFT (MD5(RAND()),8) INTO nombre;
	SELECT FLOOR(1+RAND( )*60)INTO id;
	INSERT INTO productos
		(id_producto,desc_producto,precio)
		VALUES
		(id,nombre,monto_final);
END$$
DELIMITER ;



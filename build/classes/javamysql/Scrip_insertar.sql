DELIMITER $$
DROP PROCEDURE IF EXISTS actualizar_producto;
CREATE PROCEDURE  actualizar_producto(
    IN _P_ID_PRODUCTO int,
    IN _p_nombre VARCHAR(30),
    IN _p_precio NUMERIC(6,2),
    OUT _p_confirm INT
)
BEGIN
    UPDATE productos
        SET nombre=_p_nombre,
            precio=_p_precio
    WHERE idproducto = _p_id_producto;
    --
    IF ROW_COUNT()>0 THEN
        SET _p_confirm =1;
    ELSE
        SET _p_confirm =0;
    END IF;
END$$
DELIMITER ;
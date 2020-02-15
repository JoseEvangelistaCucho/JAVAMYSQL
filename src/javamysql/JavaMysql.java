package javamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JavaMysql {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/tienda?user=root&password=mysqladmin";
            Connection connect = DriverManager.getConnection(url);
            String query = "Select * from productos";
            Statement statement = connect.createStatement();
            ResultSet resulSet = statement.executeQuery(query);
            while (resulSet.next()) {
                int idproducto = resulSet.getInt("idproducto");
                String nombre = resulSet.getString("nombre");
                int precio = resulSet.getInt("precio");
                System.out.println("ID: " + idproducto);
                System.out.println("Nombre: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("======================================");
            }

            Scanner scan = new Scanner(System.in);
            System.out.println("Que deseas hacer : INSERTAR / BORRAR / ");
            String accion = scan.nextLine();
            if (accion.equalsIgnoreCase("INSERTAR")) {
                scan = new Scanner(System.in);
                System.out.println("INGRESAR EL ID_PRODUCTO");
                String idproduc = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el nombre");
                String nombre = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                String precio = scan.nextLine();
                //
                query = "Insert into productos values (?,?,?)";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(idproduc));
                ps.setString(2, nombre);
                ps.setInt(3, Integer.parseInt(precio));
                ps.executeUpdate();
            }
            ///

            if (accion.equalsIgnoreCase("borrar")) {
                scan = new Scanner(System.in);
                System.out.println("INGRESAR EL ID_PRODUCTO");
                String idproduc = scan.nextLine();

                query = "delete from productos where idproducto=?";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setInt(1, Integer.parseInt(idproduc));
                ps.executeUpdate();
            }
            
            if (accion.equalsIgnoreCase("modificar")) {
                scan = new Scanner(System.in);
                System.out.println("INGRESAR EL ID_PRODUCTO");
                String idproduc = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el nombre");
                String nombre = scan.nextLine();

                scan = new Scanner(System.in);
                System.out.println("Ingresa el precio");
                String precio = scan.nextLine();
                //
                query = "update productos set nombre=?,precio=? where idproducto=?";
                PreparedStatement ps = connect.prepareStatement(query);
                ps.setInt(3, Integer.parseInt(idproduc));
                ps.setString(1, nombre);
                ps.setInt(2, Integer.parseInt(precio));
                ps.executeUpdate();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

package ordenatupan.datos;

import ordenatupan.conexion.Conexion;
import ordenatupan.dominio.empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import static ordenatupan.conexion.Conexion.getConexion;

public class empleadosDAO implements IempleadosDAO {
    @Override
    public List<empleados> listarempleados() {
        List<empleados> empleados = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection conexion = getConexion();
        var sql = "SELECT * FROM empleados ORDER BY id_empleado";
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                var empleado  = new empleados();
                empleado.setId_empleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidos(rs.getString("apellidos"));
                empleado.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
                empleado.setGenero(rs.getString("genero"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("email"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setFecha_contratacion(rs.getString("fecha_contratacion"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setHorario_trabajo(rs.getString("horario_trabajo"));
                empleado.setEstado(rs.getString("estado"));
                empleado.setFecha_registro(rs.getString("fecha_registro"));
                empleados.add(empleado);
            }

        }catch (Exception e){
            System.out.println("Error al listar empleados: " + e.getMessage());
        }
        finally {
            try {
                conexion.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion:" + e.getMessage());

            }
        }
        return empleados;
    }


@Override
public boolean buscarEmpleadoPorId(empleados empleados) {
    PreparedStatement ps;
    ResultSet rs;
    var con = getConexion();
    var  sql = "SELECT * FROM empleados WHERE id_empleado = ?";
    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, empleados.getId_empleado());
        rs = ps.executeQuery();
        if (rs.next()) {
            empleados.setNombre(rs.getString("nombre"));
            empleados.setApellidos(rs.getString("apellidos"));
            empleados.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
            empleados.setGenero(rs.getString("genero"));
            empleados.setTelefono(rs.getString("telefono"));
            empleados.setEmail(rs.getString("email"));
            empleados.setDireccion(rs.getString("direccion"));
            empleados.setFecha_contratacion(rs.getString("fecha_contratacion"));
            empleados.setCargo(rs.getString("cargo"));
            empleados.setSalario(rs.getDouble("salario"));
            empleados.setHorario_trabajo(rs.getString("horario_trabajo"));
            empleados.setEstado(rs.getString("estado"));
            empleados.setFecha_registro(rs.getString("fecha_registro"));
            return true;
        }
    } catch (Exception e) {
        System.out.println("Error al buscar empleado por ID: " + e.getMessage());
    } finally {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar conexion: " + e.getMessage());
        }
    }
    return false;
}

    @Override
    public boolean agregarEmpleados(empleados empleados) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "INSERT INTO empleados(nombre, apellidos, fecha_nacimiento, genero, telefono, email, direccion, fecha_contratacion, cargo, salario, horario_trabajo, estado, fecha_registro) "
            + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, empleados.getNombre());
            ps.setString(2, empleados.getApellidos());
            ps.setString(3, empleados.getFecha_nacimiento());
            ps.setString(4, empleados.getGenero());
            ps.setString(5, empleados.getTelefono());
            ps.setString(6, empleados.getEmail());
            ps.setString(7, empleados.getDireccion());
            ps.setString(8, empleados.getFecha_contratacion());
            ps.setString(9, empleados.getCargo());
            ps.setDouble(10, empleados.getSalario());
            ps.setString(11, empleados.getHorario_trabajo());
            ps.setString(12, empleados.getEstado());
            ps.setString(13, empleados.getFecha_registro());
            ps.execute();
            return true;

        } catch (Exception e){
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }
        finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar conexion:" + e.getMessage());
            }
        }
        return false;
    }



    @Override
    public boolean modificarEmpleado(empleados empleados) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "UPDATE empleados SET nombre = ?, apellidos = ?, fecha_nacimiento = ?, genero = ?, telefono = ?, email = ?, direccion = ?, fecha_contratacion = ?, cargo = ?, salario = ?, horario_trabajo = ?, estado = ?, fecha_registro = ? WHERE id_empleado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, empleados.getNombre());
            ps.setString(2, empleados.getApellidos());
            ps.setString(3, empleados.getFecha_nacimiento());
            ps.setString(4, empleados.getGenero());
            ps.setString(5, empleados.getTelefono());
            ps.setString(6, empleados.getEmail());
            ps.setString(7, empleados.getDireccion());
            ps.setString(8, empleados.getFecha_contratacion());
            ps.setString(9, empleados.getCargo());
            ps.setDouble(10, empleados.getSalario());
            ps.setString(11, empleados.getHorario_trabajo());
            ps.setString(12, empleados.getEstado());
            ps.setString(13, empleados.getFecha_registro());
            ps.setInt(14, empleados.getId_empleado());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Error al modificar empleado: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public boolean eliminarEmpleado(empleados empleados) {
        PreparedStatement ps;
        Connection con = getConexion();
        String sql = "DELETE FROM empleados WHERE id_empleado = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empleados.getId_empleado());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexion: " + e.getMessage());
            }
        }
        return false;
    }




    public static void main(String[] args) {



        // Buscar por id

//        var empleado = new empleados(3);
//        System.out.println("empleado antes de la busqueda: " + empleado);
//        var empleadosDAOInstance = new empleadosDAO();
//        var encontrado = empleadosDAOInstance.buscarEmpleadoPorId(empleado);
//        if(encontrado)
//            System.out.println("empleado encontrado: " + empleado);
//        else
//            System.out.println("No se encontro empleado: " + empleado.getId_empleado());


        // Agregar empleado
//        var nuevoEmpleados = new empleados("Carlos", "Botero López", "1990-04-16", "Masculino", "3120921190", "carlos.lopez@gmail.com", "carrera 10 #38-11, Bogotá, Colombia", "2019-03-02", "Mensajero Repartidor", 1300000.00, "02:00 PM - 10:00 PM", "Activo", "2024-12-17");
//        var agragado = empleadosDAOInstance.agregarEmpleados(nuevoEmpleados);
//
//        if (agragado) {
//            System.out.println("Empleado agregado correctamente.");
//        } else {
//            System.out.println("Error al agregar el empleado.");
//        }


        // Modificar empleado
//        var modificarempleado = new empleados(5, "Lorena", "Torres Marín", "1998-10-23", "Femenino", "3159976740", "marínhermosa.321@hotmail.com", "Carrera 80  #36-17, Soacha, Colombia", "2023-08-11", "Cajera",	1600000.00,	"6:00 PM - 14:00 PM", "Activo",	"2024-12-14");


        // Eliminar empleadovar empleadosDAOInstance = new empleadosDAO();boolean eliminado = empleadosDAOInstance.eliminarEmpleado(empleadoEliminar);boolean eliminado = empleadosDAOInstance.eliminarEmpleado(empleadoEliminar);boolean eliminado = empleadosDAOInstance.eliminarEmpleado(empleadoEliminar);var empleadosDAOInstance = new empleadosDAO();
        var empleadoEliminar = new empleados(2);
        var empleadosDAOInstance = new empleadosDAO();
        boolean eliminado = empleadosDAOInstance.eliminarEmpleado(empleadoEliminar);
        if (eliminado) {
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("Error al eliminar el empleado.");
        }


        // Listar empleados

        System.out.println("*** Listar empleados ***");
        IempleadosDAO empleadosDAO = new empleadosDAO();
        var empleados = empleadosDAO.listarempleados();
        empleados.forEach(System.out::println);






    }
}

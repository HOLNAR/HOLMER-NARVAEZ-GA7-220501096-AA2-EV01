package ordenatupan.datos;


import ordenatupan.dominio.empleados;
import java.util.List;

public interface IempleadosDAO {
    List<empleados> listarempleados();
    boolean buscarEmpleadoPorId(empleados empleados);
    boolean agregarEmpleados(empleados empleados);
    boolean modificarEmpleado(empleados empleados);
    boolean eliminarEmpleado(empleados empleados);

}

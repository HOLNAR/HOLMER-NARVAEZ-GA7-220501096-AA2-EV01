package ordenatupan.dominio;

import java.util.Objects;

public class empleados {
    private int id_empleado;
    private String nombre;
    private String apellidos;
    private String fecha_nacimiento;
    private String genero;
    private String telefono;
    private String email;
    private String direccion;
    private String fecha_contratacion;
    private String cargo;
    private double salario;
    private String horario_trabajo;
    private String estado;
    private String fecha_registro;

    public empleados() {}

    public empleados(int id_empleado){
        this.id_empleado = id_empleado;
    }

    public empleados(String nombre, String apellidos, String fecha_nacimiento, String genero, String telefono, String email, String direccion, String fecha_contratacion, String cargo, double salario, String horario_trabajo, String estado, String fecha_registro) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.genero = genero;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fecha_contratacion = fecha_contratacion;
        this.cargo = cargo;
        this.salario = salario;
        this.horario_trabajo = horario_trabajo;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
    }

    public empleados(int id_empleado, String nombre, String apellidos, String fecha_nacimiento, String genero, String telefono, String email, String direccion, String fecha_contratacion, String cargo, double salario, String horario_trabajo, String estado, String fecha_registro) {
        this(nombre, apellidos, fecha_nacimiento, genero, telefono, email, direccion, fecha_contratacion, cargo, salario, horario_trabajo, estado, fecha_registro);
        this.id_empleado = id_empleado;

    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(String fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getHorario_trabajo() {
        return horario_trabajo;
    }

    public void setHorario_trabajo(String horario_trabajo) {
        this.horario_trabajo = horario_trabajo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }


    @Override
    public String toString() {
        return "empleados{" +
                "id_empleado=" + id_empleado +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", genero='" + genero + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fecha_contratacion='" + fecha_contratacion + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", horario_trabajo='" + horario_trabajo + '\'' +
                ", estado='" + estado + '\'' +
                ", fecha_registro='" + fecha_registro + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        empleados empleados = (empleados) o;
        return id_empleado == empleados.id_empleado && Double.compare(salario, empleados.salario) == 0 && Objects.equals(nombre, empleados.nombre) && Objects.equals(apellidos, empleados.apellidos) && Objects.equals(fecha_nacimiento, empleados.fecha_nacimiento) && Objects.equals(genero, empleados.genero) && Objects.equals(telefono, empleados.telefono) && Objects.equals(email, empleados.email) && Objects.equals(direccion, empleados.direccion) && Objects.equals(fecha_contratacion, empleados.fecha_contratacion) && Objects.equals(cargo, empleados.cargo) && Objects.equals(horario_trabajo, empleados.horario_trabajo) && Objects.equals(estado, empleados.estado) && Objects.equals(fecha_registro, empleados.fecha_registro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_empleado, nombre, apellidos, fecha_nacimiento, genero, telefono, email, direccion, fecha_contratacion, cargo, salario, horario_trabajo, estado, fecha_registro);
    }
}
public class Usuario {
    String nombre;
    String apellidos;
    String email;
    String password;
    String telefono;
    boolean isAdmin = false;

    public boolean signIn() {
        return true;
    };

    public boolean deleteUser(String password) {
        return false;
    }

    public boolean logIn() {
        return true;
    }

    // TODO: Añadir seleccionar sesión
}

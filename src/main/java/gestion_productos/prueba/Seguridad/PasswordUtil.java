package gestion_productos.prueba.Seguridad;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordUtil {
    // Método para hashear una contraseña
    public static String hashPassword(String password) {
        Argon2 argon2 = Argon2Factory.create(); // Crear una instancia de Argon2
        try {
            // Hashear la contraseña con los parámetros recomendados:
            // 2 iteraciones, 64 MiB de memoria, 1 thread
            return argon2.hash(2, 65536, 1, password.toCharArray());
        } finally {
            // Limpia el arreglo de caracteres por seguridad
            argon2.wipeArray(password.toCharArray());
        }
    }

    // Método para verificar una contraseña
    public static boolean verifyPassword(String hashedPassword, String password) {
        Argon2 argon2 = Argon2Factory.create(); // Crear una instancia de Argon2
        return argon2.verify(hashedPassword, password.toCharArray());
    }
}

package org.example;

import org.example.desencripter.AuthApi;
import org.example.encrypter.EncrypterApi;

import java.util.Scanner;

public class Main {

    /*
    Contraseña = mypassword
    Correo = myuser@gmail.com
     */

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("""
                ¿Qué tipo de cifrado desea utilizar?
                1. Cifrado Cesar
                2. Iniciar sesión con cifrado SHA-256
                3. Registrarse MD5
                4. Iniciar sesión con cifrado MD5
                 """);
        var opcion = scanner.nextLine();

        switch (opcion) {
            case "1" -> {
                System.out.println("Ingrese el correo");
                var correo = scanner.nextLine();
                System.out.println("Ingrese la contraseña");
                var password = scanner.nextLine();
                var resultado = EncrypterApi.cesarEncrypter().encrypt(correo, password);
                System.out.println(resultado);
            }
            case "2" -> {
                System.out.println("Ingrese el correo");
                var correo = scanner.nextLine();
                System.out.println("Ingrese la contraseña");
                var password = scanner.nextLine();
                var resultado = EncrypterApi.shaEncrypter().encrypt(correo, password);
                System.out.println(resultado);
            }
            case "3" -> {
                System.out.println("Ingrese el correo");
                var correo = scanner.nextLine();
                System.out.println("Ingrese la contraseña");
                var password = scanner.nextLine();
                EncrypterApi.Md5Encrypter().encrypt(correo, password);
            }

            case "4" -> {
                System.out.println("Ingrese el correo");
                var correo = scanner.nextLine();
                System.out.println("Ingrese la contraseña");
                var password = scanner.nextLine();
                var resultado = AuthApi.loginMd5().auth(correo, password);
                if (resultado) {
                    System.out.println("Credenciales correctas");
                } else {
                    System.out.println("Usuario o contraseña incorrectos");
                }
            }

            default -> System.out.println("Opción no válida");
        }
    }
}
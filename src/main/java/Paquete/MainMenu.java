package Paquete;

import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        boolean exit = false;
        List<Usuario> listaUsuarios = new DAOUsuario().readAllUsuarios();
        List<Ejemplar> listaEjemplares = new DAOEjemplar().readAllEjemplares();
        List<Prestamo> listaPrestamos = new DAOPrestamo().readAllPrestamos();
        List<Libro> listaLibros = new DAOLibro().readAllLibros();

        DAOUsuario daoUsuario = new DAOUsuario();
        DAOEjemplar daoEjemplar = new DAOEjemplar();
        DAOPrestamo daoPrestamo = new DAOPrestamo();
        DAOLibro daoLibro = new DAOLibro();

        while (!exit) {
            System.out.println("Que tipo de usuario es?");
            System.out.println("1. Usuario Administrador");
            System.out.println("2. Usuario Normal");
            System.out.println("3. Salir");
            int option = t.nextInt();
            t.nextLine();
            switch (option) {
                case 1:
                    break;
                case 2:
                    System.out.println("ID de usuario:");
                    int id = t.nextInt();
                    t.nextLine();
                    try{
                        Usuario usuario= daoUsuario.readUsuarioPorID(id);
                        boolean usuarioActivo=true;
                        while (usuarioActivo) {
                            System.out.println("Qué desea ver?");
                            System.out.println("1. Mis datos");
                            System.out.println("2. Datos del préstamo");
                            System.out.println("3. Datos de mis ejemplares");
                            int option2 = t.nextInt();
                            t.nextLine();
                            switch (option2) {
                                case 1:
                                    System.out.println(usuario);
                                    break;
                                case 2:
                                    System.out.println("ID del préstamo que desea consultar:");
                                    int prestamoId = t.nextInt();
                                    t.nextLine();
                                    Prestamo prestamo = daoPrestamo.readPrestamoPorID(prestamoId);
                                        System.out.println(prestamo);
                                    break;
                                case 3:
                                    System.out.println("Id del ejemplar que desea consultar");
                                    int idEjemplar = t.nextInt();
                                    t.nextLine();
                                    Ejemplar ejemplar = daoEjemplar.readEjemplarPorID(idEjemplar);
                                    System.out.println(ejemplar);
                                    break;
                            }
                        }
                    } catch (NoResultException e){
                        System.out.println("Usuario no encontrado");
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}

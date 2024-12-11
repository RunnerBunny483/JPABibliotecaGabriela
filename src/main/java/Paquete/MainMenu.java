package Paquete;

import Paquete.Clases.Ejemplar;
import Paquete.Clases.Libro;
import Paquete.Clases.Prestamo;
import Paquete.Clases.Usuario;
import Paquete.DAOS.DAOEjemplar;
import Paquete.DAOS.DAOLibro;
import Paquete.DAOS.DAOPrestamo;
import Paquete.DAOS.DAOUsuario;
import jakarta.persistence.NoResultException;

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
                    boolean administadorActivo=true;
                    while (administadorActivo) {
                        System.out.println("Que desea gestionar?");
                        System.out.println("1. Gestionar usuarios");
                        System.out.println("2. Gestionar libros");
                        System.out.println("3. Gestionar ejemplares");
                        System.out.println("4. Gestionar prestamos");
                        System.out.println("5. Salir");
                        int option3 = t.nextInt();
                        t.nextLine();
                        switch (option3) {
                            case 1:
                                boolean gestionUsuario=true;
                                while (gestionUsuario) {
                                    System.out.println("Que desea hacer?");
                                    System.out.println("1. Ingresar usuario");
                                    System.out.println("2. Buscar usuario por Id");
                                    System.out.println("3. Actualizar usuario");
                                    System.out.println("4. Eliminar usuario");
                                    System.out.println("5. Salir");
                                    int opcionUsuario = t.nextInt();
                                    t.nextLine();
                                    switch (opcionUsuario) {
                                        case 1:
                                            break;
                                        case 2:
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            gestionUsuario=false;
                                            break;
                                        default:
                                            System.out.println("Opcion no valida");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                boolean gestionLibro=true;
                                while (gestionLibro) {
                                    System.out.println("Que desea hacer?");
                                    System.out.println("1. Ingresar libro");
                                    System.out.println("2. Buscar libro por Id");
                                    System.out.println("3. Actualizar libro");
                                    System.out.println("4. Eliminar libro");
                                    System.out.println("5. Salir");
                                    int opcionLibro = t.nextInt();
                                    t.nextLine();
                                    switch (opcionLibro) {
                                        case 1:
                                            break;
                                        case 2:
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            gestionLibro=false;
                                            break;
                                        default:
                                            System.out.println("Opcion no valida");
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                boolean gestionEjemplar=true;
                                while (gestionEjemplar) {
                                    System.out.println("Que desea hacer?");
                                    System.out.println("1. Ingresar usuario");
                                    System.out.println("2. Buscar usuario por Id");
                                    System.out.println("3. Actualizar usuario");
                                    System.out.println("4. Eliminar usuario");
                                    System.out.println("5. Salir");
                                    int opcionEjemplar = t.nextInt();
                                    t.nextLine();
                                    switch (opcionEjemplar) {
                                        case 1:
                                            break;
                                        case 2:
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            gestionEjemplar=false;
                                            break;
                                        default:
                                            System.out.println("Opcion no valida");
                                            break;
                                    }
                                }
                                break;
                            case 4:
                                boolean gestionPrestamo=true;
                                while (gestionPrestamo) {
                                    System.out.println("Que desea hacer?");
                                    System.out.println("1. Ingresar prestamo");
                                    System.out.println("2. Buscar prestamo por Id");
                                    System.out.println("3. Actualizar prestamo");
                                    System.out.println("4. Eliminar prestamo");
                                    System.out.println("5. Salir");
                                    int opcionPrestamo = t.nextInt();
                                    t.nextLine();
                                    switch (opcionPrestamo) {
                                        case 1:
                                            break;
                                        case 2:
                                            break;
                                        case 3:
                                            break;
                                        case 4:
                                            break;
                                        case 5:
                                            gestionPrestamo=false;
                                            break;
                                        default:
                                            System.out.println("Opcion no valida");
                                            break;
                                    }
                                }
                                break;
                            case 5:
                                administadorActivo=false;
                                break;
                            default:
                                System.out.println("Opcion no valida");
                                break;
                        }
                    }
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
                            System.out.println("4. Salir");
                            int option2 = t.nextInt();
                            t.nextLine();
                            switch (option2) {
                                case 1:
                                    System.out.println(usuario);
                                    break;
                                case 2:
                                    List<Prestamo> prestamos = daoPrestamo.readPrestamosPorUsuarioId(usuario.getId());
                                    if (prestamos.isEmpty()) {
                                        System.out.println("No tienes préstamos.");
                                    } else {
                                        System.out.println("Información sobre préstamos:");
                                        for (Prestamo prestamo : prestamos) {
                                            System.out.println(prestamos);
                                        }
                                    };
                                    break;
                                case 3:
                                    List<Ejemplar> ejemplares = daoEjemplar.readEjemplaresPorUsuarioId(usuario.getId());
                                    if (ejemplares.isEmpty()) {
                                        System.out.println("No tienes ejemplares prestados.");
                                    } else {
                                        System.out.println("Ejemplares prestados:");
                                        for (Ejemplar ejemplar : ejemplares) {
                                            System.out.println(ejemplar);
                                        }
                                    }
                                    break;
                                case 4:
                                    System.out.println("Saliendo...");
                                    usuarioActivo=false;
                                    break;
                                default:
                                    System.out.println("Opcion no valida.");
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

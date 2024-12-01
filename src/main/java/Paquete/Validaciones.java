package Paquete;

import java.time.LocalDate;
import java.util.List;

public class Validaciones {
    //QUE LA FECHA DE DEVOLUCIÓN DE UN PRESTAMO SEA SIEMPRE 15 DÍAS DESPUES
    public static LocalDate calcularFechaDevolucion(LocalDate fechaInicio){
        return fechaInicio.plusDays(15);
    }

    //Que el estado penalizado de un usuario pase a estar activo con una fecha de 15 días de penalización desde
    //que devuelve el libro y no pueda hacer más préstamos hasta esa fecha
    public static void calcularFechaPenalizacion(Usuario usuario, LocalDate fechaDevolucionReal){
    usuario.setPenalizacionHasta(fechaDevolucionReal.plusDays(15));
    }

    //Saber si el usuario está penalizado
    public static boolean isPenalizado(Usuario usuario){
        //Si la penalización NO es null o la fecha de penalizadoHasta es menos de los 15 días de penalización...
        //...entonces isPenalizado es true
        return usuario.getPenalizacionHasta()!=null && LocalDate.now().isBefore(usuario.getPenalizacionHasta());
    }

    //Si está penalizado no puede recibir más préstamos
    public static boolean puedeMásPrestamos (Usuario usuario){
        if (isPenalizado(usuario)){//Si el usuario está con penalizado a true
            System.out.println("El usuario no puede recibir más préstamos hasta "+ usuario.getPenalizacionHasta());
            return false;
        }
        return true;
    }

    //Validación del ISBN13
    public static boolean ISBN13Valido(String ISBN){
        //Que la longitud sea 13 y que solo sean números
        final String ISBNPatron ="^\\d{13}$";
        if (!ISBN.matches(ISBNPatron)){
            return false;
        }
        //Validar el dígito de control
        int suma =0;
        //Recorrer los primeros 12 números
        for (int i = 0; i < 12; i++){
            //transformar el string a dígito por cada posición
            int digito = Character.getNumericValue(ISBN.charAt(i));
            if (i%2==0){
                //los dígitos de las posiciones impares se suman
                suma += digito;
            }else{
                //Los dígitos de las posiciones pares se multiplican por 3
                suma += digito*3;
            }
        }
        //Obtener el último dígito que es el de control
        int digitoControl= Character.getNumericValue(ISBN.charAt(12));
        //Calcular el dígito de control
        int caluclarDigitoControl = (10-(suma % 10))%10;

        //Comparar el dígito de control calculado con el puesto
        return caluclarDigitoControl == digitoControl;
    }
    //Validación del DNI
    //Contar stock disponible contando estado disponible
    public static int calcularStockDisponible(List<Ejemplar> listaEjemplares){
        int contadorDisponibles=0;
        //Recorres la lista de ejemplares
        for (Ejemplar ejemplar: listaEjemplares){
            //Si el estado es igual al estado enum disponible...
            if(ejemplar.getEstado()==Ejemplar.EstadoEjemplar.Disponible){
                //...Aumenta el contador
                contadorDisponibles++;
            }
        }
        return contadorDisponibles;
    }

}

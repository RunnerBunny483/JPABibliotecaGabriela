package Paquete;

import jakarta.persistence.*;

import java.util.List;

public class DAOPrestamo {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Paquete");

    //Obtener todos los prestamos
    public List<Prestamo> readAllPrestamos() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Prestamo p");
            List<Prestamo> listaPrestamos = q.getResultList();
            return listaPrestamos;
        } catch (NoResultException e) {
            System.out.println("No hay Prestamos registrados");
            throw new NoResultException("No hay Prestamos en la base de datos");
        } finally {
            em.close();
        }
    }
    //Obtener un prestamo por id
    public Prestamo readPrestamoPorID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT p FROM Prestamo p WHERE p.id = :id");
            q.setParameter("id", id);
            return (Prestamo) q.getSingleResult();
        }catch (NoResultException e) {
            System.out.println("Prestamo no encontrado");
            throw new NoResultException("No existe un Prestamo con el id " + id);
        }finally {
            em.close();
        }
    }
    //Crear
    public void insertPrestamo(Prestamo prestamo) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       em.persist(prestamo);
       em.getTransaction().commit();
       em.close();
    }
    //Actualizar
    public void updatePrestamo(Prestamo prestamo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(prestamo);
        em.getTransaction().commit();
        em.close();
    }
    //Borrar
    public void deletePrestamo(Prestamo prestamo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(prestamo);
        em.getTransaction().commit();
        em.close();
    }
    //Cerrar
    public static void cerrarEMF(){
        if(emf != null && emf.isOpen()){
            emf.close();
        }
    }
}

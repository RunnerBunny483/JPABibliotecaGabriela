package Paquete;

import jakarta.persistence.*;

import java.util.List;

public class DAOLibro {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Paquete");

    //Obtener todos los libros
    public List<Libro> readAllLibros() {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT l FROM Libro l");
            List<Libro> listaLibros = q.getResultList();
            return listaLibros;
        } catch (NoResultException e) {
            System.out.println("No hay Libros registrados");
            throw new NoResultException("No hay libros en la base de datos");
        } finally {
            em.close();
        }
    }
    //Obtener un libros por id
    public Libro readLibroPorID(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Query q = em.createQuery("SELECT l FROM Libro l WHERE l.id = :id");
            q.setParameter("id", id);
            return (Libro) q.getSingleResult();
        }catch (NoResultException e) {
            System.out.println("Libro no encontrado");
            throw new NoResultException("No existe un libro con el id " + id);
        }finally {
            em.close();
        }
    }
    //Crear
    public void insertLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
    }
    //Actualizar
    public void updateLibro(Libro libro) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        em.close();
    }
    //Borrar
    public void deleteLibro(int id) {
        EntityManager em = emf.createEntityManager();
        Libro libro = em.find(Libro.class, id);
        em.getTransaction().begin();
        em.remove(libro);
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

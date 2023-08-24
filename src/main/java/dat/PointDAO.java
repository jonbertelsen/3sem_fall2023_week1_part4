package dat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PointDAO
{
    private static PointDAO pointDAO = null;
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    private PointDAO()
    {

    }

    public static PointDAO getInstance()
    {
        if (pointDAO == null)
        {
            pointDAO = new PointDAO();
        }
        return pointDAO;
    }

    public void generatePoints()
    {
        try(EntityManager em = emf.createEntityManager())
        {
            // Store 1000 Point objects in the database:
            em.getTransaction().begin();
            for (int i = 0; i < 1000; i++)
            {
                Point p = new Point(i, i);
                em.persist(p);
            }
            em.getTransaction().commit();
        }
    }

    public long getPointCount()
    {
        // Find the number of Point objects in the database:
        try(EntityManager em = emf.createEntityManager())
        {
            Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
            return (long) q1.getSingleResult();
        }
    }

    public double getPointAVG()
    {
        // Find the average X value:
        try(EntityManager em = emf.createEntityManager())
        {
            Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
            return (double) q2.getSingleResult();
        }
    }

    public List<Point> getAllPoints()
    {
        // Retrieve all the Point objects from the database:
        try(EntityManager em = emf.createEntityManager())
        {
        TypedQuery<Point> query = em.createQuery("SELECT p FROM Point p", Point.class);
        return query.getResultList();
        }
    }







}

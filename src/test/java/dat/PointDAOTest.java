package dat;

import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PointDAOTest
{
    private static PointDAO pointDao = PointDAO.getInstance();

    @BeforeAll
    static void setUp()
    {
        pointDao.generatePoints();
    }

    @Test
    void getInstance()
    {
        PointDAO instance1 = PointDAO.getInstance();
        assertNotNull(instance1);
        assertEquals(instance1, pointDao);
    }

    @Test
    void getPointCount()
    {
        long expected = 1000;
        long actual = pointDao.getPointCount();
        assertEquals(expected, actual);
    }

    @Test
    void getPointAVG()
    {
        double expected = 499.5;
        double actual = pointDao.getPointAVG();
        assertEquals(expected, actual);
    }

    @Test
    void getAllPoints()
    {
        List<Point> pointList = pointDao.getAllPoints();
        assertEquals(1000, pointList.size());
    }
}
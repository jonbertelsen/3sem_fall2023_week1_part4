package dat;

public class Main
{
    public static void main(String[] args)
    {
        PointDAO pointDAO = PointDAO.getInstance();


        System.out.println("Hello point world!");

        pointDAO.generatePoints();
        System.out.println("Count: " + pointDAO.getPointCount());
        System.out.println("Average: " + pointDAO.getPointAVG());

        for (Point p : pointDAO.getAllPoints())
        {
            System.out.println(p.toString());
        }
    }
}
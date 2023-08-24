package dat;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Point
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int x;
    private int y;

    @PrePersist
    public void logEntity()
    {
        if (x % 20 == 0)
            System.out.println("Tallet " + x + " er deleligt med 20! Bum!" );
    }

    public Point(int x, int y)
    {
        setX(x);
        setY(y);
    }
}


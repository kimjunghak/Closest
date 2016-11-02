import java.util.Comparator;

/**
 * Created by KJH on 2016-11-02.
 */
public class Point_Compare_X implements Comparator<Point>{

    @Override
    public int compare(Point o1, Point o2) {
        if(o1.x > o2.x)
            return 1;
        else
            return -1;
    }
}

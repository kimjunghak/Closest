import java.util.Comparator;

/**
 * Created by KJH on 2016-11-02.
 */
public class Point_Compare_Y implements Comparator<Point>{

    @Override
    public int compare(Point o1, Point o2) {
        if(o1.y > o2.y)
            return 1;
        else
            return -1;
    }
}

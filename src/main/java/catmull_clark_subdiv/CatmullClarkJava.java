package catmull_clark_subdiv;

import java.util.List;
import java.util.Objects;

/**
 * Written by Milcho on 4/10/2019.
 */
public class CatmullClarkJava {

    public static class Point {
        final float x, y, z;

        public Point(float x, float y, float z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) {
                return false;
            }
            Point other = (Point) obj;
            return x == other.x
                    && y == other.y
                    && z == other.z;
        }
    }

    public static class Face {
        final Point a, b, c;

        public Face(Point a, Point b, Point c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Face)) {
                return false;
            }
            Face other = (Face) obj;
            return a != null && a.equals(other.a)
                    && b!= null && b.equals(other.b)
                    && c != null && c.equals(other.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    List<Face> CCSubdivide(List<Face> faces) {


        return null;
    }


}

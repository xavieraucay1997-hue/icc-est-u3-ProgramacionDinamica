import java.util.Objects;

public class Celda {
    private int x;
    private int y;

    public Celda(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters
    public int getX() { 
        return x; 
    }

    public int getY() { 
        return y; 
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof Celda)) return false;
        Celda celda = (Celda) o;
        return x == celda.x && y == celda.y;
    }


    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Celda [ x =" + x + ", y = " + y + " ]";
    }


}
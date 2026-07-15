import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Maze {
    private int[][] maze;

    public Maze() {
        this.maze = new int[][]{
            {0, 0, 0, 1, 0, 0},
            {1, 1, 0, 1, 0, 1},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 0},
        };

        Celda inicio = new Celda(0, 0); 
        Celda fin = new Celda(5, 5); 
                            

        List<Celda> camino = new ArrayList<>(); 

        Set<Celda> visitados = new HashSet<>(); 

        boolean encontrado = findPath(maze, inicio, fin, camino, visitados);

        if (encontrado) {
            System.out.println("\nCamino encontrado:");
            printMazeWithPath(camino);

            System.out.println("\nCeldas del camino:");
            System.out.println(camino);
        } else {
            System.out.println("\nNo existe un camino");
        }
    }

    private boolean findPath(int[][] maze, Celda actual, Celda fin, List<Celda> camino, Set<Celda> visitados) {
        int fila = actual.getX();
        int columna = actual.getY(); 
        if (fila < 0 || fila >= maze.length || columna < 0 || columna >= maze[0].length) {
            return false; 
        }

        if (maze[fila][columna] == 1 || visitados.contains(actual)) {
            return false;
        }
        visitados.add(actual);
        camino.add(actual);

        if(actual.equals(fin)){
            return true;
        }
        if (findPath(maze, new Celda(fila, columna + 1), fin, camino, visitados)) {
            return true; 
        }

        if (findPath(maze, new Celda(fila + 1, columna), fin, camino, visitados)) {
            return true;
        }

        if (findPath(maze, new Celda(fila, columna - 1), fin, camino, visitados)) {
            return true;
        }
        if (findPath(maze, new Celda(fila - 1, columna), fin, camino, visitados)) {
            return true;
        }
        camino.remove(camino.size() - 1);
        visitados.remove(actual); 

        return false; 
    }
    private void printMazeWithPath(List<Celda> camino) {
        Set<Celda> caminoSet = new HashSet<>(camino);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                Celda actual = new Celda(i, j);
            
                if (caminoSet.contains(actual)) {
                    System.out.print("*");
                } else if (maze[i][j] == 1) {
                    System.out.print("#");
                } else {
                 
                   System.out.print(". ");
                }

            }
            System.out.println(); 
        }
    }
}
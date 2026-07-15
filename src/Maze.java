import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Maze
 */
public class Maze {
    private int[][] maze;

    public Maze(){
        this.maze=new int[][]{

                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
            

        };
        Celda inicio= new Celda(0,0);
        Celda fin= new Celda(2,0);


        List<Celda> camino=new LinkedList<>();
        Set<Celda> visitados= new HashSet<>();
        
        boolean encontrado= findPath(
            maze,inicio,fin,visitados,camino );
        if(encontrado){
            System.out.println("\n Camino encontrado");
            printMazeWithPath(visitados,camino);
                        System.out.println("\n Celdad de camino");
                        System.out.println(camino);
            
                    }else{
                        System.out.println("\n No existe el camino");
                    }
                }
                private void printMazeWithPath(Set<Celda> visitados,List<Celda> camino) {
                    for(int i=0; i<maze.length;i++){
                        for(int j=0; j<maze.length;j++){
                            Celda actual= new Celda(i,j);
                            if(camino.contains(actual)){
                                System.out.print(" * ");
                                
                            }else if(maze[i][j]==1){
                                System.out.print(" # ");
                            }else{
                                System.out.print(" . ");
                            }
                            
                        }
                        System.out.println();
                        
                    }
                }
        private boolean findPath(int [][] maze, Celda inicio,Celda fin,Set<Celda> visitados,List<Celda> camino){
        int fila=inicio.getX();
        int columna= inicio.getY();
        if(fila<0 || fila>=maze.length|| columna<0 || columna>=maze[0].length){
            return false;
        }
        if(maze[fila][columna]==1){
            return false;
        }
        if(visitados.contains(inicio)){
            return false;
        }
        visitados.add(inicio);
        camino.add(inicio);
        if(inicio.equals(fin)){
            camino.add(inicio);
            return true;
        }
        
        Celda derecha= new Celda(fila, columna+1);
        

        if(findPath(maze, derecha, fin,visitados, camino)){
            return true;
        }
        
        Celda abajo= new Celda(fila+1, columna);
        if(findPath(maze, abajo, fin,visitados, camino)){
            return true;
        }
       

        Celda izquierda=new Celda(fila,columna-1);
        if(findPath(maze, izquierda, fin,visitados, camino)){
            return true;
        }
        
        Celda arriba=new Celda(fila-1, columna);
        if (findPath(maze, arriba, fin,visitados, camino)) {
            return true;
            
        }
 
        camino.remove(camino.size()-1);
        
        return false;

        
        

    }

}
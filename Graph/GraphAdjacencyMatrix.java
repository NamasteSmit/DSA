package Graph;
import java.util.*;
public class GraphAdjacencyMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //take number of vertices and edges as input
        System.out.println("Enter number of vertices");
        int vertex = sc.nextInt();
        System.out.println("Enter number of edges");
        int edges = sc.nextInt();

        //create a 2D array to represent the graph
        int[][] adjMat = new int[vertex][vertex];

        //USE ANY ONE AT A TIME FROM 1,2,3

        //1.undirected - unweighted graph
        // input edges and store them in adjacency matrix
        System.out.println("Enter Edges");
        for(int i = 0 ; i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        }

        //2. undirected - weighted Graph
        System.out.println("Enter edges along with weight");
        for(int i = 0 ; i<edges ;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            adjMat[u][v] = weight;
            adjMat[v][u] = weight;
        }

        //3. directed - weighted graph
        System.out.println("Enter directed edges and weight");
        for(int i = 0 ; i<edges ;i++){
            // U---->V
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            adjMat[u][v] = weight;
        }
   
         sc.close();

        //print the adjacency matrix
        System.out.println("----Adjacency matrix----");
        for(int i = 0 ; i<vertex;i++){
            for(int j = 0 ; j<vertex;j++){
                System.out.print(adjMat[i][j]+" ");
            }
            System.out.println();
        }
    }
}

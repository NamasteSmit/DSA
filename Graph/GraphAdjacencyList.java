package Graph;
import java.util.*;
public class GraphAdjacencyList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Integer>>adjList = new ArrayList<ArrayList<Integer>>();

        System.out.println("Enter number of vertices");
        int vertex = sc.nextInt();
        System.out.println("Enter number of edges");
        int edges = sc.nextInt();

        //intialize the arraylist first :
        for(int i = 0 ; i < vertex ; i++){
            adjList.add(new ArrayList<Integer>());
        }

        //1. undirected - unweighted graph
        
        //input edges and store them in adjacencylist
        System.out.println("Enter edges");
        for(int i = 0 ; i<edges ;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        sc.close();

        //print adjacency list
        System.out.println("---Ajacency list---");
        for(int i = 0 ; i<adjList.size();i++){
           System.out.print(i + " ----> "); 
            for(int j = 0 ; j<adjList.get(i).size();j++){
                System.out.print(adjList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}

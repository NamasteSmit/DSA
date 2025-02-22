package Graph;
import java.util.*;

public class GraphBreadthFirstTraversal {
  
    public static ArrayList<Integer> BfsOnGraph(int Vertex , ArrayList<ArrayList<Integer>>adj){
        //create arraylist to store order (final answer)
            ArrayList<Integer>bfs = new ArrayList<>();

        // we also need a visited array
         boolean [] visitedArray = new boolean[Vertex];
         
         //we also need queue as this is Breadth first search traversal
         Queue <Integer> q = new LinkedList<>();

         q.add(0);
         visitedArray[0] = true;

         while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int neighbourNode : adj.get(node)){
                if(visitedArray[neighbourNode]==false){
                    visitedArray[neighbourNode] = true;
                    q.add(neighbourNode);
                }
            }
         }
 
           return bfs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //lets first create undirected - unweighted Graph through Adjacency List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        System.out.println("Enter number of vertices");
        int vertex = sc.nextInt();
        System.out.println("Enter number of edges");
        int edges = sc.nextInt();

        //intialize your arraylist first
        for(int i = 0 ; i<vertex ; i++){
            adjList.add(new ArrayList<Integer>());
        }

        //input edges and store them in adjlist 
        for(int i = 0 ; i < edges ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //print adjacency list ;
        System.out.println("------Adjaceny List ------");
        for(int i = 0 ; i <adjList.size();i++){
            System.out.print(i + " --->");
            for(int j = 0 ; j < adjList.get(i).size() ; j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> answer = BfsOnGraph(vertex,adjList);
        System.out.println("BFS TRAVERSAL----> " + answer.toString());
    }
} 

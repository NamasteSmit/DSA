package Graph;
import java.util.*;;
class Pair<U,V>{
    public U first;
    public V second;
    public Pair(U firs, V second){
        this.first = firs;
        this.second = second;
    }
}

public class GraphAdjacencyList2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Pair<Integer,Integer>>>adjList = new ArrayList<ArrayList<Pair<Integer,Integer>>>();

        System.out.println("Enter number of vertices");
        int vertex = sc.nextInt();
        System.out.println("Enter number of edges");
        int edges = sc.nextInt();

        //initialize adjacency list with empty list
        for(int i = 0 ; i <vertex ; i++){
            adjList.add(new ArrayList<Pair<Integer,Integer>>());
        }

        //input edges along with weight and store  v-->(u , weight) u--->(v,weight)
        //input edges and store them in adjacency list (undirected graph)
        //u--->(v,weight) v--->(u,weight)
        System.out.println("Enter edges with their weights");
        for(int i = 0 ; i<edges ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();
            adjList.get(u).add(new Pair<Integer,Integer>(v,weight));
            adjList.get(v).add(new Pair<Integer,Integer>(u,weight));
        }


        //print Adjacency List
        System.out.println("----Adjacency List----");
        for(int i = 0 ; i < adjList.size() ; i++){
            System.out.print(i + " ----> ");
            for(int j = 0 ; j < adjList.get(i).size() ; j++){
                Pair<Integer,Integer> p = adjList.get(i).get(j);
                System.out.print("( "+p.first + " " + p.second+ " )");
            }
            System.out.println();
        }
    }
}

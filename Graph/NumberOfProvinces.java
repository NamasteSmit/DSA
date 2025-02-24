package Graph;
import java.util.*;

//https://leetcode.com/problems/number-of-provinces/description/

public class NumberOfProvinces {

    static void dfs(int vertex, ArrayList<ArrayList<Integer>>adjList, boolean visited[]){
        visited[vertex] = true;
        for(int i : adjList.get(vertex)){
            if(visited[i]==false){
                dfs(i, adjList, visited);
            }
        }
    }

    static int noOfProvince(int Vertex , ArrayList<ArrayList<Integer>>adjList){
         
        boolean visited[] = new boolean[Vertex];
        int count = 0;

        for(int i = 0 ; i < Vertex ; i++){
            if(visited[i]==false){
                count++;
                dfs(i,adjList,visited);
            }
        }
        return count;
    }
    public static void main(String[] args){
       Scanner sc = new Scanner(System.in);
       //to create Adjcancy List we need ArrayList of ArrayList
       ArrayList<ArrayList<Integer>>adjList = new ArrayList<ArrayList<Integer>>();

       System.out.println("Enter number of vertex");
       int vertex = sc.nextInt();
       System.out.println("Enter number of edges");
       int edges = sc.nextInt();

       //first lets initialize ArrayList
       for(int i = 0 ; i<vertex;i++){
        adjList.add(new ArrayList<Integer>());
       }

       //input edges and store them in adjList
       System.out.println("Input edges");
       for(int i = 0 ; i < edges ; i++){
        int u = sc.nextInt();
        int v = sc.nextInt();
        adjList.get(u).add(v);
        adjList.get(v).add(u);
       }
       sc.close();

       //print out adjList : 
       System.out.println("------Adjacency List  Graph-----");
       for(int i = 0 ; i<adjList.size() ; i++){
           System.out.print(i + " ----> ");
           for(int j = 0 ; j<adjList.get(i).size();j++){
             System.out.print(adjList.get(i).get(j) + " ");
           }
           System.out.println();
       }

       int result = noOfProvince(vertex, adjList);
       System.out.println("No ofProvince: " + result);
    }
}

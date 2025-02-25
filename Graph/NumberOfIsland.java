package Graph;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    public int first;
    public int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIsland {
     static void bfs(int row , int col , char[][]grid , int[][]visited){
        Queue<Pair>q = new LinkedList<>();
        int[] delRow = {-1 , 1 , 0 , 0};
        int[] delCol = {0  , 0 , -1 , 1}; 
        int m = grid.length;
        int n = grid[0].length;

        q.add(new Pair(row, col));
        visited[row][col] = 1;
        
        while(!q.isEmpty()){
            int currRow = q.peek().first;
            int currCol = q.peek().second;
            q.remove();
            for(int i = 0 ; i<4 ; i++){
                int newRow = currRow + delRow[i];
                int newCol = currCol + delCol[i];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && visited[newRow][newCol]==0 && grid[newRow][newCol]=='1'){
                    q.add(new Pair(newRow,newCol));
                    visited[newRow][newCol] = 1;  // mark the cell as visited
                }
            }
        }
     }

    public static void main(String[] args){
       char[][] grid = {
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
       };

       int m = grid.length;
       int n = grid[0].length;
       int count = 0;

       int[][] visited = new int[m][n];

       for(int i = 0 ; i<m ; i++){
        for(int j = 0 ; j<n ; j++){
            if(visited[i][j]==0 && grid[i][j]=='1'){
                count++;
                bfs(i,j,grid,visited);
            }
        }
       }

       System.out.println("number of Islands: " + count);
    }
}

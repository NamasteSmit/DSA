package Graph;

import java.util.LinkedList;
import java.util.Queue;

class OrangePair{
    public int first ;
    public int second;
    public int timer;
    public OrangePair(int first, int second, int timer){
        this.first = first;
        this.second = second;
        this.timer = timer;
    }
}

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[] delRow = {-1 , 1 , 0 , 0}; 
        int[] delCol = {0  , 0 , -1  , 1};
        int m = grid.length;
        int n = grid[0].length;
        int Finalcounter = 0;
        int freshOrangeCount = 0;
        Queue<OrangePair>q = new LinkedList<>();

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(grid[i][j]==2){
                    q.add(new OrangePair(i,j,0));
                }else if (grid[i][j]==1){
                    freshOrangeCount++;
                }
            }
        }

        int [][] visited = new int[m][n];

        if(q.isEmpty() && freshOrangeCount==0){
            return;
        }
        if(q.isEmpty() && freshOrangeCount!=0){
            return;
        }

        while(!q.isEmpty()){
            int currRow = q.peek().first;
            int currCol = q.peek().second;
            int currTime = q.peek().timer;
            visited[currRow][currCol] = 2;
            Finalcounter = Math.max(Finalcounter, currTime);
            q.remove();

            for(int i = 0 ; i< 4 ; i++){
                int newRow = currRow + delRow[i];
                int newCol = currCol + delCol[i];
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && grid[newRow][newCol]==1 && visited[newRow][newCol]==0){
                    grid[newRow][newCol] = 2;
                    q.add(new OrangePair(newRow, newCol, currTime + 1));
                    freshOrangeCount--;
                }
            }
        }
       if(freshOrangeCount>0){
          System.out.println(-1);
       }else{
        System.out.println(Finalcounter);
       }

    }
}

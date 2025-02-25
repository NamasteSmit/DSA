package Graph;

import java.util.Arrays;

public class FloodFill {
 

    static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int[][] ans,int[] delRow,int[] delCol) {
             
        ans[sr][sc] = newColor;
        int m = image.length;
        int n = image[0].length;

        for(int i = 0 ; i<4 ; i++){
            int newRow = sr + delRow[i];
            int newCol = sc + delCol[i];

            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && image[newRow][newCol]==oldColor && ans[newRow][newCol]!=newColor){
                dfs(image, newRow, newCol, newColor, oldColor, ans, delRow, delCol);   
            }
        }
     }

    public static void main(String[] args) {
        
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[] delRow = {-1 , 1 , 0 , 0};
        int[] delCol = {0  , 0 , -1  , 1};
        int sr = 1;
        int sc = 1;
        int color = 2;

        int initialColor = image[sr][sc];
        int [][] ans = image;
        dfs(image , sr , sc , color , initialColor , ans,delRow,delCol);

        for(int[] i : ans){
            System.out.println(Arrays.toString(i));
        }
    }
}

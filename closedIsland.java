//Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
//Return the number of closed islands.
//Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
//Output: 2
//Explanation: 
//Islands in gray are closed because they are completely surrounded by water (group of 1s).

class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 0){
                    traverse(i, j, n, m,grid);
                }
            }
        }
        int count =0;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<m-1;j++){
                if(grid[i][j] == 0){
                    traverse(i,j,n,m, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void traverse(int i, int j, int n,int m, int[][] grid){
        if(i<0 || j<0 || i>n-1 || j>m-1){
            return;
        }
        if(grid[i][j] == 1){
            return;
        }
        grid[i][j] =1;
        
        traverse(i-1,j,n,m,grid);
        traverse(i,j-1,n,m,grid);
        traverse(i+1,j,n,m,grid);
        traverse(i,j+1,n,m,grid);

    }
}

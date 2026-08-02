class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1' && visited[i][j]==false){
                    count++;
                    markIsland(i,j,grid,visited);
                }
            }
        }

        return count;
    }

    private void markIsland(int row,int col,char[][] grid,boolean[][] visited){
        if(visited[row][col]==true) return ;
        visited[row][col]=true;

        if(col>0 && grid[row][col-1]=='1'){
            markIsland(row,col-1,grid,visited);
        }

        if(row>0 && grid[row-1][col]=='1'){
            markIsland(row-1,col,grid,visited);
        }

        if(col<grid[0].length-1 && grid[row][col+1]=='1'){
            markIsland(row,col+1,grid,visited);
        }

        if(row<grid.length-1 && grid[row+1][col]=='1'){
            markIsland(row+1,col,grid,visited);
        }

        return ;
    }
}

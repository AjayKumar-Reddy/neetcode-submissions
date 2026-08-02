class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //doing it using BFS as iteration
        // Deque<Pair> queue=new ArrayDeque<>();
        // int area=0;
        // int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid[0].length;j++){
        //         if(grid[i][j]==1){
        //             queue.offer(new Pair(i,j));
        //             grid[i][j]=0;
        //             int count=0;
        //             while(!queue.isEmpty()){
        //                 Pair pos=queue.poll();
        //                 count++;
        //                 for(int[] dir:directions){
        //                     int newRow=pos.row+dir[0];
        //                     int newCol=pos.col+dir[1];

        //                     if(newRow>=0 && 
        //                     newCol>=0 && 
        //                     newRow<grid.length && 
        //                     newCol<grid[0].length && 
        //                     grid[newRow][newCol]==1){
        //                         grid[newRow][newCol]=0;
        //                         queue.offer(new Pair(newRow,newCol));
        //                     }
        //                 }
                        
        //             }
        //             area=Math.max(area,count);
        //         }
        //     }
        // }
        
        // return area;

        //DFS Method
        int area=0;
        int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    grid[i][j]=0;
                    int count=1+dfs(i,j,grid,direction);
                    area=Math.max(area,count);
                }
            }
        }
        return area;
    }

    private int dfs(int row,int col,int[][] grid,int[][] direction){
        

        int count=0;
        for(int[] dir:direction){
            int newRow=row+dir[0];
            int newCol=col+dir[1];

            if(newRow>=0 &&
            newRow<grid.length &&
            newCol>=0 &&
            newCol<grid[0].length &&
            grid[newRow][newCol]==1){
                grid[newRow][newCol]=0;
                count+=1+dfs(newRow,newCol,grid,direction);
            }
        }
        return count;
    }
}

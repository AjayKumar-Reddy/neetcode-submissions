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
        //doing it using bfs as iteration
        Deque<Pair> queue=new ArrayDeque<>();
        int area=0;
        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    queue.offer(new Pair(i,j));
                    grid[i][j]=0;
                    int count=0;
                    while(!queue.isEmpty()){
                        Pair pos=queue.poll();
                        count++;
                        for(int[] dir:directions){
                            int newRow=pos.row+dir[0];
                            int newCol=pos.col+dir[1];

                            if(newRow>=0 && 
                            newCol>=0 && 
                            newRow<grid.length && 
                            newCol<grid[0].length && 
                            grid[newRow][newCol]==1){
                                grid[newRow][newCol]=0;
                                queue.offer(new Pair(newRow,newCol));
                            }
                        }
                        
                    }
                    area=Math.max(area,count);
                }
            }
        }
        
        return area;
    }
}

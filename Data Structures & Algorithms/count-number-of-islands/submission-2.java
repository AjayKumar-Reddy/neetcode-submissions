class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        // boolean[][] visited = new boolean[grid.length][grid[0].length];
        Deque<Pair> queue=new ArrayDeque<>();
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    queue.offer(new Pair(i,j));
                    while(!queue.isEmpty()){
                        Pair pos=queue.poll();
                        int row=pos.row;
                        int col=pos.col;
                        if(col>0 && grid[row][col-1]=='1'){
                            grid[row][col-1]='0';
                            queue.offer(new Pair(row,col-1));
                        }

                        if(row>0 && grid[row-1][col]=='1'){
                            grid[row-1][col]='0';
                            queue.offer(new Pair(row-1,col));
                        }

                        if(col<grid[0].length-1 && grid[row][col+1]=='1'){
                            grid[row][col+1]='0';
                            queue.offer(new Pair(row,col+1));
                        }

                        if(row<grid.length-1 && grid[row+1][col]=='1'){
                            grid[row+1][col]='0';
                            queue.offer(new Pair(row+1,col));
                        }
                    }
                }
            }
        }

        return count;
    }

    private void markIsland(int row,int col,char[][] grid){
        
        grid[row][col]='0';

        if(col>0 && grid[row][col-1]=='1'){
            markIsland(row,col-1,grid);
        }

        if(row>0 && grid[row-1][col]=='1'){
            markIsland(row-1,col,grid);
        }

        if(col<grid[0].length-1 && grid[row][col+1]=='1'){
            markIsland(row,col+1,grid);
        }

        if(row<grid.length-1 && grid[row+1][col]=='1'){
            markIsland(row+1,col,grid);
        }

        return ;
    }
}

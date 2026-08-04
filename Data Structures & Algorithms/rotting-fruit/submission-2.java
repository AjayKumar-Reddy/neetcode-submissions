class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        Deque<Pair> queue=new ArrayDeque<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j));
                } else if(grid[i][j]==1) fresh++;
            }
        } 


        //bfs
        
        int minutes=0;
        int[][] directions={{0,-1},{-1,0},{0,1},{1,0}};
        while(!queue.isEmpty() && fresh>0){
            int len=queue.size();
            minutes++;
            for(int i=0;i<len;i++){
                Pair temp=queue.poll();
                
                for(int[] dir:directions){
                    int newRow=temp.row+dir[0];
                    int newCol=temp.col+dir[1];

                    if(newRow<0 || newCol<0 || newRow==grid.length || newCol==grid[0].length || grid[newRow][newCol]==0 || grid[newRow][newCol]==2){
                        continue;
                    }

                    grid[newRow][newCol]=2;
                    fresh--;
                    queue.offer(new Pair(newRow,newCol));

                }
                

            }
        }

        if(fresh>0) return -1;
        else return minutes;

    }

    
}

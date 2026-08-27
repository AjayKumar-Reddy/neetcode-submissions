class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<Pair> queue=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        bfs(grid,queue);

        


        
    }

    private void bfs(int[][] grid,Deque<Pair> queue) {

        int m = grid.length;
        int n = grid[0].length;

        
        

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        
        

        int level = 0;

        while (!queue.isEmpty()) {
            level++;

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pair cur = queue.poll();

                

                for (int[] d : dir) {

                    int nr = cur.row + d[0];
                    int nc = cur.col + d[1];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }

                    if (grid[nr][nc] == -1|| grid[nr][nc]!=Integer.MAX_VALUE) {
                        continue;
                    }

                    
                    grid[nr][nc]=level;
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
    }
}
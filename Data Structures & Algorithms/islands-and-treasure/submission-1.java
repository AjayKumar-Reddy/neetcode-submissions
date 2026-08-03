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


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    bfs(i,j,grid);
                }
            }
        }

        


        
    }

    private void bfs(int sr, int sc, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Deque<Pair> queue = new ArrayDeque<>();

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        queue.offer(new Pair(sr, sc));
        visited[sr][sc] = true;

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

                    if (grid[nr][nc] == -1 || visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    grid[nr][nc]=Math.min(level,grid[nr][nc]);
                    queue.offer(new Pair(nr, nc));
                }
            }
        }
    }
}
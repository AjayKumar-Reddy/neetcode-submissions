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

        int[][] result = new int[m][n];

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == Integer.MAX_VALUE) {
                    result[i][j] = bfs(i, j, grid);
                }
            }
        }

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = result[i][j];
            }
        }
    }

    private int bfs(int sr, int sc, int[][] grid) {

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

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Pair cur = queue.poll();

                if (grid[cur.row][cur.col] == 0) {
                    return distance;
                }

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
                    queue.offer(new Pair(nr, nc));
                }
            }

            distance++;
        }

        return Integer.MAX_VALUE;
    }
}
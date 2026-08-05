class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] pacific=new int[n][m];
        int[][] atlantic=new int[n][m];

        for(int i=0;i<n;i++){
            dfs(i,0,heights,pacific);
        }

        for(int i=0;i<m;i++){
            dfs(0,i,heights,pacific);
        }

        for(int i=0;i<n;i++){
            dfs(i,m-1,heights,atlantic);
        }

        for(int i=0;i<m;i++){
            dfs(n-1,i,heights,atlantic);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    ans.add(new ArrayList<>(Arrays.asList(i,j)));
                }
            }
        }

        return ans;

    }

    private void dfs(int row,int col,int[][] heights,int[][] visited){
        visited[row][col]=1;

        int[][] directions={{0,-1},{-1,0},{0,1},{1,0}};

        for(int[] dir:directions){
            int newRow=row+dir[0];
            int newCol=col+dir[1];

            if(newRow<0 || newCol<0 || newRow>=heights.length || newCol>=heights[0].length || heights[row][col]>heights[newRow][newCol] || visited[newRow][newCol]==1){
                continue;
            }
            
            dfs(newRow,newCol,heights,visited);

        }
    }
}

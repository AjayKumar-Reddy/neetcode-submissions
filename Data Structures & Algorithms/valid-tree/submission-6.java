class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        
        if (edges.length != n - 1) {
            return false;
        }

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] arr:edges){
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }
        int[] visited=new int[n];
        dfs(0,list,visited);

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                return false;
            }
        }
        return true;
    }

    private void dfs(int n,List<List<Integer>> list,int[] visited){
        if(visited[n]==1) return ;
        visited[n]=1;

        for(int val:list.get(n)){ 
            if(visited[val]==0){
                dfs(val,list,visited);
            }
        }
        
    }
}

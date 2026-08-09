class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] arr:edges){
            list.get(arr[0]).add(arr[1]);
            list.get(arr[1]).add(arr[0]);
        }

        int[] visited=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,list,visited);
                count++;
            }
            

        }
        return count;

        
    }

    private void dfs(int n,List<List<Integer>> list,int[] visited){

        visited[n]=1;

        for(int val:list.get(n)){
            if(visited[val]==0){
                dfs(val,list,visited);
            }
        }

    }
}

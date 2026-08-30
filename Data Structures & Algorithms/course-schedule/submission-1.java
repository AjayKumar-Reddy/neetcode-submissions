class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] visited=new int[numCourses];
        //detect cycle using dfs
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(!dfs(i,list,visited)){
                    return false;
                }
            }
            
        }
        return true;
    }

    private boolean dfs(int node,List<List<Integer>> list,int[] visited){
        visited[node]=1;

        
        for(int val:list.get(node)){
            if(visited[val]==1){
                return false;
            } 
            if(visited[val]==0){
                if(!dfs(val,list,visited)){
                    return false;
                }
            }
        }
        visited[node]=2;
        return true;
    }
}

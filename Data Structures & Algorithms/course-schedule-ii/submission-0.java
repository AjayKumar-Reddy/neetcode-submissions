class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int[] arr:prerequisites){
            list.get(arr[1]).add(arr[0]);
        }
        
        int[] visited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(isCycle(i,list,visited)) return new int[0];
        }
        Arrays.fill(visited,0);
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            topologicalSort(i,list,visited,stack);
        }
        int[] ans=new int[stack.size()];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++]=stack.poll();
            
        }

        return ans;
    }

    private void topologicalSort(int node,List<List<Integer>> list,int[] visited,Deque<Integer> stack){
        visited[node]=1;

        for(int val:list.get(node)){
            if(visited[val]==0){
                topologicalSort(val,list,visited,stack);
            }
        }
        stack.offerFirst(node);
    }

    private boolean isCycle(int node,List<List<Integer>> list,int[] visited){
        visited[node]=1;

        for(int val:list.get(node)){
            if(visited[val]==1) return true;
            else if(visited[val]==0){
                if(isCycle(val,list,visited)) return true;
            }
        }

        visited[node]=2;
        return false;
    }
}

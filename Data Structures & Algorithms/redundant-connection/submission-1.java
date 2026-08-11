class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent=new int[edges.length+1];
        int[] rank=new int[edges.length+1];
        for(int i=1;i<edges.length+1;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int[] ans=new int[2];
        for(int[] ar:edges){
            if(union(ar[0],ar[1],parent,rank)){
                ans=ar;
            }
        }
        return ans;
    }

    private boolean union(int a,int b,int[] parent,int[] rank){
        int parA=find(a,parent);
        int parB=find(b,parent);
        if(parA==parB) return true;
        if(rank[parA]==rank[parB]){
            parent[parB]=parA;
            rank[parA]++;
        } else if(rank[parA]>rank[parB]){
            parent[parB]=parA;
        } else {
            parent[parA]=parB;
        }

        return false;
    }

    private int find(int x,int[] parent){
        if(parent[x]==x) return x;

        return find(parent[x],parent);
    }
}

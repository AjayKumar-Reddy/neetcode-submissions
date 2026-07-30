class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        combinations(1,n,k,new ArrayList<>(),ans);
        return ans;
    }

    private void combinations(int num,int n,int k,List<Integer> temp,List<List<Integer>> ans){
        
        if(temp.size()==k){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        for (int i = num; i <= n - (k - temp.size()) + 1; i++){
            temp.add(i);
            combinations(i+1,n,k,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,new ArrayList<>(),ans);
        return ans;
    }

    private void helper(int[] nums,int indx,List<Integer> sub,List<List<Integer>> ans){
        if(indx==nums.length){
            ans.add(new ArrayList<>(sub));
            return ;
        }

        sub.add(nums[indx]);
        helper(nums,indx+1,sub,ans);
        sub.remove(sub.size()-1);
        helper(nums,indx+1,sub,ans);


    }
}

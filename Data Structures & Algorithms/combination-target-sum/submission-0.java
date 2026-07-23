class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combination(nums,0,0,target,new ArrayList<>(),ans);
        return ans;
    }

    private void combination(int[] nums,int sum,int indx,int target,List<Integer> temp,List<List<Integer>> ans){
        if(indx==nums.length) return;
        if(sum>target) return;
        if(sum==target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[indx]);
        combination(nums,sum+nums[indx],indx,target,temp,ans);
        temp.remove(temp.size()-1);
        combination(nums,sum,indx+1,target,temp,ans);
    }
}

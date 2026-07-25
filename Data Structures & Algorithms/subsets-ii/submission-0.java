class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums,0,new ArrayList<>(),ans);
        return ans;
    }
    private void subsets(int[] nums,int indx,List<Integer> temp,List<List<Integer>> ans){
        if(indx==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[indx]);
        subsets(nums,indx+1,temp,ans);
        temp.remove(temp.size()-1);

        int i=indx+1;
        while(i<nums.length && nums[i]==nums[i-1]){
            i++;
        }
        subsets(nums,i,temp,ans);
    }
}

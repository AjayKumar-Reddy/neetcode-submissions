class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        permutations(nums,0,ans);
        return ans;

    }
    private void permutations(int[] nums,int indx,List<List<Integer>> ans){
        if(indx==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int val:nums){
                temp.add(val);
            }
            ans.add(new ArrayList<>(temp));
        }

        for(int i=indx;i<nums.length;i++){
            swap(i,indx,nums);
            permutations(nums,indx+1,ans);
            swap(i,indx,nums);
        }
    }

    private void swap(int n1,int n2,int[] nums){
        int temp=nums[n1];
        nums[n1]=nums[n2];
        nums[n2]=temp;

    }
}

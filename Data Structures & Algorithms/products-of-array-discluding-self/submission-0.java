class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod=1;
        int count=0;
        for(int val:nums){
            if(val==0){
                count++;
                continue;
            }
            prod*=val;
        }
        if(count>1){
            int[] temp=new int[nums.length];
            return temp;
        }
        int[] ans=new int[nums.length];
        if(count==1){
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0){
                    ans[i]=prod;
                    return ans;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=prod/nums[i];
            
        }
        return ans;
    }
}  

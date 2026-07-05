class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        int i=0;
        int j=1;
        set.add(nums[i]);
        while(j<nums.length){
            if(set.contains(nums[j])){
                return true;
            }
            if((j-i+1)>k){
                set.remove(nums[i]);
                i++;
            }
            set.add(nums[j]);
            j++;
        }
        return false;
    }
}
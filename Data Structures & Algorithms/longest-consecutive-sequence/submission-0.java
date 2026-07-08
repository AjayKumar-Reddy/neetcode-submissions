class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        int count=0;
        for(int val:set){
            if(!set.contains(val-1)){
                int len=0;
                while(set.contains(val++)){
                    len++;;
                }
                count=Math.max(count,len);
            }
        }
        return count;
    }
}

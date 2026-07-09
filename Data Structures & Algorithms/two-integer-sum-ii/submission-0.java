class Solution {
    public int[] twoSum(int[] num, int target) {
        int i=0;
        int j=num.length-1;
        while(i<j){
            if(num[i]+num[j]==target){
                return new int[]{i+1,j+1};
            } else if(num[i]+num[j]>target){
                j--;
            } else{
                i++;
            }
        }
        return new int[]{};
    }
}

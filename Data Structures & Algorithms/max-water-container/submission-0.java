class Solution {
    public int maxArea(int[] heights) {
        int i=0;
        int j=heights.length-1;
        int ans=0;
        while(i<j){
            int val=Math.min(heights[i],heights[j]);
            ans=Math.max(ans,val*(j-i));
            if(heights[i]<=heights[j]){
                i++;
            } else{
                j--;
            }
        }
        return ans;
    }
}

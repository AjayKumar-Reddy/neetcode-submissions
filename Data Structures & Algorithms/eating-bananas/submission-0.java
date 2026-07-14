class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int val:piles){
            max=Math.max(max,val);
        }
        int left=1;
        int right=max;
        long rate=right;
        while(left<=right){
            int k=left+(right-left)/2;
            long count=0;
            for(int pile:piles){
                count+=Math.ceil((double)pile/k);
            }
            if(count<=h){
                rate=k;
                right=k-1;
            } else {
                left=k+1;
            }
        }
        return (int)rate;
    }
}

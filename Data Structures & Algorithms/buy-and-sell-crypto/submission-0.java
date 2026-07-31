class Solution {
    public int maxProfit(int[] prices) {
        int bestBuy=Integer.MAX_VALUE;
        int profit=0;
        for(int val:prices){
            if(bestBuy>val){
                bestBuy=val;
            }
            profit=Math.max(profit,val-bestBuy);
        }
        return profit;
    }
}

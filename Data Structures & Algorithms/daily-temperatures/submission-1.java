class Pair{
    int indx;
    int val;
    Pair(int indx,int val){
        this.indx=indx;
        this.val=val;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> stack=new ArrayDeque<>();
        int n=temperatures.length;
        int[] ans=new int[n];
        for(int i=0;i<temperatures.length;i++){
            while(!stack.isEmpty() && stack.peek().val<temperatures[i]){
                Pair ele=stack.pop();
                ans[ele.indx]=i-ele.indx;
            }
            stack.push(new Pair(i,temperatures[i]));
        }

        return ans;
    }
}

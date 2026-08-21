class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();

        for(String str:tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int ele1=stack.pop();
                int ele2=stack.pop();

                int result=0;
                if(str.equals("+")){
                    result=ele1+ele2;
                } else if(str.equals("-")){
                    result=ele2-ele1;
                } else if(str.equals("*")){
                    result=ele1*ele2;
                } else {
                    result=ele2/ele1;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        Deque<Character> stack2=new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                while(!stack.isEmpty()){
                    char sch=stack.pop();
                    if(sch=='(' && ch==')' || sch=='{' && ch=='}' || sch=='[' && ch==']'){
                        break;
                    } else{
                        stack2.push(sch);

                    }
                }
                if(stack.isEmpty() && !stack2.isEmpty()){
                    return false;
                } else{
                    while(!stack2.isEmpty()){
                        stack.push(stack2.pop());
                    }
                    
                }
            }
        }
        if(stack.isEmpty() && stack2.isEmpty()){
            return true;
        }
        return false;
    }
}

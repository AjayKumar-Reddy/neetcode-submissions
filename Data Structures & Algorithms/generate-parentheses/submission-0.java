class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generate(0,0,n,new StringBuilder(""),ans);
        return ans;
    }

    private void generate(int oCount,int cCount,int n, StringBuilder str,List<String> ans){
        if(oCount==n && cCount==n){
            ans.add(str.toString());
            return;
        }
        
        
        if(oCount<n){
            str.append('(');
            generate(oCount+1,cCount,n,str,ans);
            str.deleteCharAt(str.length()-1);
        } 
        if(cCount<oCount){
            str.append(')');
            generate(oCount,cCount+1,n,str,ans);
            str.deleteCharAt(str.length()-1);
        }
        return ;
    }
}

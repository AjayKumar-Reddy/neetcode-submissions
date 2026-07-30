class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        partition(s,new ArrayList<>(),ans);
        return ans;
    }

    private void partition(String s,List<String> temp,List<List<String>> ans){
        if(s.equals("")){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<s.length();i++){
            if(isPalindrome(s.substring(0,i+1))){
                temp.add(s.substring(0,i+1));
                partition(s.substring(i+1,s.length()),temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s){
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}

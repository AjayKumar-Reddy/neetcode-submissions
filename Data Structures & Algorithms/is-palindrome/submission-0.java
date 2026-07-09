class Solution {
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char lch=Character.toLowerCase(s.charAt(i));
            char rch=Character.toLowerCase(s.charAt(j));
            if(!Character.isLetterOrDigit(lch) || lch==' ') i++;
            else if(!Character.isLetterOrDigit(rch) || rch==' ') j--;
            else {
                if(lch!=rch){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2) return s;

        int start=0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            int len1=lengthOfplain(s,i,i);
            int len2=lengthOfplain(s,i,i+1);

            int max=Math.max(len1,len2);

            if(max>maxLen){
                maxLen=max;
                start=i-(max-1)/2;
            }
        }

        return s.substring(start, start + maxLen);
    }

    private int lengthOfplain(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}

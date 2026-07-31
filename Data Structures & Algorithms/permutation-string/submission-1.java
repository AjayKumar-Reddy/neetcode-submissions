class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        for(char ch:s1.toCharArray()){
            freq[ch-'a']++;
        }
        int[] temp=new int[26];
        int i=0;
        int j=0;
        while(i<=j && j<s2.length()){
            if(j-i+1<s1.length()){
                temp[s2.charAt(j)-'a']++;
                j++;
                continue;
            } else {
                temp[s2.charAt(j++)-'a']++;
            }

            if(Arrays.equals(temp,freq)){
                return true;
            }

            temp[s2.charAt(i++)-'a']--;
            


        }
        return false;

    }
}

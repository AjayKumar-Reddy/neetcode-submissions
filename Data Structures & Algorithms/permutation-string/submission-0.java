class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq=new int[26];
        for(char ch:s1.toCharArray()){
            freq[ch-'a']++;
        }

        int i=0;
        int j=0;
        while(i<=j && j<s2.length()){
            if(j-i+1<s1.length()){
                j++;
                continue;
            }
            int[] temp=new int[26];
            for(char ch:s2.substring(i,j+1).toCharArray()){
                temp[ch-'a']++;
            
            }

            if(Arrays.equals(temp,freq)){
                return true;
            }
            i++;
            j++;

        }
        return false;

    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hash=new int[26];
        for(char ch:t.toCharArray()){
            hash[ch-'a']++;
        }

        for(char ch: s.toCharArray()){
            hash[ch-'a']--;
        }

        for(int val:hash){
            if(val!=0){
                return false;
            }
        }
        return true;
    }
}

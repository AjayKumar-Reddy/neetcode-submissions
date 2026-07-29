class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxf=0;
        int i=0;
        int j=0;
        int res=0;
        while(i<=j && j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

            maxf=Math.max(maxf,map.get(s.charAt(j)));

            while((j-i+1)-maxf>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }

            res=Math.max(res,j-i+1);
            j++;

        }
        return res;
    }

}

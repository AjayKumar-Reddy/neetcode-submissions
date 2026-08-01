class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int i=0;
        int j=0;
        int count=0;
        int startindx=-1;
        int len=Integer.MAX_VALUE;
        while(j<s.length()){
            if(map.containsKey(s.charAt(j)) && map.get(s.charAt(j))>0){
                count++;
            }

            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
            }

            while(count==t.length()){
                if(j-i+1<len){
                    len=j-i+1;
                    startindx=i;
                }

                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i),map.get(s.charAt(i))+1);
                }

                if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i))>0){
                    count--;
                }

                i++;
            }

            j++;

        
        }
        if(startindx==-1) return "";

        return s.substring(startindx,startindx+len);
        
    }
}

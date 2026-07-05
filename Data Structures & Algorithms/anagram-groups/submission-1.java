class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            int[] hash=new int[26];
            for(char ch:str.toCharArray()){
                hash[ch-'a']++;
            }
            String count=Arrays.toString(hash);
            map.putIfAbsent(count,new ArrayList<>());
            map.get(count).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

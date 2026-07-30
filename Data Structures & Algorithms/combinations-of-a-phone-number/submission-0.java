class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        
        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> words=new ArrayList<>();

        for(char ch:digits.toCharArray()){
            words.add(map.get(Character.getNumericValue(ch)));
        }

        combinations(0,new StringBuilder(),ans,words);
        return ans;

        
    }

    private void combinations(int indx,StringBuilder sb,List<String> ans,List<String> words){
        if(indx==words.size()){
            ans.add(sb.toString());
            return;
        }

        for(char ch:words.get(indx).toCharArray()){
            sb.append(ch);
            combinations(indx+1,sb,ans,words);
            sb.deleteCharAt(sb.length()-1);

        }
    }
}

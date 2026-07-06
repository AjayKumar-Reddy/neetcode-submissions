class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String str:strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        
        char[] ch=str.toCharArray();
        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        int i=0;

        while(i<ch.length){
            if(Character.isDigit(ch[i])){
                sb.append(ch[i]);
            }
            if (ch[i] == '#') {
                int len = Integer.parseInt(sb.toString());

                ans.add(str.substring(i + 1, i + 1 + len));

                sb.setLength(0);

                i = i + 1 + len;
                continue;
            }
            i++;
        }
        return ans;
    }
}

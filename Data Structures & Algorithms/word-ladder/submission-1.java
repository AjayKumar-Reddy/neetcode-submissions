class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String str:wordList){
            set.add(str);
        }

        Deque<String> queue=new ArrayDeque<>();
        queue.offer(beginWord);

        int level=0;

        while(!queue.isEmpty()){
            int n=queue.size();
            level++;
            for(int k=0;k<n;k++){
                String str=queue.poll();

                if(str.equals(endWord)){
                    return level;
                }

                char[] ch=str.toCharArray();
                for(int i=0;i<ch.length;i++){
                    char c=ch[i];
                    for(int j=0;j<26;j++){
                        ch[i]=(char)('a'+j);
                        String next=new String(ch);
                        if(set.contains(next)){
                            queue.offer(next);
                            set.remove(next);
                            
                        }
                    }
                    ch[i]=c;
                }

            }
        }
        return 0;
    }
}

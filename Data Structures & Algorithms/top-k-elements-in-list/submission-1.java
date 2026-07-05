class Pair{
    int ele;
    int freq;
    Pair(int ele,int freq){
        this.ele=ele;
        this.freq=freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }

        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b)->a.freq-b.freq);
        for(Map.Entry<Integer,Integer> me:map.entrySet()){
            minHeap.offer(new Pair(me.getKey(),me.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=minHeap.poll().ele;
        }

        return ans;
    }
}

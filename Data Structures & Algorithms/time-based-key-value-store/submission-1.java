class Pair{
    String val;
    int time;
    public Pair(String val,int time){
        this.val=val;
        this.time=time;
    }
}
class TimeMap {

    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> list=map.get(key);
            list.add(new Pair(value,timestamp));
            map.put(key,list);
        } else {
            List<Pair> list=new ArrayList<>();
            list.add(new Pair(value,timestamp));
            map.put(key,list);
        }
        

    }
    
    public String get(String key, int timestamp) {
        List<Pair> list=map.get(key);
        if(list==null) return "";
        int left=0;
        int right=list.size()-1;
        Pair ans=null;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(list.get(mid).time<=timestamp){
                ans=list.get(mid);
                left=mid+1;
            } else{
                right=mid-1;
            }
        }
        if(ans==null){
            return "";
        } else {
            return ans.val;
        }
    }
}

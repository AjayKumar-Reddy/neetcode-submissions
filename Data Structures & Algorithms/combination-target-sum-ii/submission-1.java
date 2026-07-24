class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);

        combination(candidates,0,target,new ArrayList<>(),ans);
            
        
        
        return ans;
    }
    private void combination(int[] arr,int indx,int target,List<Integer> temp,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=indx;i<arr.length;i++){
            if(i>indx && arr[i]==arr[i-1]) continue;

            if(arr[i]>target) break;

            temp.add(arr[i]);
            combination(arr,i+1,target-arr[i],temp,ans);
            temp.remove(temp.size()-1);
        }
        return;
    }
}

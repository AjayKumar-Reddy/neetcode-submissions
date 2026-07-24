class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);

        combination(candidates,0,0,target,new ArrayList<>(),ans);
            
        
        
        return ans;
    }
    private void combination(int[] arr,int sum,int indx,int target,List<Integer> temp,List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(indx==arr.length) return;
        if(sum>target) return;

        temp.add(arr[indx]);
        combination(arr,sum+arr[indx],indx+1,target,temp,ans);
        temp.remove(temp.size()-1);
        while(indx+1<arr.length && arr[indx]==arr[indx+1]){
            indx++;
        }
        combination(arr,sum,indx+1,target,temp,ans);
    }
}

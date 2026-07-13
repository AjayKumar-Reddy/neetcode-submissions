class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0;
        int right=matrix.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int[] midarr=matrix[mid];
            if(midarr[0]<=target && midarr[m-1]>=target){
                int i=0;
                int j=m-1;
                while(i<=j){
                    int center=i+(j-i)/2;
                    if(midarr[center]<target){
                        i=center+1;
                    } else if(midarr[center]>target){
                        j=center-1;
                    } else{
                        return true;
                    } 
                }
                return false;
            } else if(midarr[0]>target){
                right=mid-1;
            } else if(midarr[m-1]<target){
                left=mid+1;
            } else {
                return false;
            }
            
        }
        return false;
    }
}

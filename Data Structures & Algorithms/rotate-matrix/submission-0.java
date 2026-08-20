class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            int l=0;
            int r=n-1;
            while(l<r){
                int temp=matrix[l][i];
                matrix[l++][i]=matrix[r][i];
                matrix[r--][i]=temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

    }
}

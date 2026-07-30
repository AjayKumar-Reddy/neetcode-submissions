class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] board=new char[n][n];
        for(char[] ch:board){
            Arrays.fill(ch,'.');
        }

        nQueens(0,n,ans,board);
        return ans;
    }

    private void nQueens(int row,int n,List<List<String>> ans,char[][] board){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }

        for(int i=0;i<n;i++){
            if(isSafe(row,i,n,board)){
                board[row][i]='Q';
                nQueens(row+1,n,ans,board);
                board[row][i]='.';
            }
        }
    }

    private boolean isSafe(int row,int col,int n,char[][] board){
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //left diagonal
        int i=row;
        int j=col;
        while(i>=0 && j>=0){
            if(board[i--][j--]=='Q'){
                return false;
            }
        }

        //right diagonal
        i=row;
        j=col;
        while(i>=0 && j<=n-1){
            if(board[i--][j++]=='Q'){
                return false;
            }
        }

        return true;
    }


}

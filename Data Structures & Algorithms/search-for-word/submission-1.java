class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(word.charAt(0)==board[i][j]){
                    char temp=board[i][j];
                    board[i][j]='#';
                    if(search(board,i,j,word,1)){
                        return true;
                    }
                    board[i][j]=temp;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board,int row,int col,String word,int indx){
        if(indx==word.length()){
            return true;
        }

        if(row!=0 && board[row-1][col]!='#' && word.charAt(indx)==board[row-1][col]){
            char temp=board[row-1][col];
            board[row-1][col]='#';
            if(search(board,row-1,col,word,indx+1)){
                return true;
            }
            board[row-1][col]=temp;
        }

        if(col!=board[0].length-1 && board[row][col+1]!='#' && word.charAt(indx)==board[row][col+1]){
            char temp=board[row][col+1];
            board[row][col+1]='#';
            if(search(board,row,col+1,word,indx+1)){
                return true;
            }
            board[row][col+1]=temp;
        }

        if(row!=board.length-1 && board[row+1][col]!='#' && word.charAt(indx)==board[row+1][col]){
            char temp=board[row+1][col];
            board[row+1][col]='#';
            if(search(board,row+1,col,word,indx+1)){
                return true;
            }
            board[row+1][col]=temp;
        }

        if(col!=0 && board[row][col-1]!='#' && word.charAt(indx)==board[row][col-1]){
            char temp=board[row][col-1];
            board[row][col-1]='#';
            if(search(board,row,col-1,word,indx+1)){
                return true;
            }
            board[row][col-1]=temp;
        }

        return false;
    }
}

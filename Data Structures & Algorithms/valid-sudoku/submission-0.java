class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0;i<9;i++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                if(set.contains(board[i][j])){
                    return false;
                }
                if(board[i][j]!='.'){
                    set.add(board[i][j]);
                }
                
            }
            
        }

        for(int i=0;i<9;i++){
            Set<Character> set=new HashSet<>();
            for(int j=0;j<9;j++){
                if(set.contains(board[j][i])){
                    return false;
                }
                if(board[j][i]!='.'){
                    set.add(board[j][i]);
                }
            }
            
        }

        for(int row=0;row<9;row+=3){
            for(int col=0;col<9;col+=3){
                Set<Character> set=new HashSet<>();
                for(int i=row;i<row+3;i++){
                    for(int j=col;j<col+3;j++){
                        if(set.contains(board[i][j])){
                            return false;
                        }
                        if(board[i][j]!='.'){
                            set.add(board[i][j]);
                        }
                    }
                }
            }
        }

        return true;
        
    }
}

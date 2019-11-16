class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length;
        int m = board[0].length;
       boolean [][] visited = new boolean[n][m];
        
        int row = click[0];
        int col = click[1];
        
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
            return board;
        }
        if(board[row][col] == 'E'){
            traverse(row,col,n,m,board);
        }
        
        return board;
    }
    
    public void traverse(int row, int col, int rows,int cols, char[][] board){
        
        if(row<0 || col <0 || row >=rows ||col >=cols){
            return;
        }
    
        if(board[row][col] != 'E'){
            return;
        }
        
        board[row][col] = 'B';
        
        getDigit(row,col,rows,cols,board);
        
        if(Character.isDigit(board[row][col])){
            return;
        }
                      
        traverse(row+1,col,rows,cols,board);
        traverse(row,col+1,rows,cols,board);
        traverse(row-1,col,rows,cols,board);
        traverse(row,col-1,rows,cols,board);
        traverse(row+1,col+1,rows,cols,board);
        traverse(row-1,col+1,rows,cols,board);
        traverse(row-1,col-1,rows,cols,board);
        traverse(row+1,col-1,rows,cols,board);
    }
    
    public void getDigit(int row, int col, int rows,int cols, char[][] board){
       if(row<0 || col <0 || row >=rows ||col >=cols){
            return;
        }              
        int T6 = getDigit1(row+1,col,rows,cols,board);
        int T1 = getDigit1(row+1,col+1,rows,cols,board);
        int T2 =getDigit1(row+1,col-1,rows,cols,board);
        int T7 =getDigit1(row,col+1,rows,cols,board);
        int T8 =getDigit1(row,col-1,rows,cols,board);
        int T3 = getDigit1(row-1,col,rows,cols,board);
        int T4 =getDigit1(row-1,col+1,rows,cols,board);
        int T5 = getDigit1(row-1,col-1,rows,cols,board);  
        
        int total = T1 + T2 + T3 + T4 + T5 + T6 + T7 + T8;
        if(total >0)
            board[row][col] = (char) ('0'+total);
        
    }
    
    public int getDigit1(int row, int col, int rows,int cols, char[][] board){
         if(row<0 || col <0 || row >=rows ||col >=cols){
            return 0;
        }
        int count =0;
        if(board[row][col] == 'M'){
            count = 1;
        }
        return count;
    }
}
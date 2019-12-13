/*Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. 
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. 

Two cells are connected if they are adjacent cells connected horizontally or vertically.

************************************************************************************************************************************************************************************/

class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length ==0){
            return;
        }
        
        for(int i=0;i<board.length;i++){
            markNonFlip(board, i, 0);
            markNonFlip(board,i, board[i].length-1);
        }
        
        for(int j=0;j<board[0].length;j++){
            markNonFlip(board,0,j);
            markNonFlip(board,board.length-1,j);
        }
        
        for(int i=0;i<board.length;i++){
            
            for(int j=0;j<board[i].length;j++){
                
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '_'){
                    board[i][j] = 'O';
                }
            }         
         }
    
    }
    
    public void markNonFlip(char[][] board, int row, int col){
        if(row<0 || row>=board.length || col<0 || col >= board[0].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] = '_';
        markNonFlip(board,row-1,col);
        markNonFlip(board,row+1,col);
        markNonFlip(board,row,col-1);
        markNonFlip(board,row,col+1);
    }
    
}

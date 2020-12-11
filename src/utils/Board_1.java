package utils;

import java.util.List;

public class Board_1 {

    private Boolean[][] board;
    private int numSeats = 0;

    public Board_1(List<String> data){
        board = new Boolean[data.size()][data.get(0).length()];

        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).length(); j++){
                if(data.get(i).charAt(j) == 'L') {
                    board[i][j] = false;
                    numSeats++;
                }
            }
        }

        System.out.println("board created with " + numSeats + " seats.");
        printBoard();
    }

    public boolean updateBoard(){
        Boolean[][] tempBoard = new Boolean[board.length][board[0].length];
        int unchangedSeats = 0;

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                tempBoard[i][j] = board[i][j];
            }
        }


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int occupied = 0;

                if(tempBoard[i][j] == null){
                    continue;
                }

                if(i - 1 >= 0){
                    Boolean n = tempBoard[i - 1][j];
                    if(n != null && n) {
                        occupied++;
                    }
                }

                if(i - 1 >= 0 && j + 1 < board[0].length){
                    Boolean ne = tempBoard[i - 1][j + 1];
                    if(ne != null && ne) {
                        occupied++;
                    }
                }

                if(j + 1 < board[0].length){
                    Boolean e = tempBoard[i][j + 1];
                    if(e != null && e) {
                        occupied++;
                    }
                }

                if(i + 1 < board.length && j + 1 < board[0].length){
                    Boolean se = tempBoard[i + 1][j + 1];
                    if(se != null && se) {
                        occupied++;
                    }
                }

                if(i + 1 < board.length){
                    Boolean s = tempBoard[i + 1][j];
                    if(s != null && s) {
                        occupied++;
                    }
                }

                if(i + 1 < board.length && j - 1 >= 0){
                    Boolean sw = tempBoard[i + 1][j - 1];
                    if(sw != null && sw) {
                        occupied++;
                    }
                }

                if(j - 1 >= 0){
                    Boolean w = tempBoard[i][j - 1];
                    if(w != null && w) {
                        occupied++;
                    }
                }

                if(i - 1 >= 0 && j - 1 >= 0){
                    Boolean nw = tempBoard[i - 1][j - 1];
                    if(nw != null && nw) {
                        occupied++;
                    }
                }


                if(!tempBoard[i][j] && occupied == 0){
                    board[i][j] = true;
                }
                else if(tempBoard[i][j] && occupied >= 4){
                    board[i][j] = false;
                }
                else{
                    unchangedSeats++;
                }
            }
        }

        printBoard();
        return unchangedSeats == numSeats;
    }

    public int getOccupiedSeats(){
        int result = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != null && board[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    public void printBoard(){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != null && !board[i][j]){
                    System.out.print("L");
                }
                else if(board[i][j] != null && board[i][j]){
                    System.out.print("#");
                }
                else{
                    System.out.print(".");
                }
            }
            System.out.print("\n");
        }
    }
}

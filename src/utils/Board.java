package utils;

import java.util.List;

public class Board {

    private Boolean[][] board;
    private int numSeats = 0;

    public Board(List<String> data){
        board = new Boolean[data.size()][data.get(0).length()];

        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).length(); j++){
                if(data.get(i).charAt(j) == 'L') {
                    board[i][j] = false;
                    numSeats++;
                }
            }
        }
    }

    public boolean updateBoard() {
        int noChange = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int occupied = 0;

                if(i - 1 > 0){
                    Boolean n = board[i - 1][j];
                    if(n != null && n) occupied++;
                }

                if(i - 1 >= 0 && j + 1 < board[0].length){
                    Boolean ne = board[i - 1][j + 1];
                    if(ne != null && ne) occupied++;
                }

                if(j + 1 < board[0].length){
                    Boolean e = board[i][j + 1];
                    if(e != null && e) occupied++;
                }

                if(i + 1 < board.length && j + 1 < board[0].length){
                    Boolean se = board[i + 1][j + 1];
                    if(se != null && se) occupied++;
                }

                if(i + 1 < board.length){
                    Boolean s = board[i + 1][j];
                    if(s != null && s) occupied++;
                }

                if(i + 1 < board.length && j - 1 >= 0){
                    Boolean sw = board[i + 1][j - 1];
                    if(sw != null && sw) occupied++;
                }

                if(j - 1 >= 0){
                    Boolean w = board[i][j - 1];
                    if(w != null && w) occupied++;
                }

                if(i - 1 >= 0 && j - 1 >= 0){
                    Boolean nw = board[i - 1][j - 1];
                    if(nw != null && nw) occupied++;
                }


                if(board[i][j] != null && (!board[i][j]) && occupied == 0){
                    board[i][j] = true;
                }
                else if(board[i][j] != null && board[i][j] && occupied >= 4){
                    board[i][j] = false;
                }
                else if(board[i][j] != null){
                    noChange++;
                }
            }
        }

        return noChange == numSeats;
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

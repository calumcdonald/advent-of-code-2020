package utils;

import java.util.List;

public class Board_2 {

    private Boolean[][] board;
    private int numSeats = 0;

    public Board_2(List<String> data){
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
            for(int j = 0; j < board[0].length; j++){
                tempBoard[i][j] = board[i][j];
            }
        }


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int occupied = 0;

                if(tempBoard[i][j] == null){
                    continue;
                }

                for(int k = 1; k <= i; k++){
                    if(i - k >= 0){
                        Boolean n = tempBoard[i - k][j];
                        if(n != null && n){
                            occupied++;
                            break;
                        }
                        else if(n != null){
                            break;
                        }
                    }
                }

                for(int k = 1; k <= i || k < (board[0].length - j); k++){
                    if(i - k >= 0 && j + k < board[0].length){
                        Boolean ne = tempBoard[i - k][j + k];
                        if(ne != null && ne){
                            occupied++;
                            break;
                        }
                        else if(ne != null){
                            break;
                        }
                    }
                }

                for(int k = 1; k < (board[0].length - j); k++){
                    if(j + k < board[0].length){
                        Boolean e = tempBoard[i][j + k];
                        if(e != null && e){
                            occupied++;
                            break;
                        }
                        else if(e != null){
                            break;
                        }
                    }
                }

                for(int k = 1; k < (board.length - i) || k < (board[0].length - j); k++){
                    if(i + k < board.length && j + k < board[0].length){
                        Boolean se = tempBoard[i + k][j + k];
                        if(se != null && se){
                            occupied++;
                            break;
                        }
                        else if(se != null ){
                            break;
                        }
                    }
                }

                for(int k = 1; k < (board.length - i); k++){
                    if(i + k < board.length){
                        Boolean s = tempBoard[i + k][j];
                        if(s != null && s){
                            occupied++;
                            break;
                        }
                        else if(s != null){
                            break;
                        }
                    }
                }

                for(int k = 1; k < (board.length - i) || k <= j; k++){
                    if(i + k < board.length && j - k >= 0){
                        Boolean sw = tempBoard[i + k][j - k];
                        if(sw != null && sw){
                            occupied++;
                            break;
                        }
                        else if(sw != null){
                            break;
                        }
                    }
                }

                for(int k = 1; k <= j; k++) {
                    if(j - k >= 0){
                        Boolean w = tempBoard[i][j - k];
                        if(w != null && w){
                            occupied++;
                            break;
                        }
                        else if(w != null){
                            break;
                        }
                    }
                }

                for(int k = 1; k <= i || k <= j; k++){
                    if(i - k >= 0 && j - k >= 0){
                        Boolean nw = tempBoard[i - k][j - k];
                        if(nw != null && nw){
                            occupied++;
                            break;
                        }
                        else if(nw != null){
                            break;
                        }
                    }
                }


                if(!tempBoard[i][j] && occupied == 0){
                    board[i][j] = true;
                }
                else if(tempBoard[i][j] && occupied >= 5){
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

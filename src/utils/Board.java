package utils;

import java.util.List;

public class Board {

    private Seat[][] board;

    public Board(List<String> data){
        board = new Seat[data.size()][data.get(0).length()];

        for(int i = 0; i < data.size(); i++){
            for(int j = 0; j < data.get(i).length(); j++){
                if(data.get(i).charAt(j) == 'L') {
                    board[i][j] = new Seat();
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
                    Seat n = board[i - 1][j];
                    if(n != null && n.state) occupied++;
                }

                if(i - 1 >= 0 && j + 1 < board[0].length){
                    Seat ne = board[i - 1][j + 1];
                    if(ne != null && ne.state) occupied++;
                }

                if(j + 1 < board[0].length){
                    Seat e = board[i][j + 1];
                    if(e != null && e.state) occupied++;
                }

                if(i + 1 < board.length && j + 1 < board[0].length){
                    Seat se = board[i + 1][j + 1];
                    if(se != null && se.state) occupied++;
                }

                if(i + 1 < board.length){
                    Seat s = board[i + 1][j];
                    if(s != null && s.state) occupied++;
                }

                if(i + 1 < board.length && j - 1 >= 0){
                    Seat sw = board[i + 1][j - 1];
                    if(sw != null && sw.state) occupied++;
                }

                if(j - 1 >= 0){
                    Seat w = board[i][j - 1];
                    if(w != null && w.state) occupied++;
                }

                if(i - 1 >= 0 && j - 1 >= 0){
                    Seat nw = board[i - 1][j - 1];
                    if(nw != null && nw.state) occupied++;
                }


                if(board[i][j] != null && (!board[i][j].state) && occupied == 0){
                    board[i][j].state = true;
                }
                else if(board[i][j] != null && board[i][j].state && occupied >= 4){
                    board[i][j].state = false;
                }
                else{
                    noChange++;
                }
            }
        }

        if(noChange == (board.length * board[0].length)){
            return true;
        }
        else{
            return false;
        }
    }

    public int getOccupiedSeats(){
        int result = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != null && board[i][j].state){
                    result++;
                }
            }
        }

        return result;
    }
}

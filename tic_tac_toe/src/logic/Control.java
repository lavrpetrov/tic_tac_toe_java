package logic;

import java.util.Random;

public class Control {
    private int [][] tictactoe;
    private int[][] randomMassiv={{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    public static Integer player=1;
    public static Integer computer=0;
    public Control(){
        tictactoe= new int[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        random();
    }
    private void random(){
        Random rnd = new Random();
        for(int i = 0; i < randomMassiv.length; i++) {
            int index = rnd.nextInt(i + 1);
            int[] a = randomMassiv[index];
            randomMassiv[index] = randomMassiv[i];
            randomMassiv[i] = a;
        }
    }
    public int[] computerChoice(){
        int[] ret={-1,-1};
        int i=0;
        while(ret[0]==-1 && i<9){
            if (tictactoe[randomMassiv[i][0]][randomMassiv[i][1]]==-1){
                tictactoe[randomMassiv[i][0]][randomMassiv[i][1]]=computer;
                ret[0]=randomMassiv[i][0];
                ret[1]=randomMassiv[i][1];

            }
            i++;
        }
        return ret;
    }
    public boolean checkSquare(int i,int j,int xOr0){
        boolean check=false;
        if (tictactoe[i][j]==-1) {
            tictactoe[i][j]=player;
            check=true;}
        return check;
    }
    //вернет true, если не осталось пустых ячеек
    public boolean emptyCell(){
        boolean returnn=true;
        for (int i =0;i<3;i++){
            for (int j=0;j<3;j++){
                if (tictactoe[i][j]==-1){
                    returnn=false;
                }
            }
        }
        return returnn;
    }
    public boolean checkWinner(int symb){
        boolean returnn=false;
        boolean toright, toleft;
        toright = true;
        toleft = true;
        for (int i=0; i<3; i++) {
            toright &= (tictactoe[i][i] == symb);
            toleft &= (tictactoe[3-i-1][i] == symb);
        }
        boolean cols, rows;
        for (int col=0; col<3; col++) {
            cols = true;
            rows = true;
            for (int row=0; row<3; row++) {
                cols &= (tictactoe[col][row] == symb);
                rows &= (tictactoe[row][col] == symb);
            }

            if (cols || rows) {
                returnn= true;
                break;
            }
        }
        if (toright || toleft) returnn= true;
        return returnn;
    }


}

package logic;

import java.util.Random;

public class Control {
    private int [][] tictactoe={{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    private int[][] randomMassiv={{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
    public static Integer player=1;
    public static Integer computer=0;
    public Control(){
        random();
    }
    private void random(){
        Random rnd = new Random();
        for(int i = 0; i < randomMassiv.length; i++) {
            int index = rnd.nextInt(i + 1);
            int[] a = randomMassiv[index];
            randomMassiv[index] = randomMassiv[i];
            randomMassiv[i] = a;

        }for (int i=0;i<=8;i++){
            System.out.println(randomMassiv[i][0]+" "+randomMassiv[i][1]);
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
        print();
        return ret;
    }
    private void print(){
        for (int i=0;i<3;i++){
            System.out.println(tictactoe[i][0]+" "+tictactoe[i][1]+" "+tictactoe[i][2]);
        }
    }
    public boolean checkSquare(int i,int j,int xOr0){
        boolean check=false;
        if (tictactoe[i][j]==-1) {
            tictactoe[i][j]=player;
            check=true;}
        print();
        return check;
    }

}

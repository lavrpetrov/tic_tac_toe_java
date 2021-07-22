public class Control {
    private int [][] tictactoe={{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};
    public static Integer player=1;
    public static Integer computer=0;
    public boolean checkSquare(int i,int j,int xOr0){
        boolean check=false;
        if (tictactoe[i][j]==-1) {
            tictactoe[i][j]=player;
            check=true;}
        return check;
    }

}

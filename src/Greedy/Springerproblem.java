package Greedy;

public class Springerproblem {

    public void solve(int[][] schachbrett) {

        int[][] tmp =schachbrett;
        for(int zeile = 1; zeile < schachbrett.length; zeile++){
            for(int spalte = 0; spalte <= zeile; spalte++){
                if(spalte == 0){
                    tmp[zeile][spalte] += tmp[zeile-1][spalte];
                }else{
                    if(spalte==zeile || schachbrett[zeile-1][spalte-1] > schachbrett[zeile-1][spalte]){
                        tmp[zeile][spalte] += tmp[zeile-1][spalte-1];
                    }else{
                        tmp[zeile][spalte] += tmp[zeile-1][spalte];
                    }
                }
                print(tmp);
            }
        }
    }

    public void print(int[][] tmp){
        for (int i = 0; i < tmp.length; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public static void main(String args[]) {
        Springerproblem s = new Springerproblem();
        int[][] brett = {
                {10, 0, 0, 0, 0, 0, 0},
                {82, 81, 0, 0, 0, 0, 0},
                {4, 6, 10, 0, 0, 0, 0},
                {2, 14, 35, 7, 0, 0, 0},
                {41, 3, 52, 26, 15, 0, 0},
                {32, 90, 11, 87, 56, 23, 0},
                {54, 65, 89, 32, 71, 9, 31}
        };
        s.solve(brett);
    }

}

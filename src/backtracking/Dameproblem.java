package backtracking;

public class Dameproblem {

    public int count = 0;

    public boolean isCandidate(int[][] brett, int zeile, int spalte){
        if(zeile == 0 ){
            return true;
        }
        for(int i = 1; i <= zeile; i++){
            if(spalte-i >=0 && brett[zeile-i][spalte-i] == 1){
                return false;
            }
            if(spalte+i < brett.length && brett[zeile-i][spalte+i] == 1){
                return false;
            }
            if(brett[zeile-i][spalte] == 1){
                return false;
            }
        }
        return true;
    }

    public void solve(int[][] brett, int stufe){
        for(int spalte = 0; spalte < brett.length; spalte++){
            if(isCandidate(brett,stufe,spalte)){
                brett[stufe][spalte] = 1;
                if(stufe == brett.length-1){
                    print(brett);
                    count = count + 1;
                }else {
                    solve(brett, stufe + 1);
                }
                brett[stufe][spalte] = 0;
            }
        }
    }

    public void print(int[][] tmp){
        for (int i = 0; i < tmp.length; i++){
            for (int j = 0; j < tmp.length; j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public static void main(String args[]){
        int[][] brett = new int[9][9];
        Dameproblem d = new Dameproblem();
        d.solve(brett, 0);
        System.out.println(d.count);
    }
}

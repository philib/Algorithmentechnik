package backtracking;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Phil on 30.06.2017.
 */
public class Tuerme {

    public int counter = 0;

    public void solve(int[][] brett, int stufe) {
        for (int spalte = 0; spalte < brett.length; spalte++) {
            if (isCandidate(brett, stufe, spalte)) {
                brett[stufe][spalte] = 1;
                if (stufe == brett.length - 1) {
                    print(brett);
                    counter = counter + 1;
                } else {
                    solve(brett, stufe + 1);
                }
                brett[stufe][spalte] = 0;
            }
        }
    }

    public boolean isCandidate(int[][] brett, int zeile, int spalte) {

        if (zeile == 0) {
            return true;
        }
        for (int i = 1; i <= zeile; i++) {
            if (spalte - i >= 0 && brett[zeile - i][spalte - i] == 1) {
                return false;
            }
            if (spalte + i < brett.length && brett[zeile - i][spalte + i] == 1) {
                return false;
            }
            if (brett[zeile - i][spalte] > 0) {
                return false;
            }
        }
        return true;
    }

    public void solve2(int[][] brett, int stufe, int count) {
        for (int spalte = 0; spalte < brett.length; spalte++) {
            if (isCandidate2(brett, stufe, spalte)) {
                brett[stufe][spalte] = stufe + 1;
                if (stufe == brett.length - count + 1) {
                    print(brett);
                    counter = counter + 1;
                } else {
                    solve2(brett, stufe + 1, count);
                }
                brett[stufe][spalte] = 0;
            }
        }
    }

    public boolean isCandidate2(int[][] brett, int zeile, int spalte) {

        if (zeile == 0) {
            return true;
        }
        for (int i = 1; i <= zeile; i++) {
            if (brett[zeile - i][spalte] > 0) {
                return false;
            }
        }
        return true;
    }

    public void solve3(int[][] brett, int stufe, int count) {
        for (int spalte = 0; spalte < brett.length; spalte++) {
            if (isCandidate3(brett, stufe, spalte)) {
                brett[stufe][spalte] = stufe + 1;
                if (stufe == brett.length - count + 1) {
                    print(brett);
                    counter = counter + 1;
                } else {
                    solve3(brett, stufe + 1, count);
                }
                brett[stufe][spalte] = 0;
            }
        }
    }

    public boolean isCandidate3(int[][] brett, int zeile, int spalte) {

        if (zeile == 0) {
            return true;
        }
        int index = -1;
        for (int j = 0; j < brett.length; j++) {
            if (brett[zeile - 1][j] > 0) {
                index = j;
            }
        }
        if(index>spalte) return false;


        for (int i = 1; i <= zeile; i++) {
            if (brett[zeile - i][spalte] > 0) {
                return false;
            }
        }
        return true;
    }

    public void print(int[][] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp.length; j++) {
//                if(tmp[j][i] > 0){
                System.out.print(tmp[i][j] + " ");
//                }
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public static void main(String args[]) {
        int[][] brett = new int[5][5];
        Tuerme d = new Tuerme();
        d.solve(brett, 0);
//        d.solve2(brett, 0, 4);
//        d.solve3(brett,0,5);
        System.out.println(d.counter);
    }
}

package backtracking;

/**
 * Created by Phil on 01.07.2017.
 */
public class Springer {

    int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int counter = 0;

    public void solve(int[][] brett, int x, int y, int stufe) {
        for (int i = 0; i < dx.length; i++) {
            if (isCandidate(brett, (y + dy[i]), x + dx[i])) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                brett[newY][newX] = stufe;
                if (isSolution(brett)) {
                    print(brett);
                    counter ++;
                } else {
                    solve(brett, newX, newY, stufe + 1);
                }
                brett[newY][newX] = 0;
            }
        }
    }

    public boolean isSolution(int[][] brett) {
        for (int i = 0; i < brett.length; i++) {
            for (int j = 0; j < brett.length; j++) {
                if (brett[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isCandidate(int[][] brett, int y, int x) {
        if (y >= 0 && y < brett.length && x >= 0 && x < brett.length && brett[y][x] == 0) {
            return true;
        }
        return false;
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
        Springer s = new Springer();
        int[][] brett = new int[5][5];
        brett[2][2]=1;
//        for (int i = 0; i < brett.length; i++) {
//            for (int j = 0; j < brett.length; j++) {
                s.solve(brett, 2, 2, 2);
//            };
//        }
        System.out.println(counter);
    }
}

package backtracking;

public class Fotoproblem {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public void solve(int[][] foto) {
        int color = 2;
        for (int i = 0; i < foto.length; i++) {
            for (int j = 0; j < foto[0].length; j++) {
                if (foto[i][j] == 1) {
                    foto[i][j] = color;
                    color+=1;
                    group(foto, i, j);
                }
            }
        }
        print(foto);
    }

    public void group(int[][] foto, int y, int x) {
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isCandidate(foto,newX,newY)) {
                foto[newY][newX] = foto[y][x];
                group(foto, newY, newX);
            }
        }
    }

    public boolean isCandidate(int[][] foto, int x, int y) {
        return x >= 0 && x < foto[0].length && y >= 0 && y < foto.length && foto[y][x] == 1;
    }

    public void print(int[][] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    public static void main(String args[]) {
        int[][] foto = new int[4][5];
        foto[0][0] = 1;
        foto[2][0] = 1;
        foto[3][0] = 1;
        foto[0][1] = 1;
        foto[2][1] = 1;
        foto[3][2] = 1;
        foto[0][3] = 1;
        foto[1][3] = 1;
        foto[2][3] = 1;
        foto[3][3] = 1;
        foto[0][4] = 1;
        foto[2][4] = 1;

        Fotoproblem f = new Fotoproblem();
        f.solve(foto);
    }

}

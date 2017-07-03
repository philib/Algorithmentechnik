package dynamisch;

/**
 * Created by Phil on 01.07.2017.
 */
public class LaengsteGemeinsameTeilfolge {

    public static void main(String args[]) {

        LaengsteGemeinsameTeilfolge l = new LaengsteGemeinsameTeilfolge();
        int[] folge1 = {10, 4, 20, 10, 40, 2, 0, 60};
        int[] folge2 = {4, 90, 7, 10, 70, 2, 71, 81, 0};
        int[][] arr = new int[folge1.length + 1][folge2.length + 1];

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (folge2[j - 1] == folge1[i - 1]) {
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        int x = folge2.length;
        int y = folge1.length;

        while (x > 0 && y > 0) {

            if (arr[y][x] == arr[y - 1][x]) {
                y = y - 1;
            } else if (arr[y][x] == arr[y][x - 1]) {
                x = x - 1;
            } else if (arr[y][x] == arr[y - 1][x - 1] + 1) {
                System.out.print(folge2[x-1]+" ");
                x = x - 1;
                y = y - 1;
            }
        }
        System.out.println();
        l.print(arr);
    }

    public void print(int[][] liste) {
        for (int i = 0; i < liste.length; i++) {
            for (int j = 0; j < liste[0].length; j++) {
                System.out.print(liste[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

}

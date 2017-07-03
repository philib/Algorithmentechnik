package dynamisch;

public class LaengsteAufsteigendeTeilfolge {

    public static void main(String args[]) {

        LaengsteAufsteigendeTeilfolge l = new LaengsteAufsteigendeTeilfolge();
        int[] liste = {3, 5, 76, 1, 45, 2, 31, 89, 90, 0, 4, 12, 23, 47, 95, 21, 67, 8, 13, 11, 5, 145, 132, 77};
        int[] liste2 = {3, 4, -1, 0, 6, 2, 3};
        int[] folge = new int[liste.length];
        l.print(liste);

        for (int a = 0; a < folge.length; a++) {
            folge[a] = 1;
        }


        for (int i = 0; i < liste.length - 1; i++) {
            for (int j = i + 1; j < liste.length; j++) {
                if (liste[i] < liste[j]) {
                    folge[j] = Math.max(folge[i] + 1, folge[j]);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < folge.length; i++) {
            if (folge[i] > result)
                result = folge[i];
        }
        l.print(folge);
        System.out.println("# Solutions: "+result);
    }

    public void print(int[] liste) {
        for (int i = 0; i < liste.length; i++) {
            if (liste[i] < 10) {
                System.out.print("00" + liste[i] + " ");
            } else if (liste[i] < 100) {
                System.out.print("0" + liste[i] + " ");
            } else {
                System.out.print(liste[i] + " ");
            }
        }
        System.out.println();
    }

}

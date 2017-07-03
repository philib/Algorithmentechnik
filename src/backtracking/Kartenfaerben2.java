package backtracking;

import java.util.Arrays;

public class Kartenfaerben2 {

    static int[][] laender = new int[][] {
            {0,1,1,1,0,0,1},
            {1,0,1,1,0,0,0},
            {1,1,0,1,1,0,1},
            {1,1,1,0,1,0,1},
            {0,0,1,1,0,1,1},
            {0,0,0,0,1,0,1},
            {1,0,1,1,1,1,0}
    };

    static int[] farben = new int[laender.length];

    private static boolean gueltig(int land, int farbe) {
        if (farbe == 0) return false; // 0 ist keine g�ltige farbe
        for (int nachbar = 0; nachbar < laender.length; nachbar++) {
            if (laender[land][nachbar] == 1 && farben[nachbar] == farbe)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int land = 0;
        while (land < laender.length) {
            int farbe = farben[land];

            if (gueltig(land, farbe)) {
                // farbe ist g�ltig, mache mit n�chstem land weiter
                land++;
            } else {
                // farbe ist nicht g�ltig
                if (farbe == 4) {
                    // es gibt keine weiteren farben mehr!
                    farben[land] = 1; // setze farbe f�r dieses land zur�ck
                    farben[land-1] = farben[land-1] + 1; // f�rbe das vorherige land anders
                    land--; // gehe zum vorherigen land zur�ck
                } else {
                    // die aktuelle farbe war nicht m�glich, aber es gibt noch weitere farben
                    farben[land] = farben[land] + 1;
                }
            }
        }

        System.out.println(Arrays.toString(farben));
        for (int i = 0; i < laender.length; i++) {
            System.out.println(gueltig(i, farben[i]));
        }
    }
}

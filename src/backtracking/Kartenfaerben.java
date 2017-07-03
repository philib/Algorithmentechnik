package backtracking;

public class Kartenfaerben {

    public boolean solve(int[][] karte, int[] faerbung, int farben, int stufe) {

        for (int i = 0; i < karte.length; i++) {
            if (karte[stufe][i] == 1 && faerbung[i] == 0) {
                for (int farbe = 1; farbe <= farben; farbe++) {
                    if (isCandidate(karte, faerbung, farbe, i)) {
                        faerbung[i] = farbe;
                        if (isSolution(faerbung)) {
                            print(faerbung);
                            return true;
                        } else if(solve(karte, faerbung, farben, stufe + 1)) {
                            return true;
                        }else{
                            faerbung[i] = 0;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isSolution(int[]farben){
        for (int i = 0; i < farben.length; i++){
            if(farben[i]==0){
                return false;
            }
        }
        return true;
    }

    public boolean isCandidate(int[][] karte, int[] faerbung, int farbe, int land) {
        for (int i = 0; i < karte.length; i++) {
            if (karte[land][i] == 1 && faerbung[i] == farbe) {
                return false;
            }
        }
        return true;
    }

    public void print(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println();
        System.out.println("--------------");
    }

    public static void main(String args[]) {
        Kartenfaerben k = new Kartenfaerben();

        int[][] karte2 = {
                {0, 1, 1, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 0, 1},
                {0, 0, 1, 1, 0, 1, 1},
                {0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 0}};

        int[][] karte = {
                {0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 1},
                {0, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 1, 0}};

        int[] farben = {1, 2, 3};
        int[] faerbung = new int[karte.length];
        faerbung[0]=1;
        if(!k.solve(karte2,faerbung,4,0)){
            System.out.println("kein ergebnis");
        }

    }


}

package Greedy;

import java.util.LinkedHashSet;
import java.util.Set;

class Kartenfaerben {

    public static int[][] karte = {
            {0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 1},
            {1, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 0}};

    public void faerben(int[][] matrix) {
//        int[] laender = new int[matrix.length];

//        for (int i = 0; i < laender.length; i++) {
//            laender[i] = matrix[0][i];
//        }
//        laender[0] = 0;

        Set<Integer> laender = new LinkedHashSet<Integer>();

        laender.add(1);
        int[] colors = new int[matrix.length];

        for(int c = 0; c < matrix.length; c++){
            colors[c] = -1;
        }
        colors[0] = 0;

        while (!laender.isEmpty()){
            System.out.println("-------");

            int land = findMin(laender,matrix);
            System.out.println("Land "+land);
            //NachbarSuche
            Set<Integer> nc = new LinkedHashSet<Integer>();
            for (int i = 0; i < matrix.length; i++){
                if(matrix[land][i] == 1){
                    System.out.print("Nachbar " + i);
                    if(colors[i] == -1){
                        laender.add(i);
                        System.out.println(" Ungefaerbt");
                    }
                    if(colors[i] > -1){
                        nc.add(colors[i]);
                        System.out.println(" Farbe " + colors[i]);
                    }
                }


            }
            int color = -1;
            //Farbsuche
            if(nc.isEmpty()){
                colors[land] = 0;
            }else {
                for (int col = 0; col < matrix.length; col++){
                    boolean exists = false;
                    for(Integer l : nc){
                        if (l == col){
                            exists = true;
                        }
                    }
                    if(!exists){
                        color = col;
                        break;
                    }
                }
                if(color > -1) colors[land] = color;
                System.out.println("Setze Farbe "+ color);
            }

            laender.remove(land);
        }
        for (int h = 0; h < colors.length; h++){
            System.out.println(colors[h]);
        }
    }

    public int findMin(Set<Integer> i, int[][] m){
        int min = 123123;
        int land = -1;
        for(Integer s: i){
            int sum = 0;
            for(int j = 0; j < m.length; j++){
                if(m[s][j] == 1){
                    sum++;
                }
            }
            if(sum < min){
                min = sum;
                land = s;
            }
        }
        System.out.println("Anzahl Nachbarn "+min);
        return land;
    }

    public static void main(String args[]) {
        Kartenfaerben k = new Kartenfaerben();
        k.faerben(karte);
    }
}

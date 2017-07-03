package backtracking;

public class HausVomNikolaus {

    int counter = 1;

    public void solve(int[] vec, int stufe) {
        for (int i = 1; i <= 5; i++) {
            vec[stufe] = i;
            if(movePossible(vec, stufe)){
                if(stufe == vec.length-1){
                    print(vec);
                    counter++;
                }else{
                    solve(vec,stufe+1);
                }
            }
            vec[stufe] = 0;
        }
    }

    public boolean movePossible(int[]vec, int schritt){
        if(vec[schritt] == vec[schritt-1]){
            return false;
        }else if(vec[schritt] == 4 && (vec[schritt-1]==1 || vec[schritt-1] == 2)){
            return false;
        }else if(vec[schritt-1] == 4 && (vec[schritt]==1 || vec[schritt]==2)){
            return false;
        }else{
            for(int i = 0; i < vec.length; i++){
                if(vec[i]==vec[schritt] && schritt!=i){
                    if((i>=1 && vec[i-1] == vec[schritt-1]) || (i<vec.length-1 && vec[i+1] == vec[schritt-1])){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void print(int[] vec){
        System.out.print("Solution "+counter+" : ");
        for(int i = 0; i< vec.length; i++){
            if(i == vec.length-1){
                System.out.print(vec[i]);
            }else{
                System.out.print(vec[i] + " -> ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String args[]) {
        HausVomNikolaus h = new HausVomNikolaus();
        int[] sol = new int[9];
        sol[0]=1;
        h.solve(sol,1);
    }
}

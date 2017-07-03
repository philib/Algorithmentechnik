package backtracking;

public class Referate {
    public int counter = 0;

    public boolean isCandidate(int[] ref, int stufe) {
        boolean tmp = true;
        if(ref[stufe] != 0){
            tmp = false;
        }
        return tmp;
    }

    public boolean isSolution(int ref[]){
        boolean tmp = false;
        for (int i = 0; i < ref.length; i++) {
            for (int j = 0; j < ref.length; j++) {
                if (ref[i] != ref[j]) {
                    tmp = true;
                }
            }
        }
        return tmp;
    }

    public void print(int[] tmp) {
        for (int i = 0; i < tmp.length; i++) {
            System.out.print(tmp[i] + " ");
        }
        System.out.println("-------");
    }

    public void solve(int[] ref, int refs, int stufe) {
        for (int i = 1; i < refs+1; i++) {
            if (isCandidate(ref, stufe)) {
                ref[stufe] = i;

                if (stufe == ref.length -1 && isSolution(ref)) {
                    counter++;
                    print(ref);
                    ref[stufe] = 0;
                } else {
                    if(stufe < ref.length-1) solve(ref,refs,  stufe + 1);
                }
            }
            ref[stufe] = 0;
        }
    }

    public static void main(String args[]) {
        Referate r = new Referate();
        r.solve(new int[4], 3, 0);    }
}

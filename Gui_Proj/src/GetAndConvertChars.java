import java.util.ArrayList;
import java.util.Collections;

public class GetAndConvertChars {
    char ch;
    boolean nextrow;
    //  int[] bin = new int[10];
    ArrayList<Integer> bin = new ArrayList<>();

    public GetAndConvertChars(char ch) {
        this.ch = Character.toUpperCase(ch);
       // this.ch = ch;
        ConvertingChars(this.ch);
        }


    public void ConvertingChars(char ch) {

        for(int i = 10, j = 0; i > 0&&j<=bin.size(); i--, j++){
            //bitowe przesunęcie w prawo o j i mnozymy na 1 i zapisujemy do bin
            bin.add((ch>>j)&1);
        }
        bin.set(6, 0);
        Collections.reverse(bin);
        for (int i = 0; i < bin.size(); i++) {
            System.out.print(bin.get(i) + " ");
        }
        System.out.println();
    }
}


/*

 for (int i = 9, j = 0; i > 0&&j<=bin.length; i--, j++) {
            bin[i]=(ch >> j) & 1;
bin[3]=0;
for (int i = 0; i <bin.length; i++) {
        System.out.print(bin[i]+" ");
        }
        System.out.println();

for (int i = 0; i < bin.length / 2; i++){
        int tmp=bin[i];
        bin[i]=bin[bin.length-i-1];
        bin[bin.length-i-1]=tmp;
        }
*/

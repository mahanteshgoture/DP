import java.util.Arrays;

public class ArrayFillExample {

    public static void main(String[] args){

        int[] array=new int[10];

        Arrays.fill(array,Integer.MIN_VALUE);

        for(int item:array)
            System.out.print(item);
    }
}

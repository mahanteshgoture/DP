public class RotateLeftArray {

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5};
        int d = 4;

        for (int i = 0; i < d; i++) {
            int temp = array[0];
            System.arraycopy(array, 1, array, 0, array.length - 1);
            array[array.length - 1] = temp;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++)
            sb.append(array[i] + " ");

        System.out.println(sb.toString());
    }
}

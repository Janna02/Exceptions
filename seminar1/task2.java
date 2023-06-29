import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {
        int[] array1 = { 5, 9, 6, 3 };
        int[] array2 = { 8, 2, 7, 4, 6 };
        System.out.println(Arrays.toString(diffArrayElem(array1, array2)));
    }

    public static int[] diffArrayElem(int[] array1, int[] array2) {
        if (array1.length != array2.length) {
            throw new ArrayIndexOutOfBoundsException("Длины массивов не равны");
        }
        int[] array = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i] - array2[i];
        }
        return array;
    }

}

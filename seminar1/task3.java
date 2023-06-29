import java.util.Arrays;

public class task3 {
    public static void main(String[] args) {
        int[] array1 = { 5, 9, 6, 3 };
        int[] array2 = { 8, 2, 0, 4 };
        System.out.println(Arrays.toString(divArrayElem(array1, array2)));
    }

    public static int[] divArrayElem(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] array = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("Нельзя делить на 0");
            }
            array[i] = arr1[i] / arr2[i];
        }
        return array;
    }

}

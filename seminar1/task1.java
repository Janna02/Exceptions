public class task1 {
    public static void main(String[] args) {
        int[] array = new int[] { 10, 2, 9, 1, 99, 55, 12, 25 };

        System.out.println("Такого индекса в массиве не существует, больше или равно длины массива");
        int sumOfArray = getArrayIndexOutOfBounds(array);

        System.out.println("Синтаксическая ошибка");
        getSyntaxError();

        System.out.println("Переполнение стека");
        getStackOverflowError(1);
    }

    public static int getArrayIndexOutOfBounds(int[] arr) {
        int sum = 0;
        for (int i = 0; i <= arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void getSyntaxError() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
    }

    public static void getStackOverflowError(int n) {
        System.out.println(n);
        n++;
        getStackOverflowError(n);
    }

}

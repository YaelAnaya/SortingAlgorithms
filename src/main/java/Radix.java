import java.util.Arrays;
import java.util.Random;

public class Radix {
    int[] array;

    public Radix() {
        fillArray();
    }
    public int[] getArray() {
        return array;
    }

    public int getSizeArray(){
        return array.length;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void radixSort(int[] array) {
        int max = getMax(array, array.length);
        for (int exp = 1; max / exp > 0; exp *= 10)
            array = countSort(array, array.length, exp);
    }

    private int[] countSort(int array[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(array[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            array[i] = output[i];

        return array;
    }

    private int getMax(int[] a, int n) {
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public void fillArray() {
        array = new int[195312500];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(195312500) + 2;
        }
    }

    public String showArray(){
        var cadena = " ";
        for(int i = 0; i < 195312500; i++)
            cadena += array[i] + " - ";

        return cadena;
    }
}

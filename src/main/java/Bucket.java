import java.util.*;
public class Bucket {
    int[] array;
    public Bucket() {
        fillArray();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int[] bucketSort(int[] array){
        int[] bucket = new int[getMax(array, array.length) + 1];
        int[] sortedArray = new int[array.length];

        for(int i = 0; i < array.length; i++){
            bucket[array[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++){
            for (int j = 0; j < bucket[i]; j++){
                sortedArray[outPos++] = i;
            }
        }
        return sortedArray;
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
            array[i] = rnd.nextInt(195312500) + 1;
        }
    }

    public String showArray(){
        var cadena = " ";
        for(int i = 0; i < 195312500; i++)
            cadena += array[i] + " - ";

        return cadena;
    }
}

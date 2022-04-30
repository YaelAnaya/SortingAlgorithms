import java.util.Random;

public class QuickSort {
    int[] array;

    public QuickSort() {
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


    public void quicksort(int a[], int primero, int ultimo) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = a[central];
        i = primero;
        j = ultimo;
        do {
            while (a[i] < pivote) i++;
            while (a[j] > pivote) j--;
            if (i <= j) {
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j)
            quicksort(a, primero, j); // mismo proceso con sublista izqda
        if (i < ultimo)
            quicksort(a, i, ultimo); // mismo proceso con sublista drcha

    }

    public int[] fillArray(int size) {
        int [] array = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(size) + 1;
        }
        return array;
    }

    public String showArray(int[] array){
        var cadena = " ";
        for(int i = 0; i < 20; i++)
            cadena += array[i] + " - ";
        return cadena;
    }


}


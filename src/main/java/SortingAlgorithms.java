import java.util.Arrays;

public class SortingAlgorithms {

    public SortingAlgorithms() {

    }

    /**
     * El método de inserción directa es un algoritmo de ordenamiento, que consiste en insertar un elemento
     * del arreglo en su parte izquierda, que ya se encuentra ordenada. Esto se repite desde el segundo elemento
     * hasta el final del arreglo.
     *
     * @param array El arreglo a ordenar.
     * @return El arreglo ordenado.
     * */
    public int[] insertionSort(int[] array) {
        int aux, i, j;
        // Se recorre el arreglo desde el segundo elemento hasta el final.
        for (i = 1; i < array.length; i++) {
            // Se guarda el elemento a insertar.
            aux = array[i];
            j = i - 1;
            // Se compara el elemento a insertar con el elemento que se encuentra a su izquierda.
            while (j >=0 && aux < array[j])
                // Si el elemento a insertar es menor que el elemento que se encuentra a su izquierda, se intercambian
                array[j + 1] = array[j--];
            // Se inserta el elemento en la posición correcta.
            array[j + 1] = aux;
        }
        return array;

    }
    /**
     * La idea básica de este algoritmo consiste en buscar el elemento más pequeño del arreglo, y colocarlos
     * en la primera posición. Luego, se busca el siguiente elemento más pequeño, y se coloca en la segunda
     * posición, y así sucesivamente. Esto se repite hasta que todos los elementos estén en su posición correcta.
     *
     * @param array El arreglo a ordenar.
     * @return El arreglo ordenado.
     * */
    public int[] selectionSort(int[] array) {
        int less, oldLessIndex;
        // Se corre el arreglo desde el primer hasta el penúltimo elemento.
        for (int i = 0; i < array.length - 1; i++) {
            // Se asigna al elemento en la posición i como el menor.
            less = array[i];
            // Se guarda la posición del menor.
            oldLessIndex = i;
            // Se compara que el elemento designado si sea el menor del arreglo.
            for (int j = i + 1; j < array.length; j++) {
                // Si el elemento en la posición j es menor, se cambia el menor.
                if (array[j] < less) {
                    less = array[j];
                    oldLessIndex = j;
                }
            }
            // Si el menor no es el elemento en la posición i, se intercambian los elementos.
            array[oldLessIndex] = array[i];
            array[i] = less;
        }
        return array;
    }
    /**
     * El método de shell es un algoritmos de ordenamiento, que consiste en dividir el arreglo en subarreglos
     *
     *
     * @param array El arreglo a ordenar.
     * @return El arreglo ordenado.
     * */
    public int[] shellSort(int[] array) {
        int interval = array.length, i, aux;
        while (interval > 1) {
            interval /= 2;
            boolean swappedPositions = true;
            while (swappedPositions) {
                swappedPositions = false;
                i = 0;
                while ((i + interval) < array.length) {
                    if (array[i] > array[i + interval]) {
                        aux = array[i];
                        array[i] = array[i + interval];
                        array[i + interval] = aux;
                        swappedPositions = true;
                    }
                    i++;
                }
            }
        }
        return array;
    }
    public int[] quicksort(int[] array) {
        quicksort(0, array.length - 1, array);
        return array;

    }
    private void quicksort(int start, int end, int[] array) {
        int left = start, right = end, pivot = start;
        boolean leftSwapped = true;
        while (leftSwapped) {
            leftSwapped = false;
            while(array[pivot] <= array[right] && pivot != right) {
                right--;
            }
            if (pivot != right) {
                int aux = array[pivot];
                array[pivot] = array[right];
                array[right] = aux;
                pivot = right;

                while(array[pivot] >= array[left] && pivot != left) {
                    left++;
                }
                if (pivot != left) {
                    leftSwapped = true;
                    int aux2 = array[pivot];
                    array[pivot] = array[left];
                    array[left] = aux2;
                    pivot = left;
                }
            }
        }

        if (pivot - 1 > start) {
            quicksort(start, pivot - 1, array);
        }
        if (end > pivot + 1) {
            quicksort(pivot + 1, end, array);
        }
    }


    public int[] radixSort(int[] array) {
        int max = getMax(array, array.length);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            array = countSort(array, array.length, exp);
        }

        return array;

    }

    private int[] countSort(int array[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++) {
            array[i] = output[i];
        }

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

    public int[] bucketSort(int[] array) {
        int[] bucket = new int[getMax(array, array.length) + 1];
        int[] sortedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            bucket[array[i]]++;
        }
        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                sortedArray[outPos++] = i;
            }
        }
        return sortedArray;
    }

}

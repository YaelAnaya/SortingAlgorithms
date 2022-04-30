import java.util.Random;
public class Heap {
    int[] array;
    public Heap() {
        fillArray();
    }

    public int[] getArray() {
        return array;
    }

    public int getSizeArray(){
        return array.length;
    }

    public void fillArray() {
        array = new int[6];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(99) + 1;
        }
    }

    public String showArray(){
        StringBuilder cadena = new StringBuilder();
        for(int i = 0; i < array.length; i++){
            cadena.append(array[i]).append(" ");
        }
        return cadena.toString();
    }

    public void sort(int array[]) {
        int n = array.length ;

        // Se construye el MaxHeap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Se extraen uno a uno los elementos para ordenarlos.
        for (int i = n - 1; i > 0; i--) {
            // Intercambiamos la raíz por el último elemento.
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Volvemos a acomodar el MaxHeap
            heapify(array, i, 0);
        }
    }

    /**
     * Para apilar un subárbol con raíz en el nodo i que es
     * un indice de arr[]. n es el tamaño del heap.
     */

    void heapify(int arr[], int n, int i) {
        int largest = i; // Inicializamos la raíz como el más grande
        int l = 2 * i + 1; // hijo izquierdo = 2*i + 1
        int r = 2 * i + 2; // hijo derecho = 2*i + 2

        // Si el hijo izq es mayor que la raíz
        if (l < n && arr[l] > arr[largest])
            //se intercambia el índice del elemento mayor.
            largest = l;

        // si el hijo der es mayor que la raíz.
        if (r < n && arr[r] > arr[largest])
            //se intercambia el índice del elemento mayor.
            largest = r;

        // Si el elemento mayor no es la raíz.
        if (largest != i) {
            //Se intercambia el elemento de la raíz por el mayor.
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Se vuelve a acomodar el MaxHeap con la llamada Recursiva.
            heapify(arr, n, largest);
        }
    }
}

import java.util.Random;

public class Tester {
    public static void main(String[] args) {
        var sorting = new SortingAlgorithms();

        int [] array = fillArray(100);

        System.out.println("\n" + "-> Array Original: " +
                showArray(array) + "\n");

        System.out.println("\n" + "-> Inserción: " +
                showArray(sorting.insertionSort(array.clone())) + "\n");

        System.out.println("\n" + "-> Selección: " +
                showArray(sorting.selectionSort(array.clone())) + "\n");

        System.out.println("\n" + "-> Shell: " +
                showArray(sorting.shellSort(array.clone())) + "\n");

        System.out.println("\n" + "-> Quicksort: " +
                showArray(sorting.quicksort(array.clone())) + "\n");
    }

    public static int[] fillArray(int randNum) {
        int [] array = new int[8];
        Random rnd = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(randNum) + 1;
        }
        return array;
    }

    public static String showArray(int[] array){
        var cadena = " ";
        for(int i = 0; i < array.length; i++)
            cadena += array[i] + " - ";
        return cadena.substring(0, cadena.length() - 3);
    }
}

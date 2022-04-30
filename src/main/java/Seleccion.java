import java.util.Random;

public class Seleccion {
    int[] array = {89,45,1,17,55,65,32,75,22,15};
    public Seleccion() {
        //fillArray();
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

    public void sort(int[] array){
        int less; // índice del elemento más pequeño

        // itera a través de datos.length - 1 elementos
        for ( int i = 0; i < array.length - 1; i++ ) {
            less = array[i]; // primer índice del resto del arreglo
            int temp = i;
            // itera para buscar el índice del elemento más pequeño
            for ( int index = i + 1; index < array.length; index++ ) {
                System.out.println(array[index] + " - " + less);
                if ( array[index] < less ) {
                    less = array[index];
                    temp = index;
                }
            }
            // intercambia el elemento más pequeño en la posición
            array[temp] = array[i];
            array[i] = less;
        }
    }

    public void fillArray() {
        array = new int[15];
        Random rnd = new Random();
        for (int i = 0; i < 15; i++) {
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

}

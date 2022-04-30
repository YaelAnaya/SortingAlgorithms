import java.util.Random;

public class Insercion {
    int [] array;

    public Insercion() {
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

    public void sort(int[] array){
        int j, aux;
        for (int i = 1; i < array.length; i++){
            /* indice j es para explorar la sublista a[i-1]..a[0]
               buscando la posicion correcta del elemento destino */
            j = i;
            aux = array[i] ;
            // se localiza el punto de inserción explorando hacia abajo.
            while (j > 0 && aux < array[j - 1]) {
                // desplazar elementos hacia arriba para hacer espacio
                array[j] = array[j - 1];
                j--;
            }
            array[j] = aux;
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
        for(int i = 0; i < 15; i++){
            cadena.append(array[i]).append(" ");
        }
        return cadena.toString();
    }
}

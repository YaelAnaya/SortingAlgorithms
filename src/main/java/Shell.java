import java.util.Random;

public class Shell {
    int[] array = {65,12,75,18,25,1,17,55,22,15};

    public Shell() {
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

    public void sort(int[] array) {
        int inter, i, aux;
        boolean band;
        inter = array.length + 1;
        while (inter > 1) {
            inter /=  2;
            band = true;
            while (band) {
                band = false;
                i = 0;
                while ((i + inter) <= array.length - 1) {
                    if (array[i] > array[i + inter]) {
                        aux = array[i];
                        array[i] = array[i + inter];
                        array[i + inter] = aux;
                        band = true;
                    }
                    i++;
                }
            }
        }
    }

    public void fillArray() {
        array = new int[15];
        Random rnd = new Random();
        for (int i = 0; i < 15; i++) {
            array[i] = rnd.nextInt(99) + 1;
        }
    }

    public String showArray(int[] array){
        var cadena = " ";
        for(int i = 0; i < array.length; i++)
            cadena += array[i] + " ";

        return cadena;
    }
}

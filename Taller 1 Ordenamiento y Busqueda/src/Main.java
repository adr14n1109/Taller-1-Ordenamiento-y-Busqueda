public class Main {
    public static void main(String[] args) {
        MisAlgoritmos misAlgoritmos = new MisAlgoritmos();
        int[] array = {70, 12, 19, 45, 11, 33, 26};

        //LinearSearch
        int indice = misAlgoritmos.linearSearch(array, 12);
        System.out.println("El elemento 12 esta en la posición: " + indice);

        //BinarySearch
        int resultado = misAlgoritmos.binarySearch(array, 45);
        System.out.println("El elemento 45 esta en la posicion: " + resultado);

        //BubbleSort
        int[] arrayOrdenado = misAlgoritmos.bubbleSort(array);
        System.out.println("Array ordenado (BubbleSort): ");
        for (int numero : arrayOrdenado) {
            System.out.print(numero + " ");
        }
        System.out.println();

        //SelectionSort
        int[] resul = misAlgoritmos.selectionSort(array);
        System.out.println("Array ordenado (SelectionSort): ");
        for (int numero : resul){
            System.out.println(numero + " ");
        }

        //InsertionSort
        int[] nuevoArray = misAlgoritmos.insertionSort(array);
        System.out.println("Array ordenado (InsertionSort): ");
        for (int num : nuevoArray) {
            System.out.println(num + " ");
        }

        //MergeSort
        int[] resultadoNuevo = misAlgoritmos.insertionSort(array);
        System.out.println("Array ordenado (MergeSort): ");
        for (int num : resultadoNuevo) {
            System.out.println(num + " ");
        }

        //QuickSort
        int[] lista = misAlgoritmos.insertionSort(array);
        System.out.println("Array ordenado (QuickSort): ");
        for (int num : lista) {
            System.out.println(num + " ");
        }
    }
}

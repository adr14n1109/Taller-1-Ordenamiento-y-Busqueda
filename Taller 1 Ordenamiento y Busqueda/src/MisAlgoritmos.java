public class MisAlgoritmos implements Ordenamientos, Busquedas  {
    @Override
    public int linearSearch(int[] arrayPorExplorar, int elementoABuscar) {
        for (int i = 0; i < arrayPorExplorar.length; i++) {
            if (arrayPorExplorar[i] == elementoABuscar) {
                return i;
            }

        }
        return -1;
    }

    @Override
    public int binarySearch(int[] arrayPorExplorar, int elementoABuscar) {

        ordenar(arrayPorExplorar);

        int inicio = 0;
        int fin = arrayPorExplorar.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arrayPorExplorar[medio] == elementoABuscar) {
                return medio;
            }

            if (arrayPorExplorar[medio] < elementoABuscar) {
                    inicio = medio + 1;
            } else {
                    fin = medio - 1;
            }
        }

        return -1;
    }

    private void ordenar(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int[] bubbleSort(int[] arrayDesordenado) {
        int[] array = arrayDesordenado.clone();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]){
                    int temporal = array[j];
                    array[j] = array [j + 1];
                    array[j + 1] = temporal;
                }

            }

        }
        return array;
    }

    @Override
    public int[] selectionSort(int[] arrayDesordenado) {
        int n = arrayDesordenado.length;
        int[] arrayOrdenado = arrayDesordenado.clone();

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < n; j++) {
                if (arrayOrdenado[j] < arrayOrdenado[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                int temp = arrayOrdenado[i];
                arrayOrdenado[i] = arrayOrdenado[indiceMenor];
                arrayOrdenado[indiceMenor] = temp;
            }
        }
        return arrayOrdenado;
    }

    @Override
    public int[] insertionSort(int[] arrayDesordenado) {
        int n = arrayDesordenado.length;
        int[] arrayOrdenado = arrayDesordenado.clone();

        for (int i = 1; i < n; i++) {
            int actual = arrayOrdenado[i];
            int j = i - 1;

            while (j >= 0 && arrayOrdenado[j] > actual) {
                arrayOrdenado[j + 1] = arrayOrdenado[j];
                j--;
            }

            arrayOrdenado[j + 1] = actual;
        }

        return arrayOrdenado;
    }

    @Override
    public int[] mergeSort(int[] arrayDesordenado) {
        int[] arrayOrdenado = arrayDesordenado.clone();

        if (arrayOrdenado.length > 1) {
            dividir(arrayOrdenado, 0, arrayOrdenado.length - 1);
        }
        return arrayOrdenado;
    }

    private void dividir(int[] array, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;

            dividir(array, inicio, medio);
            dividir(array, medio + 1, fin);

            mezclar(array, inicio, medio, fin);
        }
    }

    private void mezclar(int[] array, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        int[] izquierda = new int[n1];
        int[] derecha = new int[n2];

        System.arraycopy(array, inicio, izquierda, 0, n1);
        System.arraycopy(array, medio + 1, derecha, 0, n2);

        int i = 0, j = 0, k = inicio;

        while (i < n1 && j < n2) {
            if (izquierda[i] <= derecha[j]) {
                array[k] = izquierda[i];
                i++;
            } else {
                array[k] = derecha[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = izquierda[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = derecha[j];
            j++;
            k++;
        }
    }

    @Override
    public int[] quickSort(int[] arrayDesordenado) {
        int[] arrayOrdenado = arrayDesordenado.clone();

        if (arrayOrdenado.length > 1) {
            ordenar(arrayOrdenado, 0, arrayOrdenado.length - 1);
        }

        return arrayOrdenado;
    }

    private void ordenar(int[] array, int inicio, int fin) {
        if (inicio < fin) {

            int posicionPivote = particionar(array, inicio, fin);

            ordenar(array, inicio, posicionPivote - 1);
            ordenar(array, posicionPivote + 1, fin);
        }
    }

    private int particionar(int[] array, int inicio, int fin) {
        int pivote = array[fin];
        int i = inicio - 1;

        for (int j = inicio; j < fin; j++) {
            if (array[j] <= pivote) {
                i++;
                intercambiar(array, i, j);
            }
        }

        intercambiar(array, i + 1, fin);

        return i + 1;
    }

    private void intercambiar(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

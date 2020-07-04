public class Sorter {

    public void selectionSort(int[] arr, boolean desc){
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < length; j++) {
                if(desc){
                    if (arr[j] > arr[minIdx]) {
                        minIdx = j;
                    }
                }else {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
            }

            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }
    //TODO: Czy da sie zamienic 2 liczby miejscami bez 3 zmiennej
}

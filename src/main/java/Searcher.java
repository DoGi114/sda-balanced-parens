import java.math.BigDecimal;

public class Searcher<T extends Comparable<T>>  {
    public int BinarySearch(int[] arr, int search){
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;
            int value = arr[mid];
            if(value == search){
                return mid;
            }else if(value > search){
                high = mid;
            }else{
                low = mid;
            }
        }
        return -1;
    }

    public int GenericBinarySearch(T[] arr, T search){
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;
            T value = arr[mid];
            if(value.compareTo(search) == 0){
                return mid;
            }else if(value.compareTo(search) > 0){
                high = mid;
            }else{
                low = mid;
            }
        }
        return -1;
    }
}

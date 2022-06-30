class Sort{
    /*/ Bubble Sort
    /// WORST and Average Case Time Complexity: O(n * n)
    /// BEST Case TIme Complexity             : O(n) (for Sorted Array)    
    /// Auxiliary Space                       : O(1) (Stable Sorting)
    /*/ 
    public static void bubbleSort(int array[]){
        for(int i=0 ; i<array.length-1;++i){
            boolean swapping = false;
            for(int j= i+1; j<array.length ; ++j){
                if(array[i] > array[j]){
                    int temp = array[i] ;
                    array[i] = array[j] ;
                    array[j] = temp ;
                    swapping = true ;
                }
            }
            if(!swapping) 
                break ;
        }
    }

    /*/ Quick Sort
    /// T(n) = T(k) + T(n - k - 1) + O(n)
    /// WORST Case  : O(n * n)     when array is increasing or decreasing and 
    ///               partition always selects smallest or greatest element.
    ///               T(n) = T(0) +  T(n - 1) + O(n)
    /// BEST Case   : O(n * logn ) when array is partition at middle element.
    ///             : T(n) = 2T * O(n / 2) + O(n)
    /*/
    public static void quickSort(int array[] , int low , int high){
        if(low < high){
            int mid = partition(array , low , high ) ;
            quickSort(array , low , mid - 1 );
            quickSort(array , mid + 1 , high);
        }
    }
    private static int partition(int array[] , int low , int high){
        int pivot = array[high] ;
        int i = low  ;
        for(int j = low ; j < high ; ++j){
            if(array[j] < pivot ){
                int temp = array[i] ; 
                array[i] = array[j] ;
                array[j] = temp     ;
                ++i ;
            }
        }
        int temp = array[i] ;
        array[i] = array[high] ;
        array[high] = temp ;
        return i ; 
    }

    /*/Merge Sort
    ///T(n) = 2T(n / 2) + ⊖(n)
    ///WORST CASE : O(n * logn)
    ///BEST  CASE : O(n * logn)
    ///Stable Sorting
    /*/
    public static void mergeSort(int array[] , int low , int high){
        if(low < high){
            int mid = low + (high - low) / 2 ;
            mergeSort(array , low     , mid );
            mergeSort(array , mid + 1 , high);
            merge(array , low , mid  ,  high);
        }
    }
    private static void merge(int array[] , int low , int mid , int high){
        int leftLen = mid - low + 1 ;
        int rightLen= high- mid     ;
        int left [] = new int[leftLen]  ;
        int right[] = new int[rightLen] ;
        for(int i = 0 ; i < leftLen ; ++i){
            left[i] = array[low + i];
        }
        for(int i = 0 ; i < rightLen ; ++i){
            right[i]= array[(mid + 1) + i];
        }
        int ptrL = 0 , ptrR = 0 ;
        while(ptrL < leftLen && ptrR < rightLen ){
            if(left[ptrL] <= right[ptrR]){
                array[low++] = left[ptrL++];
            }
            else{
                array[low++] = right[ptrR++];
            }
        }
        while(ptrL < leftLen){
            array[low++] = left[ptrL++];
        }
        while(ptrR < rightLen){
            array[low++] = right[ptrR++];
        }
    }

}
class Display{
    public static void printArray(int array[]){
        for(int i = 0 ; i < array.length; ++i){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}     
class Mains{
    public static void main(String args[]){
        int array[] = {5 , 3 , 2 , 1 , 4};
        Display.printArray(array);
        Sort.mergeSort(array , 0 , 4 );
        Display.printArray(array);
    }
} 
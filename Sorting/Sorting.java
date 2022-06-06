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

    /*/ QuickSort
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
        int array[] = {5 , 3 ,4 ,2 , 1};
        Display.printArray(array);
        Sort.quickSort(array , 0 , 4 );
        Display.printArray(array);
    }
} 
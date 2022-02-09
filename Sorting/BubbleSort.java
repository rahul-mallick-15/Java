import java.io.*;
class Sort{
    /*/ WORST and Average Case Time Complexity: O(n * n)
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
        Sort.bubbleSort(array);
        Display.printArray(array);
    }
} 
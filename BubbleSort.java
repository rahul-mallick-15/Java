import java.io.*;
class Sort{
    void bubbleSort(int array[]){
        for(int i=0 ; i<array.length-1;++i){
            for(int j= i+1; j<array.length ; ++j){
                if(array[i] > array[j]){
                    array[i]+=array[j];
                    array[j]=array[i]-array[j];
                    array[i]-=array[j];
                }
            }
        }
    }
}     
class Mains{
    public static void main(String args[]){
        int array[] = {5 , 3 ,4 ,2 , 1};
        for(int element:array){
            System.out.print(element+ " ");
        }
        System.out.println();
        (new Sort()).bubbleSort(array);
        for(int element:array){
            System.out.print(element+ " ");
        }
    }
} 
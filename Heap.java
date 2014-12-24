
import java.util.Scanner;
 
/* Class HeapSort */
public class Heap
{    
    public  int N;
    public int size;
    public int arr[];
    public int []d;
    public Heap(int n , int []d) {
		N=n;
		size=0;
		int i;
		this.d=d;
		arr = new int[N];
		for(i=0;i<n;i++)
			arr[i]=i;
	//	heapify();
	}

	

	/* Sort Function */
    public  void sort()
    {       
        heapify();  
        int i;
//        for (int i = N-1; i >= 0; i--)
//        { 	
//            swap(0, i);
//            N = N-1;
//            maxheap(0);
//        }
//        N=size;
//        int i;
        
        for (i = 0; i < size; i++)
        {
            System.out.print(arr[i]+" ");   
        }    
        System.out.println();  
    }     
    
    public int minimum()
    {
    	return arr[0];
    }
    
    public void insert(int val)
    {
    	arr[size]=val;
    	size=size+1;
    //	heapify();
    }
    public void delete()
    {
    	
    	swap(0,(size-1));
    	size=size-1;
    //	maxheap(0);
    }
    /* Function to build a heap */   
    public void heapify()
    {
    	if(size==1 || size==0)
    		return;
        for (int i = (size-2)/2; i >= 0; --i)
            maxheap(i);    
    }
    
    
    /* Function to swap largest element in heap */        
    public void maxheap(int i)
    { 
        int left = 2*i+1 ;
        int right = 2*i + 2;
        int max = i;
        if (left < size && d[arr[left]] > d[arr[i]])
            max = left;
        if (right < size && d[arr[right]] > d[arr[max]])        
            max = right;
 
        if (max != i)
        {
            swap(i, max);
            maxheap(max);
        }
    }    
    /* Function to swap two numbers in an array */
    public  void swap(int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp; 
    }    
    /* Main method */
    public static void main(String[] args) 
    {      

         int i,n = 10;
        int arr[] = new int[ n ];
       
        for (i = 0; i < n; i++)
        {
        	int t = 1 + (int)(Math.random()*(100)); 
        	arr[i] = t;
            
        }
        
        
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");            
        System.out.println(); 
        
        //Heap h = new Heap(n);
        
   //     h.sort();
 
        
//
 
//        
//        System.out.println(h.minimum());
//         h.delete();
//         System.out.println(h.minimum());	
//         h.delete();
//         System.out.println(h.minimum());
//         h.insert(1);
//         h.delete();
//         h.delete();
//       //  h.insert(1);
//         System.out.println(h.minimum());
         
       //  h.sort();
      //  System.out.println(h.minimum());
      //  h.sort();
//        h.delete(arr);
//        System.out.println(h.minimum(arr));
//        h.delete(arr);
//        System.out.println(h.minimum(arr));
//        h.delete(arr);
//        System.out.println(h.minimum(arr));
    }    
}
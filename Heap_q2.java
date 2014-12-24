

import java.util.Scanner;
 
/* Class HeapSort */
public class Heap_q2
{    
    public  int N;
    public int size;
    public int arr[];
    public int []d;
    public Heap_q2(int n) {
		N=n;
		size=0;
		int i;
		arr = new int[N];
		for(i=0;i<n;i++)
			{
			    int t = 1 + (int)(Math.random()*(100)); 
				arr[i]=t;
			}
		  System.out.println("Array");
		for(i=0 ;i<n ;i++)
		{
			System.out.print(arr[i]+" ");
		}
		size=n;
		heapify();
		
//		System.out.println();
//		for(i=0 ;i<n ;i++)
//		{
//			System.out.print(arr[i]+" ");
//		}
		
	}

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
    	if(size==N)
    	{
    		System.out.println("Heap full , Cannot insert , returning back.....");
    		return;
    	}
    	arr[size]=val;
    	size=size+1;
    	heapify();
    }
    public void delete()
    {
    	
    	swap(0,(size-1));
    	size=size-1;
    	maxheap(0);
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
        if (left < size && arr[left] < arr[i])
            max = left;
        if (right < size && arr[right] < arr[max])        
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

         int i,n;
 
        Scanner in = new Scanner(System.in);
	    System.out.println("Enter the size of array ");
	      n = in.nextInt();
	       int arr[] = new int[ n];
        
	      Heap_q2 h = new Heap_q2(n);

	      int t;
	      System.out.println();
	      System.out.println("1--> printing Minimum Value");
	      System.out.println("2--> Inserting Value");
	      System.out.println("3--> Deleting Value");
	      System.out.println("4--> Exit");
	      while(true){
	    	  System.out.println("Enter Choice ");
	    	   t = in.nextInt();
	       switch(t) {
	       case 1: System.out.println("Printing Minimum value");
	       			System.out.println(h.minimum());
	       			break;
	       case 2 : System.out.println("Inserting Value");
	       			System.out.println("Enter Value to  insert ");
	       			n = in.nextInt();
	       			h.insert(n);
	       			break;
	       case 3:  System.out.println("Deleting  value");
	       			h.delete();
	       			break;
	       case 4 : return;
	       }
	      }

    }    
}
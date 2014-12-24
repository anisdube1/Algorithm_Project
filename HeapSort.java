
import java.util.ArrayList;
import java.util.Scanner;
 
/* Class HeapSort */
public class HeapSort
{    
    public  int N;
    public int size;
    public int arr[];
    public int []d;
    public ArrayList<Edge_full> e;
    public ArrayList<Edge_full> ehr;
    
//    public HeapSort(int n , int []d) {
//		N=n;
//		size=0;
//		int i;
//		this.d=d;
//		arr = new int[N];
//		for(i=0;i<n;i++)
//			arr[i]=i;
//	//	heapify();
//	}
    
    public HeapSort(ArrayList e)
    {
    //	e =  new ArrayList<Edge_full>();
    	this.e=e;
//    	for(int i=0 ; i <e.size() ; i++)
//    	{
//    		eh.set(i,(Edge_full) e.get(i) );
//    	}
//		for(int i=0;i<n;i++)
//		arr[i]=eh.get(i);
    	N=e.size();
    	
    	size=N;
    	
     }

	

	/* Sort Function */
    public  void sort()
    {       
        heapify();  
        for (int i = N-1; i >= 0; i--)
        { 	
            swap(0, i);
             N = N-1;
            size=size-1;
            maxheap(0);
        }
        N=size;
        int i;

    }
    
   //Quick sort
    
   public int partition(ArrayList<Edge_full> e2, int left, int right)
    {
          int i = left, j = right;
          int tmp;
          Edge_full pivot = e2.get((left + right)/2); 
        //  Edge_full pivot = e2[(left + right)/2];
         
          while (i <= j) {
        	  while(e2.get(i).cost > pivot.cost)
             //   while (e2[i].cost < pivot.cost)
                      i++;
                while (e2.get(j).cost < pivot.cost)
                      j--;
                if (i <= j) {
                	swap(i,j);
//                      tmp = arr[i];
//                      arr[i] = arr[j];
//                      arr[j] = tmp;
                      i++;
                      j--;
                }
          }
         
          return i;
    }
     
    public void quickSort(int left, int right) {
          int index = partition(e, left, right);
          if (left < index - 1)
                quickSort(left, index - 1);
          if (index < right)
                quickSort(index, right);
    }
    
    //////////////////////////////////////////////////////////////
    
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
        if (left < size && e.get(left).cost < e.get(i).cost)
            max = left;
        if (right < size && e.get(right).cost < e.get(max).cost)        
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
        Edge_full tmp = e.get(i);
        e.set(i, e.get(j));
        e.set(j , tmp);
        
        
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
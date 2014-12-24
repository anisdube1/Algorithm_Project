
import java.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;



public class max_path_array { 
      public static int [] dijkstra ( Graph G, int s) {
         final int [] dist = new int [G.size()];  
         final LinkedList<Integer> fringe = new LinkedList<Integer>();
         final char[] status = new char [G.size()];
         final int [] pred = new int [G.size()];  
         final boolean [] visited = new boolean [G.size()]; 
   
         for (int i=0; i<dist.length; i++) {
        	 	dist[i] = Integer.MIN_VALUE;
     		}	
         
         for(int i=0 ; i <G.size();i++)
         {
        	 status[i]='u';
        	 pred[i]=-1;
         }
         ArrayList adj_v= G.getVertex(s).getadj();
         ArrayList adj_n= G.getVertex(s).getadj_number();
         
       for (int j=0; j<adj_v.size(); j++) {
         final int v = (int) adj_n.get(j);
         Edge e1 = (Edge) adj_v.get(j);   
         dist[v] = (int) e1.getcost();
         fringe.add(new Integer (v));
         pred[v]=s;
         status[v]='f';
       }
       status[s]='i';
       
       long start =0 , end =0 , diff=0;
       while(!fringe.isEmpty())
       {
    	   start = System.currentTimeMillis( );
    	     Integer temp = fringe.element();
    	     for(Integer i : fringe)
    	     {
    	    	 if (dist[i] > dist[temp])
    	    	 {
    	    		 temp =i;
    	    	 }
    	     }
    	     fringe.remove(temp);
    	     end = System.currentTimeMillis( );
    	     diff+=(end-start);
    	     status[temp] = 'i';
    	     
    	     ArrayList adj_v1= G.getVertex(temp).getadj();
    	     ArrayList adj_n1= G.getVertex(temp).getadj_number();
    	     ArrayList adj_c1= G.getVertex(temp).getcostarray();
    	     
    	     
    	       for(int i=0 ; i <adj_v1.size() ; i++)
    	       {
    	    	   Edge e1 = (Edge) adj_v1.get(i);
    	    	   int dest = e1.getdestvertexnumber();
    	    	   int edge_wt = (int) e1.cost;
    	    	   if(status[dest] == 'u')
    	    	   {
    	    		   status[dest]='f';
    	    		   dist[dest]=minimum(dist[temp] , edge_wt);
    	    		   pred[dest]=temp;
    	    		   fringe.add(new Integer (dest));
    	    	   }
    	    	   else if (status[dest]=='f' && (dist[dest]<minimum(dist[temp], edge_wt)))
    	    	   {
    	    		   dist[dest]= minimum(dist[temp], edge_wt);
    	    		   pred[dest]=temp;
    	    	
    	    	   }
    	       }     
       }
    //   System.out.println("pollig only"+diff);
     return pred; 
   }
      
      public static int minimum(int a , int b)
      {
    	  if(a>b)
    		  return b;
    	  else
    		  return a;
      }
         public static int maxof(int[] dist)
         {
        	 int max = Integer.MIN_VALUE;
        	 int index=-1;
        	 for(int i=0 ; i<dist.length;i++)
        	 {
        		 if(max<dist[i])
        		 {
        			 max=dist[i];
        			 index =i;
        		 }
        	 }
        	 return index;
         }
      public static int minimum(int a ,double d)
      {
    	  if(a>d)
    		  return (int) d;
    	  else
    		  return a;
    				 
      }
      
      
public static int[] heapdijsktra_path(Graph G , int s) {
   final int [] dist = new int [G.size()];  
   final char[] status = new char [G.size()];
   final int [] pred = new int [G.size()];  
   final boolean [] visited = new boolean [G.size()]; 
   
   long start=0 , end =0;
   
   Comparator<Integer> comparator = new CostComparator1(dist);
   PriorityQueue<Integer> vertexQueue = new PriorityQueue<Integer>(5000 , comparator);

   for (int i=0; i<dist.length; i++) {
  	 	dist[i] = Integer.MIN_VALUE;
		}	
   
   for(int i=0 ; i <G.size();i++)
   {
  	 status[i]='u';
  	 pred[i]=-1;
   }
   
   ArrayList adj_v= G.getVertex(s).getadj();
   
   ArrayList adj_n= G.getVertex(s).getadj_number();
   
   start = System.currentTimeMillis( );
   
 for (int j=0; j<adj_v.size(); j++) {
   final int v = (int) adj_n.get(j);
   Edge e1 = (Edge) adj_v.get(j);   
   dist[v] = (int) e1.getcost();
   vertexQueue.add(v);
   pred[v]=s;
   status[v]='f';
 }
 status[s]='i';
 
 end = System.currentTimeMillis( );
 start = System.currentTimeMillis( );
 long diff=0 , cou=0 , diff1=0;
 while(!vertexQueue.isEmpty())
 {
	 
	 Integer temp = vertexQueue.poll();
	 
	 
	     status[temp] = 'i';
	     
	     ArrayList adj_v1= G.getVertex(temp).getadj();
	     
	       for(int i=0 ; i <adj_v1.size() ; i++)
	       {
	    	   Edge e1 = (Edge) adj_v1.get(i);
	    	   int dest = e1.getdestvertexnumber();
	    	   int edge_wt =  e1.cost;
	    	   if(status[dest] == 'u')
	    	   {
	    		   status[dest]='f';
	    		   dist[dest]=Math.min(dist[temp] , edge_wt);
	    		   pred[dest]=temp;
	    		   start = System.currentTimeMillis( );
	    		   vertexQueue.add(new Integer (dest));
	    		   end = System.currentTimeMillis( );
	    		   diff1+=(end-start);
	    	   }
	    	    
	    	   else if (status[dest]=='f' && (dist[dest]<Math.min(dist[temp], edge_wt)))
	    	   {
	    		   dist[dest]= Math.min(dist[temp], edge_wt);
	    		   pred[dest]=temp;
	    		   start = System.currentTimeMillis( );
	    		   vertexQueue.remove(dest);
	    		//   vertexQueue.add(new Integer (dest));
	    		   vertexQueue.add(dest);
	    		   end = System.currentTimeMillis( );
	    		   diff+= (end-start);
	    	   }
	       }     
 }
return pred; 
  }
   
   public static int[] heapdijsktra_path_my_heap(Graph G , int s) {
// 	
// 
final int [] dist = new int [G.size()];  
final char[] status = new char [G.size()];
final int [] pred = new int [G.size()];  
final boolean [] visited = new boolean [G.size()]; 

long start=0 , end =0;

//Comparator<Integer> comparator = new CostComparator2(dist);
//PriorityQueue<Integer> vertexQueue = new PriorityQueue<Integer>(1 , comparator);

Heap h = new Heap(5000 ,dist);


for (int i=0; i<dist.length; i++) {
	dist[i] = Integer.MIN_VALUE;
}	

for(int i=0 ; i <G.size();i++)
{
status[i]='u';
pred[i]=-1;
}

ArrayList adj_v= G.getVertex(s).getadj();

ArrayList adj_n= G.getVertex(s).getadj_number();

start = System.currentTimeMillis( );

for (int j=0; j<adj_v.size(); j++) {
final int v = (int) adj_n.get(j);
Edge e1 = (Edge) adj_v.get(j);   
dist[v] = (int) e1.getcost();
//  vertexQueue.add(v);
//System.out.println("Hello");
h.insert(v);
pred[v]=s;
status[v]='f';
}
//h.sort();
status[s]='i';

end = System.currentTimeMillis( );
start = System.currentTimeMillis( );
long diff=0 , cou=0;
while(!(h.size==0))
{

// Integer temp = vertexQueue.poll();
h.heapify();
int temp =h.minimum();
h.delete();
status[temp] = 'i';

ArrayList adj_v1= G.getVertex(temp).getadj();

  for(int i=0 ; i <adj_v1.size() ; i++)
  {
	   Edge e1 = (Edge) adj_v1.get(i);
	   int dest = e1.getdestvertexnumber();
	   int edge_wt =  e1.cost;
	   if(status[dest] == 'u')
	   {
		//   System.out.println("Hello1");
		   status[dest]='f';
		   dist[dest]=Math.min(dist[temp] , edge_wt);
		   pred[dest]=temp;
		//   vertexQueue.add(new Integer (dest));
		   h.insert(dest);

	   }
	   else if (status[dest]=='f' && (dist[dest]<Math.min(dist[temp], edge_wt)))
	   {
		 //  System.out.println("Hello2");
		   dist[dest]= Math.min(dist[temp], edge_wt);
		   pred[dest]=temp;
		   //h.delete(dest);
		  // vertexQueue.remove(dest);
		  // vertexQueue.add(new Integer (dest));
		   start = System.currentTimeMillis( );
		 //  h.heapify();
		   end = System.currentTimeMillis( );
		   diff = diff+(end-start);
	   }
  }     
}

return pred; 
}   
  	   

  
     public static void printPath (Graph g, int [] dad, int src, int dst) {
    	 int cost_max=10000000;
  	   System.out.print(dst+"-->");
  	   while(dad[dst]!=src)
  	   {
  		   
  		 int rand=0;  		  
  		   Vertex vi=g.getVertex(dst);
  		   ArrayList via = vi.getadj();
  		   for(int q=0 ; q<via.size();q++)
  		   {
  			   Edge e1 =(Edge) via.get(q);
  			   if(e1.getdestvertexnumber()==dad[dst])
  			   {
  				 rand=e1.cost;
  				  if(e1.cost<cost_max)
  				  {
  					  cost_max=e1.cost;
  				  }
  			   }
  		   }
  		   
  		  System.out.print(dad[dst]+"("+rand+")"+"-->");
  		   dst=dad[dst];
  		   
  	   }
  	   
  	 
	   Vertex vi1=g.getVertex(dst);
	   ArrayList via1 = vi1.getadj();
	   for(int q=0 ; q<via1.size();q++)
	   {
		   Edge e1 =(Edge) via1.get(q);
		   if(e1.getdestvertexnumber()==dad[dst])
		   {
			   if(e1.cost<cost_max)
			   {
				   cost_max=e1.cost;
			   }
		   }
	   }
	   
	   
  	   System.out.println(src);
  	   System.out.println("Maximum flow capacity is "+cost_max);
    	 
    	 
     }
     
     public static void main(String[] args) 
     	{
    	    int vertices , degree , src, dst;
    	    vertices =5000;
    	    Scanner in = new Scanner(System.in);

    	     
    	      System.out.println("Enter the number of degrees  you want the code to run (6/1000) ");
    	      degree = in.nextInt();  
    	      

    	
    	      for(int r=0 ; r <5 ; r++)
    	      {
    	    	
    	      
    	  	Graph g = new Graph(vertices ,degree);
    		 g.create_graph();
    		 
    	
    		
    		for(int r1=0 ; r1< 5 ; r1++)
    		{
     	    	  System.out.println();
    			System.out.println("For Graph :"+(r+1));
    			System.out.println("Maximum Capacity Path for "+(r1+1)+" iteration for below source and destination vertex");
    			  src = (int)(Math.random()*(4999)); 
    	    	  dst  =(int)(Math.random()*(4999)); 
    	    	  
    	    	  System.out.println();
    	    	  System.out.println("For source : "+src);
    	    	  System.out.println("For destination  : "+dst);
    	    	  
//    	    		for(int y = src ; y <dst ; y++)
//    	    		{
//    	    			int p = 1 + (int)(Math.random()*(1000)); 
//    	    			g.addEdge(y, y+1, p);
//    	    			g.addEdge(y+1 ,y ,p);
//    	    		}
    	    	  
    		System.out.println();
    		 long start = System.currentTimeMillis( );
    		int []pre =  dijkstra(g,src);
    		 long end = System.currentTimeMillis( );
    		long diff = end - start;
    		 System.out.println("############################################################################");
    		System.out.println("Path printing Maximum flow path without using heap :");
    		 printPath(g,pre , src , dst);
    		System.out.println("Execution of Maximum flow path without using heap : " + diff+"ms");
            System.out.println("############################################################################");
//    		 System.out.println();
//             start = System.currentTimeMillis( );
//    		int []pre_heap= heapdijsktra_path(g,src);	
//   		    end = System.currentTimeMillis( );
//   		   System.out.println("Path printing Maximum flow path with using priority_heap:");
//   		    printPath(g,pre_heap , src , dst);
//   		    diff = end - start;
//   		 System.out.println("Execution of Maximum flow path  using heap : " + diff+"ms");
//   		 System.out.println("############################################################################");
   		   
   		System.out.println();
   		 	start = System.currentTimeMillis( );
   		 	int []pre_heap2= heapdijsktra_path_my_heap(g,src);	
		    end = System.currentTimeMillis( );
		   System.out.println("Path printing Maximum flow path with using my own implemented heap:");
		    printPath(g,pre_heap2 , src , dst);
		    diff = end - start;
		 System.out.println("Execution of Maximum flow path  using own implemented heap : " + diff+"ms");
		 System.out.println("############################################################################");
            System.out.println();
            
            System.out.println("Path printing Maximum flow path using kruskal "); 
   		   kruskal kr = new kruskal(g);
   		start = System.currentTimeMillis( );
     	   kr.add_value_in_heap();
     	//  end = System.currentTimeMillis( );
        //   start = System.currentTimeMillis( );
   		   kr.scan();
   		   end = System.currentTimeMillis( );
   		diff=end-start;
   		start = System.currentTimeMillis( );
   		  kr.create_graph(src,dst);
   		int diff2= (int) (end-start);
   	   		System.out.println("Execution of Maximum flow path  using kruskal  : " + diff+"ms");
   	 System.out.println("############################################################################");
   	 System.out.println("<-------------------------------------------------------------------------------------------------------------------------------------------------------->");
    		    }
    	    }		
     	} 	      
 
}

class CostComparator1 implements Comparator<Integer>
{
	int [] dist;
	public CostComparator1(int[] dist)
	{
		this.dist = dist;
		
	}
    @Override
    public int compare(Integer x, Integer y)
    {
        if (dist[x] > dist[y])
        {
            return -1;
        }
        if (dist[x] < dist[y])
        {
            return 1;
        }
        return 0;
    }
}

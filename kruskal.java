
import java.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class kruskal {
	
	 Comparator<Edge_full> comparator = new CostComparator();
	PriorityQueue<Edge_full> vertexQueue = new PriorityQueue<Edge_full>(5000*1000,comparator);
	ArrayList<Edge_full> edge_obj_ll = new ArrayList();
	ArrayList edge_obj_store = new ArrayList();
	 Graph g;
	 int vertices , degrees;
	 int []parrent ;
	 int []rank;
	 Graph gk ;
	 boolean []visit;
	 HeapSort h ;
     Stack st = new Stack();

   public kruskal(Graph g) {
	   		 gk = new Graph(g.size(), 2);
			edge_obj_ll= g.getedge_full();
			parrent = new int[g.size()];
			rank = new int[g.size()];
			visit = new boolean[g.size()];
			
			for(int i=0 ; i <g.size() ; i++)
				{
				parrent[i]=-1;
				rank[i]=0;
				}
			h = new HeapSort(edge_obj_ll);
			
		}
//	public void add_value_in_heap()
//	 {
//		long start =0 , end=0 , diff=0;
//		start = System.currentTimeMillis();
//		 for (int i = 0; i < edge_obj_ll.size(); i++) {
//			 vertexQueue.add((Edge_full) edge_obj_ll.get(i));
//	        }
//		 end = System.currentTimeMillis( );
//		 diff=end-start;
//		 System.out.println("execution for adding value in heap  : " + diff+"ms");
//	 }
	
	public void add_value_in_heap()
	 {
		long start =0 , end=0 , diff=0;
		start = System.currentTimeMillis();
	
		//edge_obj_ll=h.sort();
		
		h.sort();
	//	h.quickSort(0, (edge_obj_ll.size()-1));
		
//		for(int q=0 ; q<edge_obj_ll.size() ; q++)
//			System.out.print(edge_obj_ll.get(q).cost+"->");
//		 System.out.println("");
		
		 end = System.currentTimeMillis( );
		 diff=end-start;
		// System.out.println("execution for adding value in heap  : " + diff+"ms");
	 }
	
	public void printheap()
	{
		 while (vertexQueue.size() != 0)
	        {
	            System.out.println(vertexQueue.remove().cost);
	        }
	}
	
	public int find(int src)
	{
		
//        Stack st = new Stack();
//		while(parrent[src]!=-1)
//		{
//			st.push(src);
//			src=parrent[src];
//		}
		
//		while(parrent[src]!=-1)
//		{
//			src=parrent[src];
//		}

		
		while(parrent[src]!=-1)
		{
			st.push(src);
			src=parrent[src];
		}
		
       while(!st.isEmpty())
       {
    	   int v =(int) st.pop();
    	   parrent[v]=src;
       }
//		
          return src;
	}
	
	

	
	
	public void union(int src , int dst)
	{
		int par1 = find(src);
		int par2 = find(dst);
		if(rank[par1]>rank[par2])
		{
			parrent[par2]=par1;
		}
		if(rank[par1]<rank[par2])
		{
			parrent[par1]=par2;
		}
		if(rank[par1]==rank[par2])
		{
			parrent[par1]=par2;
			rank[par2]++;
		}
	}

	
	public void scan()
	{
		double cost_edge ;
		int src_vertex , dst_vertex;
		long diff=0 , diff1=0;
		long start =0 , end=0 ;
		//while(edge_obj_ll.size()!=0)
		for(int k=0  ; k <edge_obj_ll.size() ; k++)
		{
			start = System.currentTimeMillis();
			Edge_full e = (Edge_full) edge_obj_ll.get(k);
			//Edge_full e = vertexQueue.remove();
			end = System.currentTimeMillis();
			diff+=(end-start);
			cost_edge=e.cost;
			src_vertex = e.src_vertex;
			dst_vertex = e.dst_vertex;
			start = System.currentTimeMillis();
			int t1 = find(src_vertex);
			int t2 = find(dst_vertex);
			end = System.currentTimeMillis( );
			diff1+=end-start;
			if(t1!=t2)
			{
				
				start = System.currentTimeMillis();
				union(src_vertex , dst_vertex);
				end = System.currentTimeMillis( );
				//diff+=(end-start);
				edge_obj_store.add(e);
				

			}
		}
	//	System.out.println("Remove time  : " + diff+"ms");
	//	System.out.println("Total union time is  : " + diff+"ms");
	}
	
	public void create_graph(int src , int dst)
	{
		for(int i =0 ; i <edge_obj_store.size() ; i++)
		{
			Edge_full e = (Edge_full) edge_obj_store.get(i);
			gk.addEdge(e.src_vertex , e.dst_vertex , e.cost);
			gk.addEdge(e.dst_vertex , e.src_vertex , e.cost);
			
		}
		dfs(src , dst);
    }
	
	public void dfs(int src , int dst)
	{
		int[] dad = {-1};
		dad = new int[gk.size()];
		int index =0;
		for(int i =0 ; i <gk.size() ; i++)
			visit[i]=false;
		for(int i=src; i <gk.size();i++)
		{
			if(!visit[i])
			{
				dfsutil(gk,i,visit ,dst ,dad);
			}
		}
		 int cost_max=1000000;
	   System.out.print(dst+"-->");
	   while(dad[dst]!=src)
	   {
		   int rand=0;
		  
		   Vertex vi=gk.getVertex(dst);
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
					  break;
				  }
			   }
		   }

		   
		   
		   System.out.print(dad[dst]+"("+rand+")"+"-->");
		   dst=dad[dst];
		   
	   }
	   
	   
	   Vertex vi1=gk.getVertex(dst);
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
	
	
	public void dfsutil(Graph gk , int i , boolean []visit ,int dst ,int[] dad)
	{
		visit[i] = true;
		Vertex vi=gk.getVertex(i);
		ArrayList via = vi.getadj();

		for(int p=0 ; p<via.size();p++)
		{
			Edge e=(Edge) via.get(p);
			int dst_vert = e.getdestvertexnumber();
			if(!visit[dst_vert])
			{
				dad[dst_vert]=vi.getnumber();
				dfsutil(gk ,dst_vert , visit ,dst ,dad);
			}
		}
	}
	
	public static void main(String[] args) {
	}

}
class CostComparator implements Comparator<Edge_full>
{
    @Override
    public int compare(Edge_full x, Edge_full y)
    {

        if (x.cost < y.cost)
        {
            return 1;
        }
        if (x.cost > y.cost)
        {
            return -1;
        }
        return 0;
    }
}

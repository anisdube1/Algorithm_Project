import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class Graph {
	
	public static final double INFINITY = Double.MAX_VALUE;
    private Map vertexMap = new HashMap( ); 
    private int vertices;
    private int degree;
   // public  LinkedList edge_full;
    public ArrayList edge_full;

    public Graph(int ver, int deg)
    {
    	vertices = ver;
    	degree = deg;
    	edge_full = new ArrayList();
    }
    public ArrayList getedge_full()
    {
    	return edge_full;
    }
    
    public int size()
    {
    	return vertices;
    }
    public void addEdge( Integer sourceName, Integer destName, Integer cost )
    {
        Vertex v = getVertex( sourceName );
        Vertex w = getVertex( destName );
        Edge e1 = new Edge(w,cost);
        Edge_full ef = new Edge_full(sourceName , destName , cost);
        edge_full.add(ef);
        v.adj.add( e1 );
        v.adj_number.add(e1.getdestvertexnumber());
        v.cost_of_edges.add(cost);
    }
    
    
    public  Vertex getVertex( Integer vertexName )
    {
        Vertex v = (Vertex) vertexMap.get( vertexName );
        if( v == null )
        {
            v = new Vertex( vertexName );
            vertexMap.put( vertexName, v );
        }
        return v;
    }
    
    
    
    

	
	
	
    public void create_graph()
    {
   	 Map<Integer , Integer > vertexCount = new HashMap<Integer, Integer>( ); 
	 int i;
	 for(i=0;i<vertices;i++)
	 {
		 vertexCount.put(i,0);
	 }
	 int count =0;
	 for(i=0;i<vertices;i++)
	 {
		// LinkedList adj_i;
		 ArrayList adj_i;
		 adj_i=getVertex(i).getadj_number();
		 count=0;
		 		 		 
		 while((int)(vertexCount.get(i))<degree && count<500)
		 {
			 int t = 1 + (int)(Math.random()*(vertices-1)); 
			 count++;
			 if(t==i)
				 continue;
			 if((!adj_i.contains(t)) && ((int)(vertexCount.get(t)))<(degree-1) && (!adj_i.contains(i)))
			  {
				 int p = 1 + (int)(Math.random()*(1000)); 
				  addEdge(i, t, p);
				  addEdge(t,i,p);
				  int i_a = (int) vertexCount.get(i);
				  int i_t = (int) vertexCount.get(t);
				  i_a++; i_t++;
				  vertexCount.put(i, i_a);
				  vertexCount.put(t, i_t);
				 
			 }
		 }
		 
	 }
	 
	 int j;
//	 for(i=(vertices-1) ; i >2 ; i--)
//	 {
//		 ArrayList adj_i;
//		 adj_i=getVertex(i).getadj_number();
//		 if(vertexCount.get(i)!=degree)
//		 {
//			 for(j=i-1 ; j>1 ; j--)
//			 {
//				 if(vertexCount.get(j)<degree && (!adj_i.contains(j)) && (!adj_i.contains(i)))
//				 {
//					 int i_a = (int) vertexCount.get(i);
//					  int i_t = (int) vertexCount.get(j);
//					  i_a++; i_t++;
//					  int p = 1 + (int)(Math.random()*(100)); 
//					  vertexCount.put(i, i_a);
//					  vertexCount.put(j, i_t);
//					  addEdge(i, j, p);
//					  addEdge(j,i,p);
//					  break;
//				 }
//			 }
//		 }
//	 }
//	 
	 
	   
//    System.out.println("Hello");
//    for(i=0;i<vertices;i++)
//     {
//        System.out.print(+i);
//        System.out.print("--->");
//    //   System.out.print("(");
//     //  System.out.print(+(int)(vertexCount.get(i)));
//     //  System.out.print(")");
//     //  LinkedList adj_i;
//    	ArrayList adj_i;
//		 adj_i=getVertex(i).getadj_number();
//		 ArrayList adj_ed;
//		// LinkedList adj_ed;
//		 adj_ed = getVertex(i).getadj();
//		 for(j=0;j<adj_i.size();j++)
//		 {
//
//			 
//			 System.out.print(adj_i.get(j));
//			 Edge e1=(Edge) adj_ed.get(j);
//			 System.out.print("(");
//			 System.out.print(e1.getcost());
//			 System.out.print(")");
//			 System.out.print("--->");
//
//		 }
//		 System.out.println();
//     } 
	
 
     }
    
	

	public static void main(String[] args) {
	  Graph g = new Graph(50 , 2);
	 g.create_graph();
	  
	 

	  

	}
}

class Edge
{
    public Vertex     dest;   
    public int     cost;   
    
    public Edge( Vertex d, int c )
    {
        dest = d;
        cost = c;
    }
    public int getdestvertexnumber()
    {
    	return dest.getnumber();
    }
    public double getcost()
    {
    	return cost;
    }
}

class Vertex
{
    public Integer     name;  
   // public LinkedList       adj; 
    public ArrayList adj;
    public double     cost;   
  //  public LinkedList adj_number;
    public ArrayList adj_number;
    public ArrayList cost_of_edges;
  //  public LinkedList  cost_of_edges;

    public Vertex( Integer nm )
      {
    //	name = nm; adj = new LinkedList( ); adj_number = new LinkedList();
    //	cost_of_edges = new LinkedList();
    	
        	name = nm; 
        	adj = new ArrayList( ); adj_number = new ArrayList();
        	cost_of_edges = new ArrayList();
      }
    
  //  public LinkedList getadj()
    public ArrayList getadj()
    {
    	return adj;
    }
    
    public ArrayList getadj_number()
   // public LinkedList getadj_number()
    {
    	return adj_number;
    }
    
    
    public int getnumber()
    {
    	return name;
    }
    
    public ArrayList getcostarray()
  //  public LinkedList getcostarray()
    {
    	return cost_of_edges;
    }

}

class Edge_full
{
	public int src_vertex;
	public int dst_vertex;
	public int cost;
	Edge_full(int s , int d , int c)
	{
		src_vertex =s;
		dst_vertex =d;
		cost=c;
	}
}
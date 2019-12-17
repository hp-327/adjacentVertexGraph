package p11_package;

/**
 * Simple class for managing vertices and edges in a graph
 * 
 * @author MichaelL
 *
 */
public class GraphClass
   {
    private static final int[] vertexInList = null;

	/**
     * default vertex capacity
     * <p>
     * Note: Limited to number of upper case letters in alphabet
     */
    private final int VERTEX_CAPACITY = 26;
    
    /**
     * constant indication of vertex not in list
     */
    private final int NOT_IN_LIST = -1;
    
    /**
     * constant space character
     * 
     */
    private final char SPACE = ' ';
    
    /**
     * constant dash character
     * 
     */
    private final char DASH = '-';
    
    /**
     * size of vertex array
     */
    private int vertexListSize;
    
    /**
     * array of vertices
     */
    private VertexNode[] vertexList;
    
    /**
     * Default constructor
     */
    public GraphClass()
       {
        vertexListSize = 0;
        vertexList = new VertexNode[VERTEX_CAPACITY];
       }
    
    /**
     * Gets complete vertex node and data using the adjacent node data
     * 
     * @param adjNode AdjacentNode data provided
     * 
     * @return VertexNode data found in array
     */
    private VertexNode adjToVertex( AdjacentNode adjNode )
       {
    	// when I add a node it is added inherently Adjacent to its self? confused  
    	char vertex;
    	int index;
    	vertex = adjNode.getVertex();
    	index = vertexInList(vertex);
    	if(index == NOT_IN_LIST)
    	{
    		return null;
    	}
    	return vertexList[index];
       }
    
    /**
     * Breadth-First Search (BFS), is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showQueue boolean flag to control display
     * of queue during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String BFS( char startVertex, boolean showQueue )
       {
    	System.out.println("Breadth-First Traversal: ");
    	int index = vertexInList(startVertex);
    	
    	if (index < vertexListSize)
    	{
    		
    	}
        if(showQueue == true) 
        {
        	
        }

        return "";
       }
    
    /**
     * Clears all vertex visited flags; for use after completion of BFS, DFS
     */
    //looping through array get vertex list at index and call function unsetvisited
    // which sets flag to false for the vertex node
    public void clearVisitedFlags()
       {
    	int index;
        for (index = 0; index < vertexListSize; index++)
        {
        	vertexList[index].unSetVisited();
        }
       }
    
    /**
     * Depth-First Search (DFS), is actually just a traversal
     * 
     * @param startVertex character vertex to start with
     * 
     * @param showStack boolean flag to control display
     * of stack during operations
     * 
     * @return String result of traversal process
     * showing each visited vertex in the order it was visited
     */
    public String DFS( char startVertex, boolean showStack )
       {
        // Implement method: +6 pts  
    	System.out.println("Depth First Traversal: ");
    	boolean notFound = true;
    	VertexStack newStack = new VertexStack();
    	String depthFirstTraversal = "";
    	int currIndex = vertexInList[startVertex];
    	VertexNode currentNode;
    	AdjacentNode adjNode;
    	if (currIndex != NOT_IN_LIST)
    	{
    		currentNode = vertexList[currIndex];
    		depthFirstTraversal += currentNode.getVertex();
    		newStack.push(currentNode);
    		if(showStack)
    			System.out.println(newStack.toString());
    	}

        return "";
       }
    
    /**
     * Generates a list of the vertices with their adjacent vertices
     */
    public void generateAdjacencyLists()
       {
        // Implement method: +3 pts        
       }
    
    /**
     * Generates an adjacency matrix table 
     * that displays weights between vertices
     */
    // two for loops b/c x by y
    public void generateAdjacencyMatrix()
       {
        // Implement method: +3 pts        
       }
    
    /**
     * Inserts vertex, adjacent vertex, and weight into array alphabetically
     * <p>
     * Note: Uses insertion sort strategy
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of insertion;
     * false if vertex array is full, true otherwise
     */
    private boolean insertVertex( char vertex, char adjVertex, int weight )
       {
        int index =  vertexListSize;
        if(vertexListSize >= VERTEX_CAPACITY)
        {
        	return false;
        }
        while (index > 0 && vertexList[index-1].getVertex() > vertex)
        {
        	if (vertexList[index] == null)
        	{	
        	    vertexList[index]=new VertexNode(vertexList[index-1]);
        	}
        	else
        	{
        		vertexList[index] = vertexList[index-1];
        	}
        	index--;
        }
        vertexList[index] = new VertexNode(vertex, adjVertex, weight);
        vertexListSize++;
        return true;
       }
    
    /**
     * Recursive method that prints
     * a specified number of specified characters
     * 
     * @param numChars integer number of characters to print
     * 
     * @param outChar character value to be printed
     */
    void printChars( int numChars, char outChar )
       {
	    if(numChars>0)
	      {
	    	System.out.print(outChar);
	    	printChars(numChars-1, outChar);
	      }
       }
    
    /**
     * Sets vertex with adjacency
     * <p>
     * Note: Adds new vertex as needed;
     * otherwise adds adjacent vertex and weight to existing vertex
     * <p>
     * Note: Adds vertices in both directions (e.g., A with B as adjacency,
     * and B with A as adjacency)
     * <p>
     * Uses insertVertex to minimize excessive coding
     * 
     * @param vertex character vertex letter
     * 
     * @param adjVertex character adjacent vertex letter
     * 
     * @param weight integer weight between vertices
     * 
     * @return boolean result of action,
     * false if vertex array is full, true otherwise
     */
    // check if full
    // get index
    // get adj
    // if vertex in list add adj
    public boolean setVertex( char vertex, char adjVertex, int weight )
       {
        // Implement method: +4 pts
        int vertexIndex = vertexInList(vertex);
        int vertexAdjIndex = vertexInList(adjVertex);
        if(vertexListSize >= VERTEX_CAPACITY)
        {
        
	    	if (vertexIndex != NOT_IN_LIST) 
	    	{
	    		VertexNode newNode = vertexList[vertexIndex];
	    		newNode.addAdjacentVertex(adjVertex, weight);
	    		//vertexList[vertexIndex].addAdjacentVertex(adjVertex, weight);
	    	}
	    	else
	    	{
	    		insertVertex( vertex, adjVertex, weight);
	    	}
	    	if (adjVertex != NOT_IN_LIST)
	    	{
	    		//VertexNode newAdjNode = new VertexNode( vertexList[vertexAdjIndex] );
	    		VertexNode newAdjNode = vertexList[vertexAdjIndex];
	    		newAdjNode.addAdjacentVertex(vertex, weight);
	    		//vertexList[adjVertex].addAdjacentVertex(vertex, weight);
	    	}
	    	else
	    	{
	    		insertVertex( adjVertex, vertex, weight);
	    	}
	    	return true;
        }
    	
    	else
    	{
    		return false;
    	}
    	
       }          

    /**
     * Tests for vertex in list
     * 
     * @param testVertex character vertex to search for
     * 
     * @return integer index if vertex found,
     * constant NOT_IN_LIST otherwise
     */
    private int vertexInList( char testVertex )
       {
        int index;
        for (index = 0; index < vertexListSize; index++)
        {
        	if(vertexList[index].getVertex() == testVertex)
        	{
        		return index;
        	}
        }
        return NOT_IN_LIST;
       }
      
   }



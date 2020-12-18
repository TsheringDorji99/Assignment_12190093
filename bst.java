import java.util.*;

public class bst<key extends Comparable<key>,value>
{
	private Key key;
	private Vallue value;
	private Node left,right;
	private int size;
	public Node(Key key, Value value,int size)
	{
		this.key = key;
		this.value = value;
		this.size = size;
	}
	public bst(){
		root = null;
	}
	public int size()
	{
		return size(root);
	}
	private int size(Node x) 
    {
        if (x == null) 
        {
            return 0;
        }
        return x.size;
    }

	public boolean isEmpty()
	{
		if(size()==0){
			return true;
		}
		return false;
	}
	public void put(Key key, Value val) 
    {
        if(key == null)
        {
            throw new IllegalArgumentException ("Key shold not be null");
        }
        root = put(root, key, val);  
    }
    private Node put(Node x, Key key, Value val) 
    {
        if (x == null)
        {
            x = new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
        {
            x.left = put(x.left, key, val);
            //x.size++;
        }
        else if(cmp > 0)
        {
            x.right = put(x.right, key, val);
            //x.size++;
        }
        else if(cmp == 0)
        {
            x.val = val;
        }
        //x.size++;
        x.size = size(x.left)+size(x.right)+1;
        return x;
    }
	 public Value get(Key key) 
    {
        if (key == null)
        {
            throw new IllegalArgumentException("The key is null");
        }
        else
        {

            return get(root,key);
        }
    }

    private Value get(Node x, Key key) 
    {
        if(x==null)
        {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
        {
            return get(x.left, key);
        }
        else if (cmp > 0)
        {
            return get(x.right, key);
        }
       else
        {
            return x.val;
        }
	}
	public void deleteMin(){

	}
	public void delete(Node key){

	}
	public Key min() 
    {
       if(isEmpty())
       {
        throw new NoSuchElementException("symbol table is empty");
       }
       return min(root).key;
    } 
    private Node min(Node x) 
    { 
       if (x.left == null)
        {
            return x;
        }
        return min(x.left);  
    }
	public Key floor(Key key) 
    {
        Node y = floor(root,key);
        if(y == null)
        {
            throw new IllegalArgumentException ("The node is empty");
        }
        return y.key;
    } 

    private Node floor(Node x, Key key) 
    {
        if (x == null) 
        {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) 
        {
            return x;
        }
        if (cmp < 0) 
        {
            return floor(x.left, key);
        }
        Node a = floor(x.right, key);
        if (a != null) 
        {
            return a;
        }
        else{
        	return x;
        } 
    }    	
	public Node select(Node x, int p){
		if(x ==null){
			return null;
		}
		int s = size(x.left);
		if(s > p){
			return select(x.left,p);
		}
		else if(s < p){
			return select(x.right, p-t-1)
		}
	}
	public Node key(){

	}

	public static void main(String[] arg){
		bst o() = new bst();
		o.put("Ada", 1);
		o.put("Ballerina", 3);
		System.out.println(o.get("Ada"));
		o.put("Html", 5);
		o.put("java", 7);
		System.out.println(o.get("java"));


	}
}
	

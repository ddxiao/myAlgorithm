package binary_Search;

public class BST<Key extends Comparable<Key>, Value> {
	// 二分搜索树
	// 由于Key需要进行比较，所以key extends Comparable<Key>
	
	//内部类定义 节点
	private class Node{
		private Key key;
		private Value value;
		private Node left, right;
		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}
	
	private Node root;	//根节点
	private int count;	//树中的节点个数
	
	//构造函数， 默认构造一个空的二叉搜索树
	private BST(){
		root = null;
		count = 0;
	}
	
	//树的节点个数
	public int size(){
		return count;
	}
	
	// 树是否为空
	public boolean isEmpty(){
		return count == 0;
	}
	
	// 向二叉树中插入一个新的（key，value）数据对
	public void insert(Key key, Value value){
		root = insert(root, key, value);
	}
	
	// 判断二分搜索树中是否存在键key
	public boolean contain(Key key){
		return contain(root, key);
	}
	
	// 在二分搜索书中查找键key对应的value，如果这个值不存在返回null
	public Value search(Key key){
		return search(root, key);
	}
	
	//_________________________________________________________________________________________________
	
	private Node insert(Node node, Key key, Value value){
		if (node == null){	//树空的情况下，直接插入
			count++;
			return new Node(key, value);
		}
		
		if(key.compareTo(node.key)==0){	//键和当前节点键相同，覆盖当前节点的值
			node.value = value;
		}else if(key.compareTo(node.key)<0){	//键小于当前节点键，递归左子树
			node.left = insert(node.left, key, value);
		}else{	//键小于当前节点键，递归右子树
			node.right = insert(node.right, key, value);
		}
		
		return node;
	}
	
	//判断二分搜索树中是否存在键key
	private boolean contain(Node node, Key key){
		if(node == null){
			return false;
		}
		
		if(node.key.compareTo(key)==0){
			return true;
		}else if(key.compareTo(node.key)>0){
			return contain(node.right, key);
		}else{
			return contain(node.left, key);
		}
		
	}
	
	// 在二分搜索书中查找键key对应的value，如果这个值不存在返回null
	private Value search(Node node, Key key){
		if(node == null){
			return null;
		}
		
		if (key.compareTo(node.key)==0){
			return node.value;
		}else if(key.compareTo(node.key)>0){
			return search(node.right, key);
		}else{
			return search(node.left, key);
		}
		
	}
	
	
	public static void mian(String[] args){
		
	}

}

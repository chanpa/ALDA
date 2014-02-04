package alda.tree;

/**
 * Denna klass representerar noderna i ett bin�rt s�ktr�d utan dubletter.
 * 
 * Detta �r den enda av de tre klasserna ni ska g�ra n�gra �ndringar i. (Om ni
 * inte vill l�gga till fler testfall.) De �ndringar som �r till�tna �r dock
 * begr�nsade av f�ljande regler:
 * <ul>
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * </ul>
 * 
 * @author henrikbe
 * 
 * @param <T>
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * L�gger till en nod i det bin�ra s�ktr�det. Om noden redan existerar s�
	 * l�mnas tr�det of�r�ndrat.
	 * 
	 * @param data
	 *            datat f�r noden som ska l�ggas till.
	 * @return true om en ny nod lades till tr�det.
	 */
	public boolean add(T data) {
		// Hur vill vi hantera null data?
		if (data == null)
			return false;

		return add(data, this);
	}

	private boolean add(T data, BinarySearchTreeNode<T> n){
		int result = data.compareTo(n.data);
		
		// Om det nya datat är mindre än datat för denna nod
		if (result < 0){
			if (n.left == null){
				BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<T>(data);
				n.left = newNode;
				return true;
			}
			else
				return add(data, n.left);
		}

		// Om det nya datat är större än datat för denna nod
		else if (result > 0){
			if (n.right == null){
				BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<T>(data);
				n.right = newNode;
				return true;
			}
			else
				return add(data, n.right);
		}
		
		// Om result är 0 så har data samma värde som nuvarande noden. Gör ingenting.
		else {
			return false;
		}
	}



	/**
	 * Privat hj�lpmetod som �r till nytta vid borttag. Ni beh�ver inte
	 * skriva/utnyttja denna metod om ni inte vill.
	 * 
	 * @return det minsta elementet i det (sub)tr�d som noden utg�r root i.
	 */
	private BinarySearchTreeNode<T> findMin() {
		if (data == null)
			return null;
		else if (this.left == null)
			return this;
		return left.findMin();
	}

	private BinarySearchTreeNode<T> findMax() {
		if (data == null)
			return null;
		else if (this.right == null)
			return this;
		return right.findMax();
	}

	/**
	 * Tar bort ett element ur tr�det. Om elementet inte existerar s l�mnas
	 * tr�det of�r�ndrat.
	 * 
	 * @param data
	 *            elementet som ska tas bort ur tr�det.
	 * @return en referens till nodens subtr�d efter borttaget.
	 */
	public BinarySearchTreeNode<T> remove(T data) {
		return remove(data, this);
	}
	private BinarySearchTreeNode<T> remove(T data, BinarySearchTreeNode<T> n){
		if (n == null)
			return null;
		
		int result = data.compareTo(n.data);
		
		if (result < 0)
			n.left = remove(data, n.left);
		else if (result > 0)
			n.right = remove(data, n.right);
		else if (n.right != null && n.left != null){
			n.data = n.right.findMin().data;
			n.right = remove(n.data, n.right);
		}
		else {
			n = (n.left != null) ? n.left : n.right;
		}
		return n;
	}

	/**
	 * Kontrollerar om ett givet element finns i det (sub)tr�d som noden utg�r
	 * root i.
	 * 
	 * @param data
	 *            det s�kta elementet.
	 * @return true om det s�kta elementet finns i det (sub)tr�d som noden utg�r
	 *         root i.
	 */
	public boolean contains(T data) {

		/*
		 * Hur ska vi hantera sökning efter null?
		 * Vad ska vi göra om datat i en viss nod är null?
		 */
		if (data == null)
			return false;
		
		return contains(data, this);
		
	}
	
	private boolean contains(T data, BinarySearchTreeNode<T> n){
		if (n == null)
			return false;
		
		int result = data.compareTo(n.data);
		
		if (result < 0)
			return contains(data, n.left);
		else if (result > 0)
			return contains(data, n.right);
		else
			return true;
		
	}

	/**
	 * Storleken p� det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return det totala antalet noder i det (sub)tr�d som noden utg�r root i.
	 */
	public int size() {
		return size(this, 0);
	}
	private int size(BinarySearchTreeNode<T> n, int size){
		if (n != null){
			size = size(n.left, size) + 1;
			size = size(n.right, size);
		}
		return size;
	}

	/**
	 * Det h�gsta djupet i det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return djupet.
	 */
	public int depth() {
		return depth(this);
	}

	private int depth(BinarySearchTreeNode<T> n){
		if (n == null)
			return -1;
		else
			return 1 + Math.max(depth(n.left), depth(n.right));
	}

	/**
	 * Returnerar en str�ngrepresentation f�r det (sub)tr�d som noden utg�r root
	 * i. Denna representation best�r av elementens dataobjekt i sorterad
	 * ordning med ", " mellan elementen.
	 * 
	 * @return str�ngrepresentationen f�r det (sub)tr�d som noden utg�r root i.
	 */
	public String toString() {
		String s = ascToStrBuilder(this, "");
		if (s.length() > 2)
			return s.substring(0, s.length()-2);
		return s;
	}

	private String ascToStrBuilder(BinarySearchTreeNode<T> n, String s){
		
		if (n != null){
			s = ascToStrBuilder(n.left, s) + n.data + ", ";
			s = ascToStrBuilder(n.right, s);
		}
			
		return s;
	}
}
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
		
		// Om det nya datat är mindre än datat för denna nod
		if (data.compareTo(this.data) < 0){
			if (this.left == null){
				BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<T>(data);
				
			}
		}
		
		// Om det nya datat är större än datat för denna nod
		else if (data.compareTo(this.data) > 0){
			
		}
		
		// Om det nya datat är samma som datat för denna nod
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
	private T findMin() {
		if (data == null)
			return null;
		else if (this.left == null)
			return this.data;
		return left.findMin();
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
		return null;
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
		
		// Om indatat är mindre än nuvarande nods data
		if (data.compareTo(this.data) < 0){
			// Om left för denna nod är null så är indata mindre än det minsta datat i detta subträd - det finns inte
			if (left == null)
				return false;
			// Om det finns en left referens så kan en nod med vårat data fortfarande finnas, undersök nästa nod åt vänster (mindre)
			left.contains(data);
		}
		
		// Om indatat är större än nuvarande nods data
		else if (data.compareTo(this.data) > 0){
			// Om right för denna nod är null så är indata större än det största datat i detta subträd - det finns inte
			if (right == null)
				return false;
			// Om det finns en right referens så kan en nod med vårat data fortfarande finnas, undersök nästa nod åt höger (större)
			right.contains(data);
		}
		
		// Om indatat varken är null, större eller mindre än nuvarande nods data så är det samma data - datat finns redan
		else 
			return true;
		
		// Måste returnera en boolean. Borde inte if-elseif-else satsen täcka alla möjliga outcomes??
		// när kommer vi hit???
		return false;
	}

	/**
	 * Storleken p� det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return det totala antalet noder i det (sub)tr�d som noden utg�r root i.
	 */
	public int size() {
		return 0;
	}

	/**
	 * Det h�gsta djupet i det (sub)tr�d som noden utg�r root i.
	 * 
	 * @return djupet.
	 */
	public int depth() {
		return -1;
	}

	/**
	 * Returnerar en str�ngrepresentation f�r det (sub)tr�d som noden utg�r root
	 * i. Denna representation best�r av elementens dataobjekt i sorterad
	 * ordning med ", " mellan elementen.
	 * 
	 * @return str�ngrepresentationen f�r det (sub)tr�d som noden utg�r root i.
	 */
	public String toString() {
		return "";
	}
}
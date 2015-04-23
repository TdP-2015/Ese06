package bean;
////////////////////////////////////////////////////////////////////////////////
//             //                                                             //
//   #####     // Ese06 -- yet another simple example                         //
//  ######     // (!) 2015 Giovanni Squillero <giovanni.squillero@polito.it>  //
//  ###   \    //                                                             //
//   ##G  c\   //                                                             //
//   #     _\  //                                                             //
//   |   _/    //                                                             //
//   |  _/     //                                                             //
//             // 03FYZ - Tecniche di programmazione 2014-15                  //
////////////////////////////////////////////////////////////////////////////////

public class Item implements Comparable<Item> {
	protected int id;
	protected Integer weight;

	public Item(int i, int p) {
		super();
		id = i;
		weight = p;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return id + ":" + weight;
	}

	@Override
	public int compareTo(Item arg0) {
		return arg0.weight.compareTo(weight);
	}
}

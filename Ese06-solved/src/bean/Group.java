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

package bean;

import java.util.HashSet;
import java.util.Set;

public class Group {
	protected int totWeight;
	protected Set<Item> items;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Group [totWeight=" + totWeight + ", items=" + items + "]";
	}

	/**
	 * @return the totWeight
	 */
	public int getTotWeight() {
		return totWeight;
	}

	public Group() {
		items = new HashSet<Item>();
	}
	
	public void copyGroup(Group g) {
		items.clear();
		items.addAll(g.items);
		totWeight = g.totWeight;
	}
	
	public void addItem(Item i) {
		items.add(i);
		totWeight += i.weight;
	}
	
	public void removeItem(Item i) {
		items.remove(i);
		totWeight -= i.weight;
	}
}

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

import java.util.ArrayList;
import java.util.List;

import bean.*;
import dao.*;

public class Main {
	private long counter;
	private List<Item> items;
	private Group[] group;
	private Group[] bestGroup;
	private int bestDiff;
	private int bound;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	private void run() {
		SimpleDAO d = new SimpleDAO();
		items = d.getObjectList();

		group = new Group[2];
		group[0] = new Group();
		group[1] = new Group();
		bestGroup = new Group[2];
		bestGroup[0] = new Group();
		bestGroup[1] = new Group();
		
		kickStart();
		System.out.println("G1: " + bestGroup[0]);
		System.out.println("G2: " + bestGroup[1]);
		recPath(0);
		System.out.println();
		System.out.println("***** BEST SOLUTION (" + counter + " calls)");
		System.out.println("G1: " + bestGroup[0]);
		System.out.println("G2: " + bestGroup[1]);
	}
	
	protected void kickStart() {
		for(Item i : items) 
			if(bestGroup[0].getTotWeight() < bestGroup[1].getTotWeight())
				bestGroup[0].addItem(i);
			else
				bestGroup[1].addItem(i);
		bestDiff  = Math.abs(bestGroup[0].getTotWeight() - bestGroup[1].getTotWeight());
		bound = Math.max(bestGroup[0].getTotWeight(), bestGroup[1].getTotWeight());
	}
	
	private boolean recPath(int s) {
		++counter;
		
		if(bestDiff==0)
			return true;
		
		if(Math.max(group[0].getTotWeight(), group[1].getTotWeight()) > bound)
			return false;
		
		if(s == items.size()) {
			int diff = Math.abs(group[0].getTotWeight() - group[1].getTotWeight());
			if(diff < bestDiff) {
				bestDiff = diff;
				bound = Math.max(group[0].getTotWeight(), group[1].getTotWeight());
				
				bestGroup[0].copyGroup(group[0]);
				bestGroup[1].copyGroup(group[1]);
				
				System.out.println();
				System.out.println("G1: " + bestGroup[0]);
				System.out.println("G2: " + bestGroup[1]);
			}
			if(bestDiff == 0)
				return true;
			else
				return false;
		}
		
		for(int t = 0; t < 2; ++t) {
			group[t].addItem(items.get(s));		// step
			if(recPath(s+1) == true)			// call
				return true;			
			group[t].removeItem(items.get(s));	// backtrack!!!!
		}
		
		return false;
	}
	
}

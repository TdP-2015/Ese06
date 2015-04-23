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
	private List<Oggetto> oggetti;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.run();
	}

	private void run() {
		SimpleDAO d = new SimpleDAO();
		oggetti = d.getObjectList();
	}
}

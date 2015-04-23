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

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.DBConnect;
import bean.*;

public class SimpleDAO {
	public List<Item> getObjectList() {
		final String sql = "SELECT * FROM oggetti LIMIT 50";
		List<Item> items = new ArrayList<Item>();
	
		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Item o = new Item(rs.getInt("ID"), rs.getInt("peso"));
				items.add(o);
			}

			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return items;
	}
}

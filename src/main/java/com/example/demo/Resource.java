package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	/*@RequestMapping("/ignite")
	public Map<Integer, String> get() {

		return getData();
	}*/

	@RequestMapping("/getdb1")
	public String getdb1() {

		return getDb();
	}

	private String getDb() {

		
		//String host = "jdbc:mysql://apsrp04981.uhc.com:3306/sampledb";
		String host = "jdbc:mysql://mysql:3306/sampledb";
		String user = "iris";
		String password = "iris";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(host, user, password);

			System.out.println("\n\t The connection class name is : " + conn.getClass().getName());
			System.out.println("\n\n\t GOT Connection at: " + new java.util.Date());
			/*Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from iris_ui");
			System.out.println("\n\t###########################################");
			System.out.println("\n\tid" + "\tname" + "\t\t\trating");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String rating = rs.getString("rating");
				System.out.println("\n\t" + id + "\t" + name + "\t" + rating);
			}*/
			System.out.println("\n\t###########################################");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			if (conn != null) {
				System.out.println("\n\tfinally{} if(con!=null) ");
				try {
					conn.close();
					System.out.println("\n\t Closing the connection !!");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}
		String result = "Successfully Got the Connection ...Exiting the program";

		return result;
	}

	/*public Map<Integer, String> getData() {

		Ignition.setClientMode(true);

		Ignite objIgnite = Ignition.start("default-config.xml");

		IgniteCache<Integer, String> objIgniteCache = objIgnite.getOrCreateCache("irisCache");

		// Populating the cache with few values
		
		 * System.out.
		 * println("**************Start putting data into ignite cache**************"
		 * ); objIgniteCache.put(1, "iris-ui"); objIgniteCache.put(2,
		 * "iris-spring"); objIgniteCache.put(3, "iris-ignite");
		 * objIgniteCache.put(4, "iris-oracle");
		 

		// Get these items from cache
		System.out.println("**************Start fetching data from ignite cache**************");
		System.out.println(objIgniteCache.get(1));
		System.out.println(objIgniteCache.get(2));
		System.out.println(objIgniteCache.get(3));
		System.out.println(objIgniteCache.get(4));

		Map<Integer, String> map = new HashMap<>();
		map.put(1, objIgniteCache.get(1));
		map.put(2, objIgniteCache.get(2));
		map.put(3, objIgniteCache.get(3));
		map.put(4, objIgniteCache.get(4));
		return map;
	}*/

}

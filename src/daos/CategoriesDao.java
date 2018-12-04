package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Categories;
import utilities.ConnectionPool;

public class CategoriesDao {

	public void create(Categories categories) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();

		try {
			String sql = "insert into categories(catid, catname) values (?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, categories.getCatid());
			ps.setString(2, categories.getCatname());
			
			System.out.println("New Category is inserted into the table");
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new category." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Categories categories) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update users set catname = ? where catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, categories.getCatname());
			ps.setInt(2, categories.getCatid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from categories where catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Categories find(int catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Categories categories= new Categories();
		try {
			String sql = "select * from categories where catid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, catid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				categories.setCatid(catid);;
				categories.setCatname(rs.getString("catname"));
				}
		} catch (SQLException sq) {
			System.out.println("Unable to find a row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return categories;
	}


	public ArrayList<Categories> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Categories> list = new ArrayList<Categories>();
		try {
			String sql = "select * from categories";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Categories categories = new Categories();
				categories.setCatid(rs.getInt("catid"));
				categories.setCatname(rs.getString("catname"));
				
				list.add(categories);
			
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the records." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return list;
	}

}

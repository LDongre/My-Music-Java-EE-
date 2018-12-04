package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Music;
import pojos.Pop;
import utilities.ConnectionPool;

public class PopDao {
	public void create(Pop pop) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();

		try {
			String sql = "insert into pop(mname, artist, location, format) values (?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pop.getMname());
			ps.setString(2, pop.getArtist());
			ps.setString(3,  pop.getLocation());
			ps.setString(4,  pop.getFormat());
			
			System.out.println("New Pop is inserted into the table");
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new category." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Pop pop) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update pop set mname = ?, artist = ?, location = ?, format = ? where mid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pop.getMname());
			ps.setString(2, pop.getArtist());
			ps.setString(3, pop.getLocation());			
			ps.setString(4, pop.getFormat());			
			ps.setInt(5, pop.getMid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to edit the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int mid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from pop where mid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to delete the row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Music find(int mid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Music music= new Pop();
		try {
			String sql = "select * from pop where mid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				music.setMid(mid);;
				music.setMname(rs.getString("mname"));
				music.setArtist(rs.getString("artist"));
				music.setLocation(rs.getString("location"));
				music.setFormat(rs.getString("format"));
				}
		} catch (SQLException sq) {
			System.out.println("Unable to find a row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return music;
	}


	public ArrayList<Music> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Music> list = new ArrayList<Music>();
		
		
		try {
			String sql = "select * from pop";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Music music= new Pop();
				music.setMid(rs.getInt("mid"));;
				music.setMname(rs.getString("mname"));
				music.setArtist(rs.getString("artist"));
				music.setLocation(rs.getString("location"));
				music.setFormat(rs.getString("format"));
				list.add(music);
			
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the records." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return list;
	}
	
	public ArrayList<Music> findAllByWord(String word) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Music> list = new ArrayList<Music>();
		
		
		try {
			String sql = "select * from pop";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("mname").toLowerCase().contains(word.toLowerCase()) || rs.getString("artist").toLowerCase().contains(word.toLowerCase()))  {
				Music music= new Pop();
				music.setMid(rs.getInt("mid"));
				music.setMname(rs.getString("mname"));
				music.setArtist(rs.getString("artist"));
				music.setLocation(rs.getString("location"));
				music.setFormat(rs.getString("format"));
				list.add(music);
				}
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the records." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return list;
	}
	
	

}

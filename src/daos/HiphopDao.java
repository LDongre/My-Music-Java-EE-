package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Hiphop;
import pojos.Music;
import utilities.ConnectionPool;

public class HiphopDao {
	public void create(Hiphop hiphop) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();

		try {
			String sql = "insert into hiphop( mname, artist, location, format) values (?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, hiphop.getMname());
			ps.setString(2, hiphop.getArtist());
			ps.setString(3, hiphop.getLocation());
			ps.setString(4, hiphop.getFormat());

			System.out.println("New Category is inserted into the table");
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new category." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Hiphop hiphop) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update hiphop set mname = ?, artist = ?, location = ?, format = ? where mid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, hiphop.getMname());
			ps.setString(2, hiphop.getArtist());
			ps.setString(3, hiphop.getLocation());
			ps.setString(4, hiphop.getFormat());
			ps.setInt(5, hiphop.getMid());
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
			String sql = "delete from hiphop where mid = ?";
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
		Music music = new Hiphop();
		try {
			String sql = "select * from hiphop where mid= ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				music.setMid(mid);
				;
				music.setMname(rs.getString("mname"));
				music.setArtist(rs.getString("artist"));
				music.setLocation(rs.getString("location"));
				music.setLocation(rs.getString("format"));
				
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
			String sql = "select * from hiphop";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Music music= new Hiphop();
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
			String sql = "select * from hiphop";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("mname").toLowerCase().contains(word.toLowerCase()) || rs.getString("artist").toLowerCase().contains(word.toLowerCase()))  {
				Music music= new Hiphop();
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
	
	public static void main(String args[]) {
		
	}
}

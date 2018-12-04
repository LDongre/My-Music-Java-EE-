package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Music;
import pojos.Rock;
import utilities.ConnectionPool;

public class RockDao {

	public void create(Rock rock) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();

		try {
			String sql = "insert into rock(mname, artist, location, format) values (?,?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, rock.getMname());
			ps.setString(2, rock.getArtist());
			ps.setString(3, rock.getLocation());
			ps.setString(4, rock.getFormat());

			System.out.println("New Rock is inserted into the table");
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new category." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Rock rock) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update rock set mname = ?, artist = ?, location = ?,format = ? where mid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, rock.getMname());
			ps.setString(2, rock.getArtist());
			ps.setString(3, rock.getLocation());
			ps.setString(4, rock.getFormat());
			ps.setInt(5, rock.getMid());
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
			String sql = "delete from rock where mid = ?";
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
		Music music = new Rock();
		try {
			String sql = "select * from rock where mid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				music.setMid(mid);
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
			String sql = "select * from rock";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Music music = new Rock();
				music.setMid(rs.getInt("mid"));
				;
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
			String sql = "select * from rock";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString("mname").toLowerCase().contains(word.toLowerCase()) || rs.getString("artist").toLowerCase().contains(word.toLowerCase())) {
					Music music = new Rock();
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

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.HiphopDao;
import daos.JazzDao;
import daos.PopDao;
import daos.RockDao;
import pojos.Music;
@WebServlet("/TypeServlet")
public class TypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TypeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("reached type servlet");
		String type= request.getParameter("type");
		
		ArrayList<Music> musicList = new ArrayList<Music>();
		musicList.clear();
		
		if(request.getParameter("search_query") != null) {
			System.out.println("search button clicked");
			String search_query = request.getParameter("search_query");
			
			ArrayList<Music> redundantList = new ArrayList<Music>();
			redundantList.addAll(new RockDao().findAllByWord(search_query));
			redundantList.addAll(new HiphopDao().findAllByWord(search_query));
			redundantList.addAll(new PopDao().findAllByWord(search_query));
			redundantList.addAll(new JazzDao().findAllByWord(search_query));
			
			musicList = redundantList;
			HashSet<Integer> hashSet = new HashSet<Integer>();
			for(Music music: redundantList) {
				hashSet.add(music.getMid());
				System.out.println("mid: " + music.getMid());
			}
			/*
			for(Music m: redundantList) {
				int flag = 0;
				for(Music innerM: musicList) {
					if(m.getMid() == innerM.getMid()) {
						flag++;
						System.out.print(flag);
					}
				}
				System.out.println("*****");
				if(flag > ) {
					musicList.remove(m);
					
				}
			}
			*/
		}
		else if(type == null || type.equals("All")) {
			musicList.addAll(new RockDao().findAll());
			musicList.addAll(new HiphopDao().findAll());
			musicList.addAll(new PopDao().findAll());
			musicList.addAll(new JazzDao().findAll());
			
		}
		else if(type.equals("Rock")) {
			musicList.addAll(new RockDao().findAll());
		}
		else if(type.equals("Pop")) {
			musicList.addAll(new PopDao().findAll());
		}
		else if(type.equals("Hiphop")) {
			musicList.addAll(new HiphopDao().findAll());
		}
		else if(type.equals("Jazz")) {
			musicList.addAll(new JazzDao().findAll());
		}
		
		request.setAttribute("musicList", musicList);
		RequestDispatcher rd = request.getRequestDispatcher("frame.jsp");
		rd.include(request, response);
		rd = request.getRequestDispatcher("/player.jsp");
		rd.include(request, response);
	}
	
}

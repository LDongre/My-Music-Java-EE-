<%@ page import="pojos.Categories" import="java.util.ArrayList"  import = "daos.CategoriesDao" import = "pojos.Music" import = "daos.RockDao"%>
<div style = "background-color:yellow;">

	<table class="container table">
		<tr>
			<td><a style="width: 100px;"
				href="/MyMusic/secure/ScrollableServlet?source=All" class="btn btn-danger ">
					All </a></td>
			<%
				ArrayList<Categories> catList = new ArrayList<Categories>();
			%>
			<%
				catList = new CategoriesDao().findAll();
			%>
			<%
				for (Categories categories : catList) {
			%>
			<%
				String name = categories.getCatname();
			%>
			<%
				String path = "/MyMusic/secure/ScrollableServlet?source=" + name;
			%>
			<td><a style="width: 100px;" href="<%=path%>"
				class="btn btn-danger"> <%=name%>
			</a></td>

			<%
				}
			%>
		</tr>
	</table>

	<table class=" container table table-stripped table-bordered "
		style="width: 80%">

		<tr>
			<td>Song Name</td>

			<td>Choose action</td>
		</tr>
		
		<%
		ArrayList<Music> list = (ArrayList<Music>) request.getAttribute("songList");
		if(list != null) {
				for(Music music: list) {
		%>

		<tr>
			<td><%= music.getMname() %></td>
			<td><input type="button" value="Play now"></td>
		</tr>
		<% } }
		else {
			response.sendRedirect("/MyMusic/index.jsp");
		}%>
	</table>
</div>
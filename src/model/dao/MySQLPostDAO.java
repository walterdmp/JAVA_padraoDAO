package model.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.ModelException;
import model.entities.Post;
import model.entities.User;

class MySQLPostDAO implements PostDAO {

	@Override
	public boolean save(Post post, User user) throws ModelException {
		String sqlInsert = "INSERT INTO posts "
				+ " VALUES(DEFAULT, ?, ?, ?);";

		DataBaseHandler dbHandler = new DataBaseHandler();
		dbHandler.prepareStatement(sqlInsert);

		dbHandler.setString(1, post.getContent());
		dbHandler.setString(2, post.getDate().toString());
		dbHandler.setInt(3, user.getId());

		int rowsAffected =  dbHandler.executeUpdate();

		dbHandler.close();

		return rowsAffected > 0;
	}

	@Override
	public boolean update(Post post, User user) throws ModelException {
		String sqlUpdate = "UPDATE posts "
				+ " SET content = ?, post_date = ?, user_id = ? "
				+ " WHERE id = ?; ";


		DataBaseHandler dbHandler = new DataBaseHandler();
		dbHandler.prepareStatement(sqlUpdate);

		dbHandler.setString(1, post.getContent());
		dbHandler.setString(2, post.getDate().toString());
		dbHandler.setInt(3, user.getId());
		dbHandler.setInt(4, post.getId());

		int rowsAffected =  dbHandler.executeUpdate();

		dbHandler.close();

		return rowsAffected > 0;
	}

	@Override
	public boolean delete(Post post) throws ModelException {
		String sqlDelete = "DELETE FROM posts WHERE id = ?;";

		DataBaseHandler dbHandler = new DataBaseHandler();
		dbHandler.prepareStatement(sqlDelete);

		dbHandler.setInt(1, post.getId());

		int rowsAffected =  dbHandler.executeUpdate();

		dbHandler.close();

		return rowsAffected > 0;
	}

	@Override
	public List<Post> listAll() throws ModelException {
		List<Post> posts = new ArrayList<>();

		String sqlQuery = " SELECT * FROM posts ";

		DataBaseHandler dbHandler = new DataBaseHandler();
		dbHandler.statement();

		dbHandler.executeQuery(sqlQuery);

		while (dbHandler.next()) {
			int postId = dbHandler.getInt("id");
			String content = dbHandler.getString("content");
			String postDate = dbHandler.getString("post_date");
			int userId = dbHandler.getInt("user_id");

			Post post = new Post(postId);
			post.setContent(content);
			post.setDate(postDate);
			User user = new User(userId);
			posts.add(post);
		}

		dbHandler.close();

		return posts;
	}

	@Override
	public Post findById(int id) throws ModelException {
		String sql = "SELECT * FROM posts WHERE id = ?;";
		
		DataBaseHandler dbHandler = new DataBaseHandler();
		dbHandler.prepareStatement(sql);
		dbHandler.setInt(1, id);

		dbHandler.executeQuery();
		Post post = null;
		while (dbHandler.next()) {
			int postId = dbHandler.getInt("id");
			String content = dbHandler.getString("content");
			String postDate = dbHandler.getString("post_date");
			int userId = dbHandler.getInt("user_id");


			post = new Post(postId);
			post.setContent(content);
			post.setDate(postDate);
			User user = new User(userId);
			break;
		}
		dbHandler.close();

		return post;
	}
}

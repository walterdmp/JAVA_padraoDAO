package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.ModelException;
import model.dao.DAOFactory;
import model.dao.PostDAO;
import model.entities.Post;
import model.entities.User;

public class Main {
	public static void main(String[] args) {
		User teste = new User(2);
		
//		boolean testeSave;
//		
//		UserDAO dao = (UserDAO) DAOFactory.getDAO(UserDAO.class);
//		
//		try {
//			testeSave = dao.save(teste);
//			if(testeSave) {
//				System.out.println("Salvo com sucesso!");
//			}
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//			e.getCause().printStackTrace();
//		}
	
		
//		LocalDate dataAtual = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        String dataFormatada = dataAtual.format(formatter);
//        
//        
//		Post postTeste = new Post(9);
//		postTeste.setContent("Testando");
//		postTeste.setDate("2024-12-01");
		
		
		PostDAO dao1 = (PostDAO) DAOFactory.getDAO(PostDAO.class);
		
		Post post = null;
		List<Post> lista = null;
		boolean flag;
		
//		try {
//			flag = dao1.save(postTeste, teste);
//			if(flag) {
//				System.out.println("Adicionado com sucesso!");
//			}
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//			e.getCause().printStackTrace();
//		}
		
//		try {
			//flag = false;
//			flag = dao1.update(postTeste, teste);
//			if(flag) {
//				System.out.println("Atualizado com sucesso!");
//			}
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//			e.getCause().printStackTrace();
//		}
		
//		try {
			//flag = false;
//			flag = dao1.delete(postTeste);
//			if(flag) {
//				System.out.println("Deletado com sucesso!");
//			}
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//			e.getCause().printStackTrace();
//		}
		
//		try {
//			flag = false;
//			flag = dao1.delete(post);
//			if(flag) {
//				System.out.println("Deletado com sucesso!");
//			}
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//			e.getCause().printStackTrace();
//		}
		
		try {
			lista = dao1.listAll();
		} catch (ModelException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause().getMessage());
			e.getCause().printStackTrace();
		}
		
		for (Post el : lista) {
		    if (el != null) {
		    	System.out.println("Id: " + el.getId());
				System.out.println("Conteúdo: " + el.getContent());
				System.out.println("Data: " + el.getDate());
				System.out.println("Usuário: " + el.getId());
				System.out.println();
		    }
		}
		
		
//		try {
//			post = dao1.findById(2);
//		} catch (ModelException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause().getMessage());
//			e.getCause().printStackTrace();
//		}
//		
//		if (post != null) {
//			System.out.println("Id: " + post.getId());
//			System.out.println("Conteúdo: " + post.getContent());
//			System.out.println("Data: " + post.getDate());
//			System.out.println("Usuário: " + post.getId());
//			System.out.println();
//		}

	}
}

package app;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import dao.NewsDao;
import dao.UserDao;
import dao.impl.NewsImpl;
import dao.impl.UserImpl;
import entity.Address;
import entity.Comment;
import entity.Gender;
import entity.News;
import entity.User;

public class Test {
	public static void main(String[] args) throws RemoteException {
		UserDao userDao = new UserImpl();
		NewsDao newsDao = new NewsImpl();
		Address address  = new Address("Nguyễn Văn Bảo", "Hồ Chí Minh", "keke", "balabum");
		User user = new User(1L, "Vinh", "vinh@gmail.com", "123456", new HashSet<String>(Arrays.asList("9009090")), address , Gender.MALE);
//		
//		System.out.println(userDao.adddUser(user));
		
//		newsDao.getNewsByTagsOrCategoriesName("Oldboy").forEach(n->{
//			System.out.println(n);
//		});
		
//		User user = new User(4l,"ThaiLe4","thai4@gmail.com","123456",new HashSet<String>(Arrays.asList("9009090")),new Address("ss","ss","ss","ss"),Gender.MALE);
//		Comment cm1 = new Comment("1",LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30));
//		cm1.setNw(new News(8l));
//		Comment cm2 = new Comment("3",LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30));
//		cm2.setNw(new News(2l));
//		List<Comment> listcomment = new ArrayList<Comment>();
//		listcomment.add(cm1);listcomment.add(cm2);
//		user.setListOfComments(listcomment);
//		System.out.println(userDao.adddUser(user)); 
		
//		Câu c
//		userDao.getStatistics().forEach((user, k)->{
//			System.out.println(user+" :"+k);
//		});
		
//		Câu d
//		newsDao.listNewsByUserEmail("thai4@gmail.com").forEach(n -> {
//			System.out.println(n);
//		});
	}
}

package com.jblogger.web.helper;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jblogger.dao.AuthorityDao;
import com.jblogger.model.Authority;
import com.jblogger.model.Comment;
import com.jblogger.model.Post;
//import com.jblogger.model.Role;
import com.jblogger.model.User;
import com.jblogger.service.CommentService;
import com.jblogger.service.PostService;
//import com.jblogger.service.RoleService;
import com.jblogger.service.UserService;

@Service
public class EntityGenerator {
	
	@Autowired
	private UserService userService;
	
	//@Autowired
	//private RoleService roleService;
	
	@Autowired
	private AuthorityDao authorityDao;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private CommentService commentService;
	
	private String postBody = "<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam aliquet leo bibendum ultricies laoreet. Nam nec elit nibh. Curabitur non malesuada nunc. Curabitur luctus erat et odio vulputate consequat. Donec ut magna volutpat, tristique mauris sit amet, pharetra nibh. Nulla auctor leo vel tortor semper, et iaculis est vehicula. Nullam lobortis, mauris sed tempor malesuada, tellus lectus posuere nisi, non hendrerit quam magna ut leo. Cras et sapien gravida, malesuada sapien ac, elementum velit. Aenean at dolor at dui hendrerit porttitor ac ut nibh. Nunc vel justo sed tellus interdum vulputate. Vestibulum commodo felis eu egestas facilisis. Praesent convallis augue quis nibh venenatis pulvinar. Nulla laoreet at sapien quis euismod. Cras varius congue commodo.</p><p>Etiam ornare dapibus nibh at sodales. Sed porttitor pharetra turpis, in vulputate dolor congue et. Proin bibendum, libero a sollicitudin vulputate, nisl arcu tempor leo, id pellentesque purus purus et nibh. Integer vulputate lacinia arcu laoreet porttitor. Nulla id libero bibendum, porta tellus ac, interdum augue. Sed id accumsan arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae;</p><p>Aenean fringilla, orci ut venenatis pulvinar, nisl diam volutpat orci, eu scelerisque diam mauris in justo. Donec elementum aliquam magna a semper. Cras sodales tortor risus, at aliquet mauris hendrerit ut. Nunc luctus elit quis neque blandit rutrum. Nunc felis quam, gravida ut dui et, egestas tempus ante. Aenean suscipit faucibus mi a varius. Donec venenatis congue neque quis sagittis. Integer blandit hendrerit tortor, et fringilla lacus convallis sed. Suspendisse eget leo non metus commodo dictum. Integer vitae ante et urna dictum sollicitudin. Etiam cursus eleifend tellus at fermentum. Fusce ac arcu massa.</p>";
	
	public void generateDomain() {
		// User user = userDao.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		
		// Roles
		//Role admin = new Role("ADMIN");
		//Role user = new Role("USER");
		//roleService.createRole(admin);
		//roleService.createRole(user);
		
		// Authorities
		//Authority r = new Authority("richard", "ADMIN");
		//Authority s = new Authority("steve", "USER");
		//Authority j = new Authority("jessica", "USER");
		
		// Users (password is bcrypt for "password")
		// sha-256 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8
		User richard = new User("richard", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
		User steve = new User("steve", "password");
		User jessica = new User("jessica", "password");
		
		//richard.getAppAuthorities().add(new Authority("richard", "ADMIN"));
		//steve.getAppAuthorities().add(new Authority("steve", "USER"));
		//jessica.getAppAuthorities().add(new Authority("jessica", "USER"));
		
		
		userService.createUser(richard, new Authority("richard", "ADMIN"));
		userService.createUser(steve);
		userService.createUser(jessica);
		
		//Comment jess1 = new Comment("Comment 1", new Date());
		//commentService.createComment(c1);
		for(int i = 0; i < 100; i++) {
			Post p = new Post("An Article", postBody, randomDate());
			
			//p.getComments().add(c);
			postService.createPost(p);
			
			//Comment c1 = new Comment("Comment 1", new Date());
			//Comment c2 = new Comment("Comment 2", new Date());
			//Comment c3 = new Comment("Comment 3", new Date());
			//c1.setPost(p);
			//c1.setUser(richard);
			//c2.setPost(p);
			//c2.setUser(steve);
			//c3.setPost(p);
			//c3.setUser(jessica);
			//commentService.createComment(c1);
			//commentService.createComment(c2);
			//commentService.createComment(c3);
		}
	}
	
	public void deleteDomain() {
		
	}
	
	private Date randomDate() {
		int yyyy = random(2011, 2014);
		int mm = random(1, 12);
		int dd = 0;
		
		Set<Integer> thirtyOneDayMonths = new HashSet<Integer>(Arrays.asList(1,3,5,7,8,12));
		Set<Integer> thirtyDayMonths = new HashSet<Integer>(Arrays.asList(4,6,9,11));
		
		if (thirtyOneDayMonths.contains(mm)) {
			dd = random(1, 31);
		} else if (thirtyDayMonths.contains(mm)) {
			dd = random(1, 30);
		} else {
			if (isLeapYear(yyyy)) {
				dd = random(1, 28);
			} else {
				dd = random(1, 29);
			}
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(yyyy, mm, dd);
		return calendar.getTime();
	}
	
	private int random(int min, int max) {
		return (min + (int) Math.round(Math.random() * (max - min)));
	}
	
	private boolean isLeapYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		int noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		
		if (noOfDays > 365) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String... args) {
		EntityGenerator eg = new EntityGenerator();
		for(int i = 0; i < 10; i++) {
			System.out.println(eg.random(2011,  2014));
		}
	}
	
}

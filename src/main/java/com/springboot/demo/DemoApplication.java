package com.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.demo.service.UserService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello World!");
	}
	
	

	@Override
	public void run(String... args) throws Exception {
		//userService.createUser();
		
//		Insert Data
		
//		User user=new User("Sonu", "Sonu.sawany@gmail.com");
//		User userSaved =userRepo.save(user);
//		if(userSaved.getId()!=null) {
//		System.out.println(userSaved);
//		}
		
//		Featch All 
		
//		

//		Update data
		
//	Optional<User>	optionalUser=userRepo.findById(2L);
//	
//	User existingUser;
//	
//	if(optionalUser.isPresent()) {
//		//System.out.println(optionalUser.get());
//		existingUser=optionalUser.get();
//		existingUser.setEmail("vijay@gmail.com");
//		userRepo.save(existingUser);
//	}
//	else {
//		System.out.println("user not found");
//	}
//	
		
//		Delete  Data
		
		
//		userRepo.deleteById(3L);
		
//	Optional<User>optionalUser=	userRepo.findById(1L);
//		if(optionalUser.isPresent()) {
//		Address address=new Address();
//		address.setCity("Pune");
//		address.setLineOne("Saicare Hospital");
//		address.setPincode("412307");
//		address.setUser(optionalUser.get());
//		addressRepo.save(address);
//		}
//		
		
//		Address address1 = addressRepo.findById(1L).get();
//		
//		System.out.println(address1);
		
//		Category categoryOne=new Category("Electronic");
//		Category categoryTwo=new Category("Cloathings");
//		Category categoryThree=new Category("Stationery");
//		
//		List<Category> catList=new ArrayList<>();
//		
//		catList.add(categoryOne);
//		catList.add(categoryTwo);
//		catList.add(categoryThree);
//		
//		categoryRepo.saveAll(catList);
		
		
//		Product product1=new Product();
//		product1.setPname("Iphone");
//		product1.setCategory(categoryRepo.findById(1L).get());
//		product1.setPrice(BigDecimal.valueOf(125000));
//		
//		productRepository.save(product1);
		
//		Product product2=new Product();
//		product2.setPname("T-shirt");
//		product2.setCategory(categoryRepo.findById(2L).get());
//		product2.setPrice(BigDecimal.valueOf(250));
//		
//		productRepository.save(product2);
		
		
		
		
		
		
		
		
		
		
		
		
	}


}

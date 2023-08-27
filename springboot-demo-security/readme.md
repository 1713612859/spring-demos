## SpringSecurity 入门


### 

```java
		  // 使用 BCryptPasswordEncoder 进行加密
		  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		  // 加密
		  String rawPass = bCryptPasswordEncoder.encode("123456");
		  
		  System.out.println("rawPass = " + rawPass);
			
		  // matches() 
		  		// rawPassword : 密码
		  		// encodePassword 加密的中的密码
		  boolean isMatche = bCryptPasswordEncoder.matches("123456", rawPass);
		  System.out.println("isMatche = " + isMatche);
		  
		  //		  rawPass = $2a$10$HX3ji10D8GjxpDPOZ5v9vO/FxKL9hyfz1NaEpp6vTyU5lfH3c.5LK
		  //		  isMatche = true

```
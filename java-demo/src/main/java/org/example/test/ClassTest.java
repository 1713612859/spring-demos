package org.example.test;

/**
 * @CreateTime 11:21
 * @Desc ClassTest
 * @Author LiuYunLong
 */
class ClassTest {

	 private ClassTest initClassTest;

	 public ClassTest() {
//		  new ClassTest(null);
		  init();
	 }

	 private int age;


	 private Integer initCapcity = 16;

	 public int getAge() {
		  return age;
	 }

	 public void setAge(int age) {
		  this.age = age;
	 }

	 public static void main(String[] args) {
		  ClassTest classTest = new ClassTest();
	 }


	 void init() {
		  System.out.println("init");
		  System.out.println(getAge());
	 }

	 public ClassTest(int age) {
		  this.age = initCapcity;
	 }

}

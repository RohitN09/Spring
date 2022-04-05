package com.foobar;

public class Bar {
	String name;
	int age;
	Foo foo;
	
	public Bar() {
	}
	
	public Bar(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setFoo(Foo foo) {
		this.foo = foo;
	}
	
	public void processFooName() {
		System.out.println("Name in Injected Foo is: "+ foo.getName());
	}

	@Override
	public String toString() {
		return "Bar has name: " + this.name + " and age: " + this.age;
	}
}

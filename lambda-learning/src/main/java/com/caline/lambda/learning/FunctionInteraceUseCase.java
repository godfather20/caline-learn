package com.caline.lambda.learning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.caline.common.entity.Person;
import com.caline.common.interfaces.Handler;

public class FunctionInteraceUseCase {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Person person = new Person();
		handle(person,list,(x,i)->{
			x.setProp1(x.getProp1()+5);
			System.out.println("lambda打印："+i);
			System.out.println("没了");
		});//lambda表达式
		handle(person,list, (p,i)->{
			p.setProp2(p.getProp2()+2);
			System.out.println("lambda打印自增后的值："+ ++i);
		});
		
		//匿名类
		handle(person,list,new Handler() {
			
			@Override
			public void handle(Person p,int i) {
				System.out.println("匿名类打印："+i);
			}
		});
		handle(person,list,new Handler() {
			
			@Override
			public void handle(Person p,int i) {
				System.out.println("匿名类打印自增后的值："+ ++i);
			}
		});
	}
	
	public static void handle(Person person,Collection<Integer> ints,Handler handler) {
		if(ints!=null) {
			for(Integer i:ints) {
				handler.handle(person,i);
			}
		}
	}
}

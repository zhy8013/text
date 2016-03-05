package com.ysu.cn.json;

import com.google.gson.Gson;

/**
 * 将Java对象，格式化为json字符串
 * 
 * @author ZHY
 * 
 */
public class FormatDemo {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("张三");
		student.setAge(18);
		student.setSex(true);

		Gson gson = new Gson();
		String json = gson.toJson(student);
		System.out.println(json);

	}
}

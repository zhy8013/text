package com.ysu.cn.json;

import com.google.gson.Gson;

/**
 * ��Java���󣬸�ʽ��Ϊjson�ַ���
 * 
 * @author ZHY
 * 
 */
public class FormatDemo {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("����");
		student.setAge(18);
		student.setSex(true);

		Gson gson = new Gson();
		String json = gson.toJson(student);
		System.out.println(json);

	}
}

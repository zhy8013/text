package com.ysu.cn.json;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;

public class ParserDemo {
	public static void main(String[] args) {
		/**
		 * jsonת����ͨ����
		 */
		parser2Object();
		/**
		 * jsonת��List����
		 */
		parser2List();
		/**
		 * jsonת��Map
		 */
		parser2Map();
		/**
		 * json�ڵ����
		 */
		parserElement();

	}

	/**
	 * jsonת�� Ϊ�򵥶���
	 */
	private static void parser2Object() {

		String json = "{'name':'����','age':18,'sex':true}";

		Gson gson = new Gson();

		Student student = gson.fromJson(json, Student.class);
		System.out.println(student);
	}

	/**
	 * jsonת�ɼ���
	 */
	private static void parser2List() {
		String json = "[{'name':'С1','age':18,'sex':true},{'name':'С2','age':19,'sex':false},{'name':'С3','age':20,'sex':true},{'name':'С4','age':21,'sex':false},{'name':'С5','age':22,'sex':true}]";
		Gson gson = new Gson();
		TypeToken<List<Student>> token = new com.google.gson.reflect.TypeToken<List<Student>>() {
		};
		List<Student> list = gson.fromJson(json, token.getType());
		System.out.println(list);
	}

	/**
	 * jsonת��Map
	 */
	private static void parser2Map() {
		String json = "{'С3':{'name':'С3','age':20,'sex':true},'С4':{'name':'С4','age':21,'sex':false},'С5':{'name':'С5','age':22,'sex':true},'С1':{'name':'С1','age':18,'sex':true},'С2':{'name':'С2','age':19,'sex':false}}";
		Gson gson = new Gson();
		TypeToken<Map<String, Student>> token = new com.google.gson.reflect.TypeToken<Map<String, Student>>() {
		};
		Map<String, Student> map = gson.fromJson(json, token.getType());
		System.out.println(map);
	}

	/**
	 * json�ڵ����
	 */
	private static void parserElement() {
		// json �ڵ����
		String json = "{'flag':true,'data':{'name':'����','age':18,'sex':true}}";
		// 1.��� ������
		JsonParser parser = new JsonParser();
		// 2.��� ���ڵ�Ԫ��
		JsonElement element = parser.parse(json);
		// 3.���� �ĵ��жϸ��ڵ����� ʲô���͵� Gson�ڵ����
		JsonObject root = element.getAsJsonObject();
		// 4. ȡ�� �ڵ� �µ�ĳ���ڵ�� value
		JsonPrimitive flagJson = root.getAsJsonPrimitive("flag");
		boolean flag = flagJson.getAsBoolean();
		JsonObject dataJson = root.getAsJsonObject("data");
		Student student = new Gson().fromJson(dataJson, Student.class);
		System.out.println(flag);
		System.out.println(student);
	}
}

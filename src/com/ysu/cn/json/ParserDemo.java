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
		 * json转成普通对象
		 */
		parser2Object();
		/**
		 * json转成List集合
		 */
		parser2List();
		/**
		 * json转成Map
		 */
		parser2Map();
		/**
		 * json节点解析
		 */
		parserElement();

	}

	/**
	 * json转换 为简单对象
	 */
	private static void parser2Object() {

		String json = "{'name':'张三','age':18,'sex':true}";

		Gson gson = new Gson();

		Student student = gson.fromJson(json, Student.class);
		System.out.println(student);
	}

	/**
	 * json转成集合
	 */
	private static void parser2List() {
		String json = "[{'name':'小1','age':18,'sex':true},{'name':'小2','age':19,'sex':false},{'name':'小3','age':20,'sex':true},{'name':'小4','age':21,'sex':false},{'name':'小5','age':22,'sex':true}]";
		Gson gson = new Gson();
		TypeToken<List<Student>> token = new com.google.gson.reflect.TypeToken<List<Student>>() {
		};
		List<Student> list = gson.fromJson(json, token.getType());
		System.out.println(list);
	}

	/**
	 * json转成Map
	 */
	private static void parser2Map() {
		String json = "{'小3':{'name':'小3','age':20,'sex':true},'小4':{'name':'小4','age':21,'sex':false},'小5':{'name':'小5','age':22,'sex':true},'小1':{'name':'小1','age':18,'sex':true},'小2':{'name':'小2','age':19,'sex':false}}";
		Gson gson = new Gson();
		TypeToken<Map<String, Student>> token = new com.google.gson.reflect.TypeToken<Map<String, Student>>() {
		};
		Map<String, Student> map = gson.fromJson(json, token.getType());
		System.out.println(map);
	}

	/**
	 * json节点解析
	 */
	private static void parserElement() {
		// json 节点解析
		String json = "{'flag':true,'data':{'name':'张三','age':18,'sex':true}}";
		// 1.获得 解析者
		JsonParser parser = new JsonParser();
		// 2.获得 根节点元素
		JsonElement element = parser.parse(json);
		// 3.根据 文档判断根节点属于 什么类型的 Gson节点对象
		JsonObject root = element.getAsJsonObject();
		// 4. 取得 节点 下的某个节点的 value
		JsonPrimitive flagJson = root.getAsJsonPrimitive("flag");
		boolean flag = flagJson.getAsBoolean();
		JsonObject dataJson = root.getAsJsonObject("data");
		Student student = new Gson().fromJson(dataJson, Student.class);
		System.out.println(flag);
		System.out.println(student);
	}
}

package com.spoloborota.teaching.storage.type;

import java.util.HashMap;

public class MapStorage {   //
	public static String getMap;
	

	public String name;  						// ���� ����� 
	public HashMap<String, String> hashMap;		// �������� hashmap <������ , ������>
	
	public MapStorage(String name) {			// ����������� ��������� ��� � ����������� ��� ���� ������, ������������� hashmap
		this.name = name;
		hashMap = new HashMap<>();
	}
	
	public boolean add(String[] keyValue) {    	// ����� add ��������� ������ ,������ ���� 2 ������ ���.
		hashMap.put(keyValue[0], keyValue[1]);	// � hashmap ���������� ���� ������ �����, �������� ������
		return true;							// ������� true 
	}
	
	public boolean get(String name){
		getMap = hashMap.entrySet().toString();
		return true;
	}
	
}

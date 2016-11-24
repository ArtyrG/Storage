package com.spoloborota.teaching.storage.model;

import java.util.HashMap;
import java.util.Map;

import com.spoloborota.teaching.storage.type.MapStorage;

/**
 * All data saved to RAM memory first
 * @author Spoloborota
 *
 */
public class RAM {
	public Map<String, MapStorage> map;			// ��������� map 
	public MapStorage currentStorage = null;	// ������ currentStorage ������� MapStoraga = null. ������� ���������
	
	public RAM() {								// ����������� RAM, ������������� map hashmap'��  
		map = new HashMap<>();
	}
	
	/**
	 * Show all storages
	 * @return string with all storage names
	 */
	public String display() {					// ����� ������� 
		if (map.keySet().isEmpty()){			
			return "No Storages";				//���������� ������ "No Storages"  ���� ��� ������ map 
		}else{
		return map.keySet().toString();			// ���������� ����� ���� ������������ ������ map ���������� �� � ������
		}
		
	}
	
	/**
	 * Create new storage
	 * @param name - name of the creating storage
	 * @return "true" if all is Ok and "false" if storage with specified name already exists
	 */
	public boolean create(String name) {		// �������� ����� map � ��������� name 
		if (map.containsKey(name)) {			// �������� ���� �� ����� ���� 
			return false;						// ���� ���� false
		} else {
			map.put(name, new MapStorage(name));	// ���� ���, �� ��������� ���� name, � �������� �������� hashmap <string, string>
			return true;							// �������� � true �����
		}
	}
	
	/**
	 * Delete existing storage by name
	 * @param name
	 */
	public void delete(String name) {			// ����� delete ��������� ��� � �� ���������� ��������  
		MapStorage deleted = map.remove(name);	// ������� ������ MapStorage deleted = ������� ���� �� name. 
												//Remove ������ �������� ����������� ����� ��� null ���� ��� ����� �� ����� name  
		if (deleted.equals(currentStorage)) {	// �������� 
			currentStorage = null;
		}
	}
	
	/**
	 * Select existing storage by name to operate with it
	 * @param name
	 * @return - "true" if storage with such name exist and "false" otherwise
	 */
	public boolean use(String name) {			
		MapStorage mapStorage = map.get(name); // �������� ��������, �� ������� ��������� ���� ��� null 
		if (mapStorage != null) {
			currentStorage = mapStorage;		// ������ �������� = �������� map (hashmap)
			return true;
		} else {
			return false;
		}
	}
	
	public boolean list(String name){
		MapStorage mapStorage = map.get(name);
		if (currentStorage == mapStorage & currentStorage != null){
			return currentStorage.get(name);
		}else {
			return false;
		}
	}
	
	/**
	 * Add data to storage
	 * @param data
	 * @return - "true" if all is Ok and "false" if there is no selected storage 
	 */
	public boolean add(String[] data) {  // add ��������� ������ �����
		if (currentStorage != null) {	 // ���� ������� ��������� �������  
			return currentStorage.add(data); // �� � �������� map ��������� ���� 
		} else {
			return false;
		}
	}
}

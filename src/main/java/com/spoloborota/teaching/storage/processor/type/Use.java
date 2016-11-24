package com.spoloborota.teaching.storage.processor.type;

import com.spoloborota.teaching.storage.model.RAM;

public class Use {
	public static String process(RAM ram, String[] commandWords) {  // ��������� ������ �� ram � ������ �����
		boolean isSelected = ram.use(commandWords[1]);				// ������� ���������� boolean � �������� ����� use ������ RAM ��������� ���� ������ ����� ����� ������� use
		if (isSelected) {
			return "Selected storage: " + commandWords[1];    	// ���� ���� ����� ���� � map, �� true  
		} else {
			return "Storage with name " + commandWords[1] + " does not exist"; // ���� ��� ����� � map �� use ������ false
		}
	}
}

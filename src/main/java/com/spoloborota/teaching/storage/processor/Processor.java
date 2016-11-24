package com.spoloborota.teaching.storage.processor;

import com.spoloborota.teaching.storage.commands.Commands;
import com.spoloborota.teaching.storage.model.RAM;
import com.spoloborota.teaching.storage.processor.type.Add;
import com.spoloborota.teaching.storage.processor.type.Create;
import com.spoloborota.teaching.storage.processor.type.Display;
import com.spoloborota.teaching.storage.processor.type.List;
import com.spoloborota.teaching.storage.processor.type.Use;
import com.spoloborota.teaching.storage.type.MapStorage;

/**
 * process commands
 * @author Spoloborota
 *
 */
public class Processor {
	public RAM ram;
	
	public Processor(RAM ram) {
		this.ram = ram;
	}
	public String process(String commandString) {        // ����� ���������  �������
		String[] commandWords = commandString.trim().split("\\s+"); // commandString ������ ������ �����
		if (commandWords.length != 0) {
			for (String s : commandWords) {   // �������� ���� ������ ���� �� ����� != 0
				System.out.println(s);
			}
			
			String result = "";              // ������� ������ ������ ��������� 
			switch (commandWords[0]) {		// �.�. ������ �����[0] �������, �� ��� � � ��������� ����������
			case Commands.DISPLAY:			// ���� display �� ������ Commands 
				result = Display.process(ram); // �� �������� ����� process ������ Display, ��������� ���� ram 
				break;
		
			case Commands.USE:
				if (commandWords.length > 1) {  // ���� ���� ������, ������ ������� use �������� � ��������� ���� �� ��� ��� �����
					result = Use.process(ram, commandWords); // ���� ���� �� ������� process ������ Use ��������� ������ ram � ������ �������� ���� 
				} else {
					result = "Storage name does not specified"; // ��� ���� �������� ������ use
				}
				break;
				
			case Commands.LIST:
				if (commandWords.length > 1){
					result = List.process(ram, commandWords);
					MapStorage.getMap = null;
				}else {
					result = "Storage name does not specified";
				}
				break;
				
			case Commands.CREATE:
				if (commandWords.length > 1) {
					result = Create.process(ram, commandWords);
				} else {
					result = "Storage name does not specified";
				}
				break;
				
			case Commands.ADD:
				if (commandWords.length > 2) {                  // ����� ����� ������ ���� �������� ������� �������
					result = Add.process(ram, commandWords);					
				} else {
					result = "Data for storage does not specified correctly";
				}
				break;
				
			case Commands.SHUTDOWN:
				System.out.println("Good bye!");
				System.exit(0);						// ��� ������ �� RunTime 
			}
			return result;
		} else {
			return "You do not entered any comand";
		}
	}

}

package com.r2m.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SlotMachineService implements GameService {

	public static Integer slots = 3;
	public static Integer chances = 6;
	
	@Override
	public String[] bet(Object[] params) {
		
		String[] words = new String[slots];
		Random rm = new Random();
		int wordSlot = 0;
		
		for (int i = 0; i < slots; i++) {
			wordSlot = rm.nextInt(chances);
			if (wordSlot == 0) {
				words[i] = "Bars";
			} else if (wordSlot == 1) {
				words[i] = "Oranges";
			} else if (wordSlot == 2) {
				words[i] = "Bells";
			} else if (wordSlot == 3) {
				words[i] = "Bitcoin";
			} else if (wordSlot == 4) {
				words[i] = "Cherries";
			} else if (wordSlot == 5) {
				words[i] = "Melons";
			}
		}
		return words;
	}

}

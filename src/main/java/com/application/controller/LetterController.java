package com.application.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.entity.Letter;

@Controller
public class LetterController {

	@RequestMapping(value = "/letter")
	public String letterController(Model model) {

		String[] letterString = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
				"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

		Letter letter = null;

		ArrayList<Letter> letterArrayList = new ArrayList<Letter>();

		for (int id = 0; id < letterString.length; id++) {
			letter = new Letter();
			letter.setId(id + 1);
			letter.setLetter(letterString[id]);
			letterArrayList.add(letter);
		}

		model.addAttribute("letter", letterArrayList);

		return "letter";
	}
}

package gigroup.exercises.sudokugenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gigroup.exercises.sudokugenerator.service.SudokuGeneratorService;

@RestController
@RequestMapping("/api")
public class SudokuGeneratorController {

	@Autowired
	private SudokuGeneratorService sudokuGenerator;

	@GetMapping(path = "/generate")
	public int[][] getSudokuTable() {
		return sudokuGenerator.generate();
	}

}

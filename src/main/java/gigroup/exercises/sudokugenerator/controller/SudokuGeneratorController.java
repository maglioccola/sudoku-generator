package gigroup.exercises.sudokugenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gigroup.exercises.sudokugenerator.model.Params;
import gigroup.exercises.sudokugenerator.service.SudokuGeneratorService;

@RestController
@RequestMapping("/api")
public class SudokuGeneratorController {

	@Autowired
	private SudokuGeneratorService sudokuGenerator;

	@GetMapping(path = "/generate")
	@CrossOrigin(origins = "http://localhost:3000")
	public int[][] getSudokuTable() {
		return sudokuGenerator.generate();
	}

	@PostMapping(path = "/check")
	@CrossOrigin(origins = "http://localhost:3000")
	public boolean check(@RequestBody final Params params) {
		return sudokuGenerator.checkValue(params.getMatrix(), params.getRow(), params.getCol(), params.getNum());
	}

}

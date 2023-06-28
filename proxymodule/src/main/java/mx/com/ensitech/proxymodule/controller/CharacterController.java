package mx.com.ensitech.proxymodule.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ensitech.proxymodule.pojos.CharacterDetail;
import mx.com.ensitech.proxymodule.service.CharacterService;

@RestController
@RequestMapping("/characters/v1")
public class CharacterController {
	private static final Logger logger=LoggerFactory.getLogger(CharacterController.class);
	@Autowired
	private CharacterService characterService;
	
	@GetMapping("get/all")
	public List<CharacterDetail> getAllCharacters() {
		return characterService.getAllCharacters();
	}
	
	@GetMapping("get/byid/{characterId}")
	public CharacterDetail getCharacterById(@PathVariable("characterId") long characterId) {
		return characterService.getCharacterById(characterId);
	}
}

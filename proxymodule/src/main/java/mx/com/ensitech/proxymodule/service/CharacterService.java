package mx.com.ensitech.proxymodule.service;

import java.util.List;

import mx.com.ensitech.proxymodule.pojos.CharacterDetail;

public interface CharacterService {
	List<CharacterDetail> getAllCharacters();
	CharacterDetail getCharacterById(long characterId);
}
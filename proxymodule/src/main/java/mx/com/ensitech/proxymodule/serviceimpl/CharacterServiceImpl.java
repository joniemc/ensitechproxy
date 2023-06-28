package mx.com.ensitech.proxymodule.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import mx.com.ensitech.proxymodule.pojos.CharacterDetail;
import mx.com.ensitech.proxymodule.pojos.CharacterResponse;
import mx.com.ensitech.proxymodule.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService {
	private static final Logger logger = LoggerFactory.getLogger(CharacterServiceImpl.class);
	private RestTemplate restTemplate;
	private Gson gson;
	
	@Value("${external.api.base.url}")
    private String baseUrl;
	
	@Value("${external.api.characters.path}")
    private String charactersPath;
	
	@Value("${external.api.ts}")
    private String ts;
	
	@Value("${external.api.apikey}")
    private String apiKey;
	
	@Value("${external.api.hash}")
    private String hash;
	
	private @PostConstruct void init() {
		restTemplate = new RestTemplate();
		gson = new Gson();
	}
	
	@Override
	public List<CharacterDetail> getAllCharacters() {
		String appPath = baseUrl+charactersPath+"?ts="+ts+"&apikey="+apiKey+"&hash="+hash;
		List<CharacterDetail> response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            ResponseEntity<String> externalServiceResponse = restTemplate.exchange(appPath, HttpMethod.GET, null, String.class);
            
            if(externalServiceResponse.getStatusCode().is2xxSuccessful()) {
            	String json = externalServiceResponse.getBody();
            	CharacterResponse res= gson.fromJson(json, CharacterResponse.class);
            	response = res.getData().getResults();
            }
		}catch(Exception ex) {
			logger.info(ex.getMessage());
		}
		
		return response;
	}

	@Override
	public CharacterDetail getCharacterById(long characterId) {
		String appPath = baseUrl+charactersPath+"/"+characterId+"?ts="+ts+"&apikey="+apiKey+"&hash="+hash;
		CharacterDetail response = null;
		try {
			HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            ResponseEntity<String> externalServiceResponse = restTemplate.exchange(appPath, HttpMethod.GET, null, String.class);
            
            if(externalServiceResponse.getStatusCode().is2xxSuccessful()) {
            	String json = externalServiceResponse.getBody();
            	CharacterResponse res= gson.fromJson(json, CharacterResponse.class);
            	Optional<CharacterDetail> firstCharacter = res.getData().getResults().stream().findFirst();
            	
            	if(firstCharacter.isPresent()) {
            		response=firstCharacter.get();
            	}
            	
            }
		}catch(Exception ex) {
			logger.info(ex.getMessage());
		}
		return response;
	}
	
}

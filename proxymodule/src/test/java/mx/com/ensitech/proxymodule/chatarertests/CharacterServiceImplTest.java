package mx.com.ensitech.proxymodule.chatarertests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import mx.com.ensitech.proxymodule.serviceimpl.CharacterServiceImpl;

public class CharacterServiceImplTest {
	@Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CharacterServiceImpl characterService;

    private long characterId;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(characterService, "baseUrl", "https://gateway.marvel.com:443");
        ReflectionTestUtils.setField(characterService, "charactersPath", "/v1/public/characters");
        ReflectionTestUtils.setField(characterService, "ts", "1");
        ReflectionTestUtils.setField(characterService, "apiKey", "4381496f3eef33e6baf39c290cabc235");
        ReflectionTestUtils.setField(characterService, "hash", "9082aadc85744dff7dae621c6cf727c1");
        Gson gson = new Gson();
        ReflectionTestUtils.setField(characterService, "gson", gson);
        characterId = 1011334;
    }
    
    @Test
    void testGetAllCharaters() {}
    
    @Test
    void testGetCharaterById() {}
    
}

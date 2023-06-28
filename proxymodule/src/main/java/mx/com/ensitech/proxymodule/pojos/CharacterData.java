package mx.com.ensitech.proxymodule.pojos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CharacterData {
	private int offset;
    private int limit;
    private int total;
    private int count;
    private List<CharacterDetail> results;
}

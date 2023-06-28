package mx.com.ensitech.proxymodule.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class Item {
	private String resourceURI;
    private String name;
}

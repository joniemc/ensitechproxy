package mx.com.ensitech.proxymodule.pojos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class GenericType {
	private int available;
    private String collectionURI;
    private List<Item> items;
    private int returned;
}

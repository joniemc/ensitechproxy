package mx.com.ensitech.proxymodule.pojos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CharacterDetail {
	private int id;
    private String name;
    private String description;
    private String modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private GenericType comics;
    private GenericType series;
    private GenericType stories;
    private GenericType events;
    private List<UrlDetail> urls;
}

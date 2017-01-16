package JavaBeans;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gaurav on 14/01/17.
*/
public class EntityEntry implements Serializable{



    @SerializedName("value")
    private String value;

    @SerializedName("synonyms")
    private List<String> synonyms;

    public EntityEntry() {
    }

    public EntityEntry(final String value) {
        this.value = value;
    }

    public EntityEntry(final String value, final List<String> synonyms) {
        this.value = value;
        this.synonyms = synonyms;
    }



    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(final List<String> synonyms) {
        this.synonyms = synonyms;
    }
}
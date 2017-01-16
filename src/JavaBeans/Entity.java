package JavaBeans;


import com.google.gson.annotations.SerializedName;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Gaurav on 14/01/17.
 */

public class Entity implements Serializable{



    @SerializedName("name")
    private String name;

    @SerializedName("entries")
    private List<EntityEntry> entries;

    @SerializedName("extend")
    private Boolean extend;

    @SerializedName("isEnum")
    private Boolean isEnum;

    public Entity() {
    }

    public Entity(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<EntityEntry> getEntries() {
        return entries;
    }

    public void setEntries(String csvFile) {
        System.out.println("In setEntries");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            String line;
            String cvsSplitBy = ",";
            List<EntityEntry> abc=new ArrayList<>();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] wordsString = line.split(cvsSplitBy);
                List<String> words= Arrays.asList(wordsString);

                System.out.println("the size is "+words.size());
                if (words.size()==1) {
                    this.entries.add(new EntityEntry(words.get(0)));
                }
                else{
                    abc.add(new EntityEntry(words.get(0),words.subList(1,words.size())));
                    //System.out.println(a);
                    //this.entries.add(abc);
                    System.out.println("hiqaz");
                }

            }
        this.entries=abc;

        } catch (IOException e) {
            e.printStackTrace();

        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    public void setEntries(final List<EntityEntry> entries) {
        this.entries = entries;
    }

    public void addEntry(final EntityEntry entry) {
        if (entries == null) {
            entries = new ArrayList<>();
        }
        entries.add(entry);
    }

    public Boolean getExtend() {
        return extend;
    }

    public void setExtend(final boolean extend) {
        this.extend = extend;
    }

    public Boolean isEnum() {
        return isEnum;
    }

    public void setIsEnum(final Boolean isEnum) {
        this.isEnum = isEnum;
    }
}

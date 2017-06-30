package bean;

import java.sql.Date;

/**
 * Created by Administrator on 2017/6/27 0027.
 */
public class Add {
    private int id;
    private String name;
    private String description;
    private Date insertTime;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getInsertTime() {
        return insertTime;
    }
}

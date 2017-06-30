package bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

/**
 * Created by Administrator on 2017/6/26 0026.
 */
public class User {
    private int id;
    private String name;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd" , timezone = "GMT+8")
    private String insertTime;
    private static SerializeConfig mapping = new SerializeConfig();
    private static String dateFormat;
    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        String str = JSON.toJSONString(insertTime, SerializerFeature.WriteDateUseDateFormat);
        System.err.println(insertTime);
        this.insertTime =str;
    }

}

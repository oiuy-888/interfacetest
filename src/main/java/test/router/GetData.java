package test.router;
import com.jayway.jsonpath.JsonPath;

import java.util.HashMap;

public class GetData {

    private String dir = "/data/";

    public HashMap<String, String> getpara(String type){
        String body = JsonPath.parse(this.getClass().getResourceAsStream(dir+type+".json")).jsonString();
        HashMap<String,String> data = JsonPath.read(body, "$.case.parameter");
        return data;
    }

    public HashMap<String, String> getresult(String type){
        String body = JsonPath.parse(this.getClass().getResourceAsStream(dir+type+".json")).jsonString();
        HashMap<String,String> data = JsonPath.read(body, "$.case.result");
        return data;
    }

    public String getdata(String type,String para){
        String body = JsonPath.parse(this.getClass().getResourceAsStream(dir+type+".json")).jsonString();
        String data = JsonPath.read(body, "$."+para);
        return data;
    }

    public int getjsonnumber(String type){
        String body = JsonPath.parse(GetData.class.getResourceAsStream(dir+type+".json")).jsonString();
        int length = JsonPath.read(body,"$.user.length()");
        return length;
    }
}

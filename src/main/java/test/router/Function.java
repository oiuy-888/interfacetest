package test.router;

import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.request;
import static org.hamcrest.Matchers.equalTo;

public class Function {

    public RequestSpecification requestSpecification;
    private Encryption encryption = new Encryption();
    private GetData getData = new GetData();

    public void reset(){
        requestSpecification = given().log().all();
    }

    public RequestSpecification send(String huanjing,String type){
        reset();
        if(getData.getdata(type,"method").equals("post")){
            requestSpecification.header("Content-Type", "application/json;charset=UTF-8")
                                    .body(getData.getpara(type));
        }if(getData.getdata(type,"method").equals("get")){
            getData.getpara(type).entrySet().forEach(
                    entry->{
                        if(entry.getKey().equals("sign")){
                            requestSpecification.queryParam(entry.getKey(),encryption.Md5(huanjing,type));
                        }else {
                            requestSpecification.queryParam(entry.getKey(),entry.getValue());
                        }
                    });
        }
        return requestSpecification;
    }

    public void check(String huanjing,String type){
        String str1;
        Response response = send(huanjing,type).when().request(getData.getdata(type,"method"),getData.getdata(huanjing,"ip")+getData.getdata(type,"url"));
        str1 = response.asString();
        printlog(str1);
        getData.getresult(type).entrySet().forEach(
                entry->{
                    response.then().body(entry.getKey(),equalTo(entry.getValue()));
                });
    }

    @Step("展示信息：{para}")
    public void printlog(String para){
        //todo:在allure的步骤中打印日志信息
    }

}
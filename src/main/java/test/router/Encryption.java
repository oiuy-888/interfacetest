package test.router;

import com.wjika.test.mymd5;

public class Encryption {

    private mymd5 md5= new mymd5();
    private GetData getData = new GetData();

    /**
     * 此处的sign和key字段名为定值
     */
    public String content(String huanjing,String type){
        String result = "";
        String key = "";
        String str = getData.getpara(type).get("sign");
        if(str.equals("0")){
        }else{
            String[] para = str.split(",");
            int length = para.length;
            for (int i=0;i<length;i++){
                result += para[i]+getData.getpara(type).get(para[i]);

                if(para[i].equals("account")){
                    for (int j=0;j<getData.getjsonnumber(huanjing);j++){
                        if(getData.getpara(type).get(para[i]).equals(getData.getdata(huanjing,"user["+j+"].account"))){
                            key = getData.getdata(huanjing,"user["+j+"].key");
                            break;
                        }
                    }
                }
            }
            result += key;
        }
        return result;
    }

    public String Md5(String huanjing,String type){
        String text = content(huanjing,type);
        String str = md5.getMd5(text);
        return str;
    }


}

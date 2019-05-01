# interfacetest
单一接口功能测试

1.报告生成方式
使用allure语句在powershell命令行键入（在项目当前目录）

allure serve allure-results
生成测试报告

2.测试用例在resource目录下添加
如接口289，用例数据为1.json、2.json等
{
  "url":"/data-service/router/telecom/identity/3mo/t1",
  "method":"get",
  "case":
    {
      "parameter":{
        "account": "apilishuai",
        "name": "朱斌",
        "cid":"330324199302103692",
        "cidType":"1",
        "mobile":"13092260599",
        "reqId":"qwe123",
        "sid":"32rd232f4",
        "mobileType":"",
        "sign":"account,cid,mobile,name,reqId"
      },
      "result":{
        "resCode":"2061",
        "resMsg": "号码不存在"
      }
    }
}
其中url为接口请求地址，method为接口请求方式（目前只支持get\post），parameter为请求中的参数（sign中为需要顺序md5加密的参数字段），result为结果验证字段

3.测试执行脚本序号在testcase.csv中添加
添加形式为
环境, 用例
test,540/5
test,289/1
test,289/2

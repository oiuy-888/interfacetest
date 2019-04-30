package test.router;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.beans.DesignMode;

class FunctionTest {

    Function fuction = new Function();
    GetData getData = new GetData();

    @DisplayName("独立接口响应测试")
    @ParameterizedTest(name = "{index}执行接口用例{1}---执行环境{0}")
    @CsvFileSource(resources = "/data/testcase.csv",numLinesToSkip = 1)
    public void demo(String huanjing,String type) throws Exception{
        fuction.check(huanjing,type);
    }

}
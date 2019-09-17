package root.code.dto;

import lombok.Data;

@Data
public class FindRegister {
    //年份
    private String year;
    //考生号
    private String testNumber;
    //身份证
    private String cardId;
    //姓名
    private String name;
    //专业
    private String major;
}

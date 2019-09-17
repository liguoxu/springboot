package root.code.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("register")
/**
 * 录取
 */
public class Register {

    //录取id
    private String registerId;
    //考生号
    private String testNumber;
    //身份证
    private String cardId;
    //姓名
    private String name;
    //专业
    private String major;
    //培养方式
    private String culture;
    //省市
    private String province;
    //学院
    private String college;
    //学制
    private String educationalSystem;
    //校区
    private String campus;
    //ESM详单号
    private String esm;
    //年份
    private String year;
}

package root.code.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("fractionalLine")
/**
 * 分数线
 */
public class FractionalLine {

    //主键
    private String fractionalLineId;
    //年份
    private String year;
    //省份
    private String province;
    //科目
    private String subject;
    //专业
    private String major;
    //录取分数线
    private String fraction;
}

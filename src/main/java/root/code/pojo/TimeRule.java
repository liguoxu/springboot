package root.code.pojo;

import lombok.Data;

import java.util.Date;

@Data
/**
 *时间规则
 */
public class TimeRule {

    //规则ID
    private String ruleId;

    //规则类型
    private int ruleType;

    //开始时间
    private Date beginTime;

    //结束时间
    private Date endTime;

    //查看年限
    private String findYear;

}

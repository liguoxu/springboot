package root.code.dto;

import lombok.Data;

@Data
public class ResultInfo<T> {

    private int code;
    private String msg;
    private T object;

}

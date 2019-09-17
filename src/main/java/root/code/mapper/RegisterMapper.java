package root.code.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import root.code.pojo.FractionalLine;
import root.code.pojo.Register;

import java.util.List;

@Repository("registerMapper")
@Mapper
public interface RegisterMapper {

    public Register findRegister(Register register);
}

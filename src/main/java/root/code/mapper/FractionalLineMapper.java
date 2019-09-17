package root.code.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import root.code.pojo.FractionalLine;

import java.util.List;

@Repository("fractionalLineMapper")
@Mapper
public interface FractionalLineMapper {

    public List<FractionalLine> findFranctionalLine(FractionalLine fractionalLine);

    public List<String> findTotalYears();

    public List<String> findTotalProvinces();
}

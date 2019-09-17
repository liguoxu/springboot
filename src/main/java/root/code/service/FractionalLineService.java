package root.code.service;

import org.springframework.web.multipart.MultipartFile;
import root.code.dto.ResultInfo;
import root.code.pojo.FractionalLine;

import java.util.List;

public interface FractionalLineService {

    public List<FractionalLine> findFranctionalLine(FractionalLine fractionalLine);

    public List<String> findTotalYears();

    public List<String> findTotalProvinces();

    public ResultInfo readFranctionalExcel(MultipartFile file);
}

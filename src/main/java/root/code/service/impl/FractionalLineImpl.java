package root.code.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import root.code.dto.ResultInfo;
import root.code.mapper.FractionalLineMapper;
import root.code.pojo.FractionalLine;
import root.code.resultCode.ResultCode;
import root.code.service.FractionalLineService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service("fractionalLine")
@Slf4j
public class FractionalLineImpl implements FractionalLineService {

    @Autowired
    @Qualifier("fractionalLineMapper")
    private FractionalLineMapper fractionalLineMapper;

    public List<FractionalLine> findFranctionalLine(FractionalLine fractionalLine){
        log.info(fractionalLine.toString());
        return fractionalLineMapper.findFranctionalLine(fractionalLine);
    }

    @Override
    public List<String> findTotalYears() {
        return fractionalLineMapper.findTotalYears();
    }

    @Override
    public List<String> findTotalProvinces() {
        return fractionalLineMapper.findTotalProvinces();
    }

    @Override
    public ResultInfo readFranctionalExcel(MultipartFile file) {
        ResultInfo resultInfo = new ResultInfo();

        // 获取文件名
        String fileName = file.getOriginalFilename()+"";
        //文件不是Excel
        if(fileName.length()<1 && fileName.indexOf(".xls")==-1){
            resultInfo.setCode(ResultCode.FILE_NOT_EXCEL.getCode());
            resultInfo.setMsg(ResultCode.FILE_NOT_EXCEL.getMsg());
            return resultInfo;
        }
        Workbook wb = null;
        try{
            if (fileName.matches("^.+\\.(?i)(xls)$")) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(file.getInputStream());
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(file.getInputStream());
            }
        }catch(IOException io){
            //文件读取错误
            resultInfo.setCode(ResultCode.IO_READ_ERROR.getCode());
            resultInfo.setMsg(ResultCode.IO_READ_ERROR.getMsg());
            return resultInfo;
        }
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        int totalCells = 0;
        if (totalRows > 1 && sheet.getRow(0) != null) {
            totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<FractionalLine> lf = new ArrayList<FractionalLine>();
        // 循环Excel行数
        for(int line = 0; line<totalRows; line++){
            Row row = sheet.getRow(line);
            if(row == null)
                continue;
            // 循环Excel的列
            for (int conlum = 0; conlum < totalCells; conlum++) {
                Cell cell = row.getCell(conlum);
                if (null != cell) {

                }
            }
        }
        resultInfo.setCode(ResultCode.SUCCESS.getCode());
        resultInfo.setMsg(ResultCode.SUCCESS.getMsg());
        return null;
    }
}

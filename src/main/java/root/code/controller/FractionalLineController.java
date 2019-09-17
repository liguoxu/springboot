package root.code.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import root.code.dto.ResultInfo;
import root.code.pojo.FractionalLine;
import root.code.service.FractionalLineService;

import java.util.List;

@Controller
@Slf4j
public class FractionalLineController {

    @Autowired
    @Qualifier("fractionalLine")
    private FractionalLineService fractionalLineService;

    @RequestMapping("/dispatcherFractionalLine")
    public ModelAndView dispatcherFractionalLine() {
        ModelAndView modelAndView = new ModelAndView("FractionalLine");
        modelAndView.addObject("years", fractionalLineService.findTotalYears());
        modelAndView.addObject("provinces", fractionalLineService.findTotalProvinces());
        return modelAndView;
    }

    @RequestMapping("/findFranctionalLine")
    public @ResponseBody List<FractionalLine> findFranctionalLine(FractionalLine fractionalLine){
        return fractionalLineService.findFranctionalLine(fractionalLine);
    }

    @RequestMapping("/readFranctionalExcel")
    public @ResponseBody
    ResultInfo readFranctionalExcel(@RequestParam(value="file",required = true) MultipartFile file){
        return fractionalLineService.readFranctionalExcel(file);
    }
}

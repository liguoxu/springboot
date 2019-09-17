package root.code.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import root.code.dto.FindRegister;
import root.code.dto.ResultInfo;
import root.code.mapper.RegisterMapper;
import root.code.pojo.Register;
import root.code.resultCode.ResultCode;
import root.code.service.RegisterService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service("register")
@Slf4j
public class RegisterImpl implements RegisterService {

    @Autowired
    @Qualifier("registerMapper")
    private RegisterMapper registerMapper;

    @Override
    public ResultInfo<FindRegister> findRegister(Register register, String checkCode, HttpServletRequest request) {
        ResultInfo<FindRegister> resultInfo = new ResultInfo();
        FindRegister findRegister = new FindRegister();
        String resourceCode = (String) request.getSession().getAttribute("checkCode");
        log.info(resourceCode);
        //校验验证码
        if(!resourceCode.equals(checkCode)){
            resultInfo.setCode(ResultCode.CHECK_CODE_ERROE.getCode());
            resultInfo.setMsg(ResultCode.CHECK_CODE_ERROE.getMsg());
            return resultInfo;
        }
        //重新校验考生号
        String testNumber = register.getTestNumber().trim()+"";
        if(testNumber.length()<1){
            resultInfo.setCode(ResultCode.TEST_NUMBER_ERROR.getCode());
            resultInfo.setMsg(ResultCode.TEST_NUMBER_ERROR.getMsg());
            return resultInfo;
        }
        register.setTestNumber(testNumber);
        //重新校验身份证格式
        String cardId = register.getCardId().trim()+"";
        if(!cardId.matches("\\d{15}(\\d{2}[0-9xX])?")||cardId.length()<18){
            resultInfo.setCode(ResultCode.CARD_ID_ERROR.getCode());
            resultInfo.setMsg(ResultCode.CARD_ID_ERROR.getMsg());
            return resultInfo;
        }
        register.setCardId(cardId);
        register = registerMapper.findRegister(register);
        findRegister.setCardId(register.getCardId());
        findRegister.setMajor(register.getMajor());
        findRegister.setName(register.getName());
        findRegister.setTestNumber(register.getTestNumber());
        findRegister.setYear(register.getYear());

        resultInfo.setCode(ResultCode.SUCCESS.getCode());
        resultInfo.setMsg(ResultCode.SUCCESS.getMsg());
        resultInfo.setObject(findRegister);
        log.info(resultInfo.toString());
        return resultInfo;
    }

    @Override
    public void checkCodeImage(HttpServletRequest request, HttpServletResponse response) {
        // 设置图片宽度和高度
        int width = 70;
        int height = 30;
        // 干扰线条数
        int lines = 0;
        // 验证码数组
        int[] random = new int[4];
        // 定义用户保存验证码
        String sysCode = "";
        Random r = new Random();
        BufferedImage b = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        Graphics g = b.getGraphics();
        g.setFont(new Font("宋体", Font.BOLD, 30));
        for (int i = 0; i < 4; i++) {
            int number = r.nextInt(10);
            random[i] = number;
            int y = 25 + r.nextInt(10);// 10~40范围内的一个整数，作为y坐标
            // 随机颜色，RGB模式
            Color c = new Color(r.nextInt(100)+100, r.nextInt(150)+88, r.nextInt(255)+1);
            g.setColor(c);
            // g.drawString("" + a, 5 + i * width / 4, y);
            // 写验证码
            g.drawString(Integer.toString(number), 5 + i * width / 4, y);
            sysCode += random[i];
        }
        request.getSession().setAttribute("checkCode", sysCode);

        for (int i = 0; i < lines; i++) {
            // 设置干扰线颜色
            Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
            g.setColor(c);
            g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width),
                    r.nextInt(height));
        }
        try {
            // 清空缓冲
            g.dispose();
            // 向文件中写入
            // ImageIO.write(b, "jpg", new File("F:\\image\\test.jpg"));

            ImageIO.write(b, "JPEG", response.getOutputStream());
            // ImageIO.write(b, "jpg", new File("./WebContent/aaa/test.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

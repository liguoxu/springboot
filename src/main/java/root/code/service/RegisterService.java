package root.code.service;

import root.code.dto.FindRegister;
import root.code.dto.ResultInfo;
import root.code.pojo.Register;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface RegisterService {

    public ResultInfo<FindRegister> findRegister(Register register, String checkCode, HttpServletRequest request);

    public void checkCodeImage(HttpServletRequest request, HttpServletResponse response);
}

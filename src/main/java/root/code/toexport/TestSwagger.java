//package root.code.toexport;
//
//import io.swagger.annotations.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 对外提供接口
// * 用于测试Swagger
// */
//@Slf4j
//@Controller("/TestSwagger")
//@Api(tags = {"TestSwagger.class"}, description="学生信息操作类")
//public class TestSwagger {
//
//    /*
//        这里面的tags会将该方法多拆一个分组放入第一层树中，heepMethod参数可以标明请求方式，heepMethod也可以自动读取
//        @RequestMapping中的method参数，如果两个都没标明请求方式那么该接口会生成多条的请求方式记录
//    */
//    @ApiOperation(value = "获取单个学生信息", notes = "需要查询学生的ID", httpMethod="POST")
//    @ApiResponses({
//            @ApiResponse(code=57,message="服务器出错"),
//            @ApiResponse(code=400,message="请求参数没填好"),
//            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
//    })
//    @RequestMapping(value = "/findStudentInfo/{studentId}", method = RequestMethod.GET)
//    public @ResponseBody Student findStudentInfo(@ApiParam(name="studentId", value="学生id", required=true, type="String")@PathVariable String studentId, HttpServletRequest request, HttpServletResponse response){
//        Student student = new Student();
//        student.setId("11");
//        student.setUserName("liguoxu");
//        student.setPassWord("lalal");
//        return student;
//    }
//
//    @RequestMapping(value = "/deleteStudentById/{studentId}", method = RequestMethod.DELETE)
//    public Student deleteStudentById(@PathVariable String studentId, HttpServletRequest request, HttpServletResponse response){
//        Student student = new Student();
//        return student;
//    }
//}

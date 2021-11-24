package x.x.swagger.demo.controller;

import io.swagger.annotations.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import x.x.swagger.demo.model.Student;

/**
 * 首页Controller
 */
@Api(tags = "首页Controller")
@Controller
public class IndexController {

    @ApiOperation(value = "跳转到首页")
    @ResponseBody
    @GetMapping("/")
    public String root() {
        return "<a href='http://localhost:8080/student/delete?id=2'>删除学生</a>";
    }


    /**
     * 添加学生
     */
    @ApiOperation(value = "添加学生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "编号", required = true),
            @ApiImplicitParam(name = "name", value = "姓名", required = true),
            @ApiImplicitParam(name = "age", value = "年龄", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 408, message = "指定业务得报错信息，返回客户端"),
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/add")
    public Student add(Integer id, String name, Integer age) {
        return new Student(id, name, age);
    }
}
package cn.yizhoucp.controller;
import cn.yizhoucp.model.dataobject.StudentDO;
import cn.yizhoucp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
public class DemoController {
    @Resource
    private StudentService studentService;

//    @ResponseBody
    @RequestMapping("/save")
    public StudentDO saveStudent(@RequestParam("name") String name,@RequestParam("age") Long age,@RequestParam("sex") String sexType){
        StudentDO student = studentService.save(name,age);
        return student;
    }

//    @ResponseBody
    @GetMapping("getUser/{id}")
    public HashMap<String, String> getUser(@PathVariable Long id){
        HashMap student = studentService.findOne(id);
        return student;
    }

//    @ResponseBody
    @RequestMapping("/findAll")
    public String findStudents(){
        List<StudentDO> all=studentService.findAll();
        for (StudentDO studentDO : all) {
            System.out.println("输出的数据是："+studentDO.getName());
        }
        return "成功";
    }

    @ResponseBody
    @GetMapping("/getAge")
    public List<StudentDO> findStudentAgeThanEqual(@RequestParam("age")Long age){
        return studentService.findByAgeGreaterThanEqual(age);
    }
}

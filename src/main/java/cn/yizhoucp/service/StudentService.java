package cn.yizhoucp.service;

import cn.yizhoucp.model.dao.StudentJpaDao;
import cn.yizhoucp.model.dataobject.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentJpaDao studentJpaDao;

    @Transactional
    public StudentDO save(String name, Long age){
        StudentDO  studentDO = new StudentDO();
        studentDO.setName(name);
        studentDO.setAge(Math.toIntExact(age));
        StudentDO student =studentJpaDao.save(studentDO);
        return student;
    }

    /**
     * 获取单个用户
     * @param id  学生id
     * @return map
     */
    public HashMap<String, String> findOne(Long id){
        HashMap<String,String> studentmap = new HashMap<String,String>();
        StudentDO student = studentJpaDao.getOne(id);
        try {

            studentmap.put("name",student.getName());
        }catch (Exception e){
            return studentmap;
        }
        Long idLo = student.getId();
        studentmap.put("id",idLo.toString());
        return  studentmap;
    }

    /**
     * 获取所有的学生信息
     * @return  StudentDO
     */
    public List<StudentDO> findAll(){
        return studentJpaDao.findAll();
    }

    /**
     * @param age  用户年龄
     * @return 返回用户对下 StudentDO
     */
    public List<StudentDO> findByAgeGreaterThanEqual(Long age){
        return studentJpaDao.findByAgeGreaterThanEqual(age);
    }
}

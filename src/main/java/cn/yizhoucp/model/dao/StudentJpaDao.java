package cn.yizhoucp.model.dao;

import cn.yizhoucp.model.dataobject.StudentDO;
//import com.sun.tools.javac.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentJpaDao extends JpaRepository<StudentDO,Long> {

//    StudentDO findOne();

//    List<StudentDO> findAll();

    List<StudentDO> findByName(String name);

    @Transactional
    @Query(value = "select * from student where age>?1", nativeQuery = true)
    List<StudentDO> findByAgeGreaterThanEqual(Long age);

    @Transactional
    @Modifying
    @Query(value = "update user set name=?2 where id=?1",nativeQuery = true)
    Integer updateNameById(Long id,String name);

//    @Transactional
//    @Modifying
//    @Query("update user set name=?2,age=?3 where id=?1",nativeQuery = true)
//    Integer updateNameAndAgeById(Long id,String name,Long age);
}

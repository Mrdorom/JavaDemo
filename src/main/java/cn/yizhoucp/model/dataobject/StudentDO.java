package cn.yizhoucp.model.dataobject;

import cn.yizhoucp.constant.enums.SexType;

import javax.persistence.*;


/**
 * 学生表
 */
@Entity
@Table(name = "student")
@org.hibernate.annotations.Table(appliesTo = "student",comment = "学生表")
public class StudentDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    public void setSexType(SexType sexType) {
        this.sexType = sexType;
    }

    /**
     * 用户性别
     */
    @Enumerated(EnumType.ORDINAL)
//    @Column(name = "sex",columnDefinition = " int(11),comment '性别'")
    private SexType sexType = SexType.MAN;

    /**
     * 用户名称
     */
//    @Column(name = "name",nullable = false,columnDefinition = "varchar(100), comment '用户名称'")
    private String name;

    /**
     * 年龄
     */
//    @Column(name = "age",columnDefinition = "comment '用户年龄'")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SexType getSexType() {
        return sexType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

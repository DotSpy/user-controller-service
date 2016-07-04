package com.oxagile.model.database;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_department")
public class DepartmentDb implements Serializable {

    @Id
//    @GenericGenerator(name="generator", strategy="increment")
//    @GeneratedValue(generator="generator")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_name")
    private String name;

    public DepartmentDb() {
    }

    public DepartmentDb(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

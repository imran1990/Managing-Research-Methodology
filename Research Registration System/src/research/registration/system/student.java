/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package research.registration.system;

/**
 *
 * @author shuvo
 */
public class student {
    private Integer id;
    private String name;
    private String pass;

    public student(Integer id, String name, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public student(Integer id, String pass) {
        this.id = id;
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name=" + name + ", pass=" + pass + '}';
    }
    
    
}

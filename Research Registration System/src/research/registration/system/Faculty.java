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
public class Faculty {
    private String facultyinitial;
    private String password;

    public Faculty(String facultyinitial, String password) {
        this.facultyinitial = facultyinitial;
        this.password = password;
    }

    public String getFacultyinitial() {
        return facultyinitial;
    }

    public String getPassword() {
        return password;
    }
    
    
}

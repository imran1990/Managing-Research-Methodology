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
public class Chairman {
     private String initial;
     private String password;

    public Chairman(String initial, String password) {
        this.initial = initial;
        this.password = password;
    }

    public String getInitial() {
        return initial;
    }

    public String getPassword() {
        return password;
    }
     
}

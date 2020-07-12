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
public class Registration {
    
    private String supervisorinitial;
    private String topicname;
    private Integer id1;
    private Integer id2;
    private Integer id3;
    private String  status;
    private String cmsg;

    public Registration(String supervisorinitial, String topicname, Integer id1, Integer id2, Integer id3, String status, String cmsg) {
        this.supervisorinitial = supervisorinitial;
        this.topicname = topicname;
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
        this.status = status;
        this.cmsg = cmsg;
    }

 

    public String getSupervisorinitial() {
        return supervisorinitial;
    }

    public String getTopicname() {
        return topicname;
    }

    public Integer getId1() {
        return id1;
    }

    public Integer getId2() {
        return id2;
    }

    public Integer getId3() {
        return id3;
    }

    public void setSupervisorinitial(String supervisorinitial) {
        this.supervisorinitial = supervisorinitial;
    }

    public void setTopicname(String topicname) {
        this.topicname = topicname;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public void setId2(Integer id2) {
        this.id2 = id2;
    }

    public void setId3(Integer id3) {
        this.id3 = id3;
    }

    public String getCmsg() {
        return cmsg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Registration{" + "supervisorinitial=" + supervisorinitial + ", topicname=" + topicname + ", id1=" + id1 + ", id2=" + id2 + ", id3=" + id3 + ", status=" + status + '}';
    }

    public Registration(String supervisorinitial, String topicname, Integer id1, Integer id2, Integer id3) {
        this.supervisorinitial = supervisorinitial;
        this.topicname = topicname;
        this.id1 = id1;
        this.id2 = id2;
        this.id3 = id3;
    }

   
    
  
    
    
}

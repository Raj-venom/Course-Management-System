/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coursemanagementsystem;

/**
 *
 * @author xeetr
 */
class user {
    
    private String name, address, mobile, module, email;
    public user(String name, String address, String mobile, String string3, String string4, String string7){
        this.name=name;
        this.address=address;
        this.module=module;
        this.mobile=mobile;
        this.email=email;
        
        
    }
    public String getname(){
        return name;
    }
    public String getaddress(){
        return address;
    }
    public String getmobile(){
        return mobile;
    }
    public String getmodule(){
        return module;
    }
    public String getemail(){
        return email;
    }
}

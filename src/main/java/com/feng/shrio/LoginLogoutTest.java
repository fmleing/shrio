package main.java.com.feng.shrio;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Tomecs on 2017/10/12.
 */
public class LoginLogoutTest {
    @Test
    public void testHelloworld() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shrio-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try{
            subject.login(token);
        }catch (AuthenticationException e){

        }

        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }
    @Test
    public void testJDBCRealm() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shrio-jdbc-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try{
            subject.login(token);
        }catch (AuthenticationException e){

        }

        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }
}

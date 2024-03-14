package com.xkcoding.email;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 * 数据库密码测试
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2019-08-27 16:15
 *
 * https://cloud.tencent.com/developer/article/2156812
 */
public class PasswordTest extends SpringBootDemoEmailApplicationTests {
    @Autowired
    private StringEncryptor encryptor;  // 加密工具使用的是jasypt，因此application.yml中也为jasypt配置了解密密钥，这里的这个Bean要自己写

    /**
     * 生成加密密码
     */
    @Test
    public void testGeneratePassword() {
        // 你的邮箱密码
//        String password = "Just4Test!";
        String password = "Wangyi123";
        // 加密后的密码(注意：配置上去的时候需要加 ENC(加密密码))
        String encryptPassword = encryptor.encrypt(password);
        String decryptPassword = encryptor.decrypt(encryptPassword);

        System.out.println("password = " + password);
        System.out.println("encryptPassword = " + encryptPassword);
        System.out.println("decryptPassword = " + decryptPassword);
    }
}

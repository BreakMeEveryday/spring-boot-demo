package com.xkcoding.email;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
public class myPasswordTest{

    /**
     * 生成加密密码
     * 2024-03-14 12:06:39.527  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.algorithm, using default value: PBEWithMD5AndDES
     * 2024-03-14 12:06:39.527  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.keyObtentionIterations, using default value: 1000
     * 2024-03-14 12:06:39.527  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.poolSize, using default value: 1
     * 2024-03-14 12:06:39.527  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.providerName, using default value: null
     * 2024-03-14 12:06:39.527  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.providerClassName, using default value: null
     * 2024-03-14 12:06:39.527  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.saltGeneratorClassname, using default value: org.jasypt.salt.RandomSaltGenerator
     * 2024-03-14 12:06:39.530  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.ivGeneratorClassname, using default value: org.jasypt.salt.NoOpIVGenerator
     * 2024-03-14 12:06:39.530  INFO 250606 --- [           main] c.u.j.encryptor.DefaultLazyEncryptor     : Encryptor config not found for property jasypt.encryptor.stringOutputType, using default value: base64
     */
    public static void main(String[] args) {
        // 你的邮箱密码
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();  // 加密工具使用的是jasypt，因此application.yml中也为jasypt配置了解密密钥

        ((StandardPBEStringEncryptor)encryptor).setAlgorithm("PBEWithMD5AndDES");
        ((StandardPBEStringEncryptor)encryptor).setPassword("spring-boot-demo");

        String password = "Wangyi123";
        // 加密后的密码(注意：配置上去的时候需要加 ENC(加密密码))
        String encryptPassword = encryptor.encrypt(password);
        String decryptPassword = encryptor.decrypt(encryptPassword);

        System.out.println("password = " + password);
        System.out.println("encryptPassword = " + encryptPassword);
        System.out.println("decryptPassword = " + decryptPassword);
    }
}

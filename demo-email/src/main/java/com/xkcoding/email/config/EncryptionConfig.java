package com.xkcoding.email.config;

/**
 * @ClassName: EncryptionConfig
 * @Author: 键盘国治理专家
 * @email: ?????????@qq.com
 * @Time: 2024/3/14 上午11:57
 * @Description:
 * @Version: 1.0
 */
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptionConfig {
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

//  @Bean("jasyptStringEncryptor")
//  public StringEncryptor stringEncryptor() {
////    DESEncrypt desEncrypt = new DESEncrypt();//调用我们自己实现的类即可
////    return desEncrypt;
//    StringEncryptor encryptor = new StandardPBEStringEncryptor();
//    ((StandardPBEStringEncryptor)encryptor).setAlgorithm("PBEWithMD5AndDES");
//    ((StandardPBEStringEncryptor)encryptor).setPassword("spring-boot-demo");
//    return encryptor;
//  }
}

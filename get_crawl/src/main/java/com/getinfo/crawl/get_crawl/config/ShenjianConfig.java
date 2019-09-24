package com.getinfo.crawl.get_crawl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "shenjianconfig")
public class ShenjianConfig {

  private   String userKey ; //用户名
  private   String userSecret; //秘钥
  private   String url; //url

  private   List<String> sourceId; //数据源ID

  //MD5加密方法
  public static String stringToMD5(String plainText) {
      byte[] secretBytes = null;
      try {
        secretBytes = MessageDigest.getInstance("md5").digest(
                plainText.getBytes());
      } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException("没有这个md5算法！");
      }
      String md5code = new BigInteger(1, secretBytes).toString(16);
      for (int i = 0; i < 32 - md5code.length(); i++) {
        md5code = "0" + md5code;
      }
      return md5code;
    }



}

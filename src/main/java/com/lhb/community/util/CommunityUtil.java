package com.lhb.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * @author littlelee
 * @date 2020/12/11 13:47
 */
public class CommunityUtil {

     public static String generateUUID(){
         return UUID.randomUUID().toString().replaceAll("-","");
     }

     public static String md5(String key){
         if (StringUtils.isBlank(key)){
             return null;
         }
         return DigestUtils.md5DigestAsHex(key.getBytes());
     }

}

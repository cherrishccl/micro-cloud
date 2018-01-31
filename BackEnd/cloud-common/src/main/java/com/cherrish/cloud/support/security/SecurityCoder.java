/**
 * 2011-01-11
 */
package com.cherrish.cloud.support.security;

import java.security.Security;

/**
 * 加密基类
 * @author ccl
 * @time 2018-01-31 14:42
 * @name Constants
 * @desc:
 */
public abstract class SecurityCoder {
    private static Byte ADDFLAG = 0;
    static {
        if (ADDFLAG == 0) {
            // 加入BouncyCastleProvider支持
            Security.addProvider(new BouncyCastleProvider());
            ADDFLAG = 1;
        }
    }
}

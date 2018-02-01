/**
 * 
 */
package com.cherrish.cloud.support.context;

import com.cherrish.cloud.Constants;
import com.cherrish.cloud.util.DataUtil;
import com.cherrish.cloud.util.PropertiesUtil;
import com.cherrish.cloud.util.SecurityUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author ccl
 * @time 2018-01-31 13:54
 * @name PropertyPlaceholder
 * @desc:
 */

public class PropertyPlaceholder extends PropertyPlaceholderConfigurer {
	private List<String> decryptProperties;

	@Override
	protected void loadProperties(Properties props) throws IOException {
		super.loadProperties(props);
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			if (decryptProperties != null && decryptProperties.contains(keyStr)) {
				String dkey = props.getProperty("druid.key");
				dkey = DataUtil.isEmpty(dkey) ? Constants.DB_KEY : dkey;
				value = SecurityUtil.decryptDes(value, dkey.getBytes());
				props.setProperty(keyStr, value);
			}
			PropertiesUtil.getProperties().put(keyStr, value);
		}
	}

	/**
	 * @param decryptProperties
	 *            the decryptPropertiesMap to set
	 */
	public void setDecryptProperties(List<String> decryptProperties) {
		this.decryptProperties = decryptProperties;
	}

	public static void main(String[] args) {
		String encrypt = SecurityUtil.encryptDes("buzhidao", Constants.DB_KEY.getBytes());
		System.out.println(encrypt);
		System.out.println(SecurityUtil.decryptDes(encrypt, Constants.DB_KEY.getBytes()));
	}
}

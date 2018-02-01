package com.cherrish.cloud.util;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author ccl
 * @time 2018-01-31 18:11
 * @name NativeUtil
 * @desc:
 */

@Slf4j
public final class NativeUtil {

	private NativeUtil() {
	}

	/** 获取机器名 */
	public static final String getHostName() {
		String hostName = "";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			log.error(e.getMessage(), e);
		}
		return hostName;
	}

	/** 获取网卡序列号 */
	public static final String getDUID() {
		String address = "";
		String command = "cmd.exe /c ipconfig /all";
		try {
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("DUID") > 0) {
					int index = line.indexOf(":");
					index += 2;
					address = line.substring(index);
					break;
				}
			}
			br.close();
		} catch (IOException e) {
		}
		return address;
	}
}

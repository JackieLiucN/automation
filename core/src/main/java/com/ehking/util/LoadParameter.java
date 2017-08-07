package com.ehking.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * 
 *@Description:读取资源文件
 *@author:Jie Liu
 *@Date:2017年6月15日
 */
public class LoadParameter {

	public static Properties getProperties(String str){
		
		Properties prop = new Properties();
		InputStream is = null;
		
		try {
			File file = new File(str);
			is = new FileInputStream(file);
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return prop;
	}

}

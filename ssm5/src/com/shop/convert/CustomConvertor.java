package com.shop.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;


/**
 * 处理日期问题  （无非就是将   【字符串的日期格式】  转换为   【 Date类型】 ）
 * 
 * S=》 source  源头 字符串的日期格式
 * 
 * T=> target  目标类  Date
 * 
 * @author newuser
 *
 */
public class CustomConvertor implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		// java基础代码？？？？
	     try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// SimpleDateFormat
		return null;
	}

}

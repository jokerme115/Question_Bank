package Bank_util;

/**
 * 字符串工具包
 * @author 15351
 *
 */
public class String_util {
	/**
	 * 判断Str是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否不是空
	 * @param str
	 * @return
	 * trim()方法去掉前后空格
	 */
	public static boolean isNotEmpty(String str) {
		if(str != null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	
}

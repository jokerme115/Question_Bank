package Bank_util;

/**
 * �ַ������߰�
 * @author HeTao
 *
 */
public class String_util {
	/**
	 * �ж�Str�Ƿ�Ϊ��
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
	 * �ж��Ƿ��ǿ�
	 * @param str
	 * @return
	 * trim()����ȥ��ǰ��ո�
	 */
	public static boolean isNotEmpty(String str) {
		if(str != null && !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	
}

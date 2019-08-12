package com.platform.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang.StringUtils;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Model;


@SuppressWarnings("rawtypes")
public class ArrayKit {
	 	public static boolean isNotEmpty(Collection list) {
	        return list != null && list.size() > 0;
	    }

	    public static boolean isNotEmpty(Map map) {
	        return map != null && map.size() > 0;
	    }

	    public static boolean isNotEmpty(Object[] objects) {
	        return objects != null && objects.length > 0;
	    }

	    public static boolean isNullOrEmpty(Collection list) {
	        return list == null || list.size() == 0;
	    }

	    public static boolean isNullOrEmpty(Map map) {
	        return map == null || map.size() == 0;
	    }

	    public static boolean isNullOrEmpty(Object[] objects) {
	        return objects == null || objects.length == 0;
	    }

	    @SuppressWarnings("unchecked")
		public static <T> T[] concat(T[] first, T[]... rest) {
	        int totalLength = first.length;
	        for (T[] array : rest) {
	            totalLength += array.length;
	        }
	        T[] result = Arrays.copyOf(first, totalLength);
	        int offset = first.length;
	        for (T[] array : rest) {
	            System.arraycopy(array, 0, result, offset, array.length);
	            offset += array.length;
	        }
	        return result;
	    }
	    
	    public static LinkedList<Object> toLinkedList(Object[] objects){
	    	LinkedList<Object> linkList=new LinkedList<Object>();
	    	for(Object o:objects){
	    		linkList.add(o);
	    	}
	    	return linkList;
	    }
	    
	    
	    /** 将数组转为字符串形式："1，2，3,...." */
		public static String ArrayToString(Object[] o) {
			if (o == null) {
				return null;
			}
			StringBuffer str = new StringBuffer();
			for (Object obj : o) {
				str.append(obj.toString());
				str.append(",");
			}
			str = str.deleteCharAt(str.length() - 1);
			return str.toString();
		}

		/** 去除数据重复元素 */
		public static String[] removeDuplicate(String[] s) {
			List<String> list = new LinkedList<String>();
			for (String st : s) {
				if (!list.contains(st)) {
					list.add(st);
				}
			}
			return list.toArray(new String[list.size()]);
		}
		
		public static Integer[] ArrayToInteger(String[] s){
			if(s==null)
				return null;
			Integer[] num=new Integer[s.length];
			for(int i=0;i<s.length;i++){
				if(s[i].matches("[0-9]+"))
					num[i]=Integer.parseInt(s[i]);
				else
					return null;
			}
			return num;
		}
		
		/**
		 * 将list转成字符串形式
		 * 
		 * @param    list    		如String,Integer,Boolean等基本数据类型对象
		 * @param	 seperatorStr	分隔字符串
		 * @return			
		 */
		public static <T> String ListToString(List<T> list,String seperatorStr){
			if(list==null || list.size()==0){
				return null;
			}
			seperatorStr=(StringUtils.isBlank(seperatorStr))?",":seperatorStr;
			StringBuffer str=new StringBuffer();
			for(Object o :list){
				str.append(o.toString());
				str.append(seperatorStr);
			}
			return str.substring(0,str.lastIndexOf(seperatorStr));
		}
		
		public static String ListToString(List<? extends Model> list,String attrName,String seperatorStr){
			if(list==null || list.size()==0){
				return null;
			}
			seperatorStr=(StringUtils.isBlank(seperatorStr))?",":seperatorStr;
			StringBuilder sb=new StringBuilder();
			for(Model m : list){
				sb.append(m.get(attrName));
				sb.append(seperatorStr);
			}
			return sb.substring(0, sb.lastIndexOf(seperatorStr));
		}
		
		public static <T> List<T> mapToList(Map<String,T> map){
			List<T> list=new ArrayList<>();
			for(Entry<String, T> entry:map.entrySet()){
				list.add(entry.getValue());
			}
			return list;
		}
		
		@SuppressWarnings("unchecked")
		public static <T> T[] getValueToArray(List<? extends Model> list,String colName,T[] t){
			if(list==null || StrKit.isBlank(colName)){
				return null;
			}
			int newLength=list.size();
			T[] result=Arrays.copyOf(t, newLength);
			int i=0;
			for(Model m:list){
				result[i++]=(T) m.get(colName);
			}
			return result;
		}
		
		@SuppressWarnings("unchecked")
		public static <T> LinkedList<T> getLinkedList(List<? extends Model> list,String colName){
			
			LinkedList<T> resultList = new LinkedList<>();
			if(list!=null && StrKit.notBlank(colName)){
				for(Model m:list){
					resultList.add((T)m.get(colName));
				}
			}
			
			return resultList;
		}
		
		public static String join(String seperator,String... strings){
			
			if(strings==null || strings.length==0){
				return null;
			}
			StringBuffer sb=new StringBuffer();
			String result="";
			boolean seperatorEmpty=false;
			if(seperator==null){
				seperatorEmpty=true;
			}
			
			for(String str:strings){
				if(str!=null){
					sb.append(str);
					if(!seperatorEmpty){
						sb.append(seperator);
					}
				}
			}
			if(!seperatorEmpty){
				result = sb.substring(0, sb.length()-seperator.length());
			}else
				result=sb.toString();
			
			return result;
		}
}

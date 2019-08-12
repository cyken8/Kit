package com.platform.utils;
/**
 * 存储UI控件的工具类
 * */
public class UIutils {
	private static String inputUI = "<input type=\"text\" class=\"easyui-textbox\" />";
	private static String comboxUI = "<select class=\"easyui-combobox\"  panelHeight=\"auto\" >";
	private static String dateUI = "<input  type=\"text\" class=\"easyui-datebox\" />";
	private static String textUI = "<textarea  class=\"textbox easyui-validatebox\" ></textarea>";
	private static String checkboxUI = "<input type=\"checkbox\"  style=\"width: 20px;\" />";
	private static String radioUI = "<input type=\"radio\"  style=\"width: 20px;\" />";
	private static String datagridUI = "<table class=\"easyui-datagrid\" cellspacing=\"0\" cellpadding=\"0\" data-options=\"fitColumns:true,pageSize:20,pageList:[20,50,100], pagination:true\" > ";
	
	
	public static String northUI = "<div data-options=\"region:'north',title:'North Title',split:true\">";
	public static String centerUI = "<div data-options=\"region:'center',title:'center title'\">";
	public static String southUI = "<div data-options=\"region:'south',title:'South Title',split:true\">";
	public static String westUI = "<div data-options=\"region:'west',title:'West',split:true\">";
	public static String eastUI = "<div data-options=\"region:'east',title:'East',split:true\">";
	
	
	/**
	 * 返回输入框控件
	 * */
	public static String getInputUI(){
		return inputUI;
	}
	/**
	 * 返回输入框控件
	 * @param	name	控件name
	 * @param	width	控件宽度
	 * @return
	 * */
	public static String getInputUI(String name,String width,String value){
		String input = inputUI.substring(0, inputUI.length()-2);
		if(name!=null && !"".equals(name)){
			input = input + " name=\""+name+"\"";
		}
		if(width!=null && !"".equals(width)){
			input = input + " style=\"width: "+width+";\"";
		}
		if(value!=null && !"".equals(value)){
			input = input + " value=\"${"+value+"}\" ";
		}
		input = input+"/>";
		return input;
	}
	
	/**
	 * 返回下拉框控件
	 * */
	public static String getComboxUI(){
		return comboxUI;
	}
	/**
	 * 返回下拉框控件
	 * @param	name	控件name
	 * @param	width	控件宽度
	 * @param	option	控件下拉选项
	 * @param	ovalue	控件下拉选项值
	 * @return
	 * */
	public static String getComboxUI(String name,String width,String[] option,String[] ovalue,String value){
		String combox = comboxUI.substring(0, comboxUI.length()-1);
		if(name!=null && !"".equals(name)){
			combox = combox + " name=\""+name+"\"";
		}
		if(width!=null && !"".equals(width)){
			combox = combox + " style=\"width: "+width+";\"";
		}
		if(value!=null){
			combox = combox +" data-options=\"editable:false,value:'${"+value+"}'\" ";
		}else{
			combox = combox +" data-options=\"editable:false\" ";
		}
		combox = combox+">";
		if(option!=null && option.length>0){
			for(int i=0;i<option.length;i++){
				combox = combox + "<option value=\""+ovalue[i]+"\"";
				/*if(value!=null){
					combox = combox + " <c:if test=\"${"+value+"=='"+ovalue[i]+"'}\"> selected=\"selected\" </c:if>";
				}*/
				combox = combox + " >"+option[i]+"</option>";
			}
		}
		combox = combox+"</select>";
		return combox;
	}
	
	/**
	 * 返回下拉框控件
	 * @param	name		控件name
	 * @param	width		控件宽度
	 * @param	attrcode	静态参数变量
	 * @param	value		控件值
	 * @return
	 * */
	public static String getComboxUI(String name,String width,String attrcode,String value){
		String combox = comboxUI.substring(0, comboxUI.length()-1);
		if(name!=null && !"".equals(name)){
			combox = combox + " name=\""+name+"\"";
		}
		if(width!=null && !"".equals(width)){
			combox = combox + " style=\"width: "+width+";\"";
		}
		
		if(attrcode !=null && !"".equals(attrcode)){
			combox = combox +" code=\""+attrcode+"\" ";
		}
		
		if(value!=null){
			combox = combox +" data-options=\"editable:false,value:'${"+value+"}'\" ";
		}else{
			combox = combox +" data-options=\"editable:false\" ";
		}
		
		combox = combox+">";
		
		combox = combox+"</select>";
		return combox;
	}
	
	/**
	 * 返回时间控件
	 * */
	public static String getDateUI(){
		return dateUI;
	}
	
	/**
	 * 返回时间控件
	 * */
	public static String getDateUI(String name,String width,String value){
		String input = dateUI.substring(0, dateUI.length()-2);
		if(name!=null && !"".equals(name)){
			input = input + " name=\""+name+"\"";
		}
		if(width!=null && !"".equals(width)){
			input = input + " style=\"width: "+width+";\"";
		}
		if(value!=null && !"".equals(value)){
			input = input + " value=\"${"+value+"}\" ";
		}
		input = input+"/>";
		return input;
	}
	
	/**
	 * 返回文本框控件
	 * */
	public static String getTextUI(){
		return textUI;
	}
	/**
	 * 返回文本框控件
	 * @param	name	控件name
	 * @param	width	控件宽度
	 * @param	height	控件文本框高度
	 * @return
	 * */
	public static String getTextUI(String name,String width,String height,String value){
		String[] textcont = textUI.split("><");
		String text = textcont[0];
		if(name!=null && !"".equals(name)){
			text = text + " name=\""+name+"\"";
		}
		if(width!=null && !"".equals(width)){
			text = text + " style=\"width: "+width+";height: "+height+";\"";
		}
		text = text+">";
		if(value!=null && !"".equals(value)){
			text = text + "${"+value+"} ";
		}
		text = text+"<"+textcont[1];
		return text;
	}
	/**
	 * 返回复选框控件
	 * */
	public static String getCheckboxUI(){
		return checkboxUI;
	}
	
	/**
	 * 返回复选框控件
	 * @param	name	控件name
	 * @param	value	控件复选框值
	 * @param	coption	控件复选框文本
	 * @return
	 * */
	public static String getCheckboxUI(String name,String value,String coption,String check){
		String text = checkboxUI.substring(0, checkboxUI.length()-1);
		if(name!=null && !"".equals(name)){
			text = text + " name=\""+name+"\"";
		}
		if(value!=null && !"".equals(value)){
			text = text + " value=\""+value+"\"";
		}
		if(check!=null && !"".equals(check) && check.equals(value)){
			text = text+" <c:if test=\"${"+check+"=='"+value+"'}\"> checked=\"checked\" </c:if> ";
		}
		text = text+"/>";
		if(coption!=null && !"".equals(coption)){
			text = text+coption;
		}
		return text;
	}
	/**
	 * 返回单选框控件
	 * */
	public static String getRadioUI(){
		return radioUI;
	}
	/**
	 * 返回单选框控件
	 * @param	name	控件name
	 * @param	value	控件单选框值
	 * @param	coption	控件单选框文本
	 * @return
	 * */
	public static String getRadioUI(String name,String value,String coption,String check){
		String text = radioUI.substring(0, radioUI.length()-2);
		if(name!=null && !"".equals(name)){
			text = text + " name=\""+name+"\"";
		}
		if(value!=null && !"".equals(value)){
			text = text + " value=\""+value+"\"";
		}
		if(check!=null && !"".equals(check) && check.equals(value)){
			text = text+" <c:if test=\"${"+check+"=='"+value+"'}\"> checked=\"checked\" </c:if> ";
		}
		text = text+"/>";
		if(coption!=null && !"".equals(coption)){
			text = text+coption;
		}
		return text;
	}
	
	/**
	 * 返回datagrid控件
	 * */
	public static String getDatagridUI(){
		return datagridUI;
	}
	/**
	 * 返回datagrid控件
	 * @param	name	控件name
	 * @param	value	控件单选框值
	 * @param	coption	控件单选框文本
	 * @return
	 * */
	public static String getDatagridUI(String name,String[] fileds,String[] ftexts,String[] widths,String[] code){
		String text = datagridUI.substring(0, datagridUI.length()-2);
		if(name!=null && !"".equals(name)){
			text = text + " name=\""+name+"\"";
		}
		text = text+"> <thead> <tr>";
		if(fileds!=null && fileds.length>0){
			for(int i=0;i<fileds.length;i++){
				text = text + "<th field=\""+fileds[i]
				       +"\" width=\""+widths[i];
				if(code!=null && i<code.length && code[i]!=null && !"".equals(code[i])){
					text = text + " code=\""+code[i]+"\" ";
				}
				text = text+"\">"+ftexts[i]+"</th>";
			}
		}
		text = text+" </tr> </thead> </table>";
		return text;
	}
	
	/**
	 * 返回布局控件
	 * */
	public static String getNorthUI(){
		return northUI;
	}
	/**
	 * 返回布局控件
	 * @param	height	控件高度
	 * @return
	 * */
	public static String getNorthUI(String height){
		String text = northUI.substring(0, northUI.length()-1);
		if(height!=null && !"".equals(height)){
			text = text + " style=\"height:"+height+";\"";
		}
		
		text = text+"></div>";
		return text;
	}
	/**
	 * 返回布局控件
	 * */
	public static String getSouthUI(){
		return southUI;
	}
	/**
	 * 返回布局控件
	 * @param	height	控件高度
	 * @return
	 * */
	public static String getSouthUI(String height){
		String text = southUI.substring(0, southUI.length()-1);
		if(height!=null && !"".equals(height)){
			text = text + " style=\"height:"+height+";\"";
		}
		
		text = text+"></div>";
		return text;
	}
	/**
	 * 返回布局控件
	 * */
	public static String getCenterUI(){
		return centerUI;
	}
	/**
	 * 返回布局控件
	 * @param	height	控件高度
	 * @return
	 * */
	public static String getCenterUI(String height){
		String text = centerUI.substring(0, centerUI.length()-1);
		if(height!=null && !"".equals(height)){
			text = text + " style=\"height:"+height+";\"";
		}
		
		text = text+"></div>";
		return text;
	}
	/**
	 * 返回布局控件
	 * */
	public static String getWestUI(){
		return westUI;
	}
	/**
	 * 返回布局控件
	 * @param	width	控件宽度
	 * @return
	 * */
	public static String getWestUI(String width){
		String text = westUI.substring(0, westUI.length()-1);
		if(width!=null && !"".equals(width)){
			text = text + " style=\"width:"+width+";\"";
		}
		
		text = text+"></div>";
		return text;
	}
	/**
	 * 返回布局控件
	 * */
	public static String getEastUI(){
		return eastUI;
	}
	/**
	 * 返回布局控件
	 * @param	width	控件宽度
	 * @return
	 * */
	public static String getEastUI(String width){
		String text = eastUI.substring(0, eastUI.length()-1);
		if(width!=null && !"".equals(width)){
			text = text + " style=\"width:"+width+";\"";
		}
		
		text = text+"></div>";
		return text;
	}
}

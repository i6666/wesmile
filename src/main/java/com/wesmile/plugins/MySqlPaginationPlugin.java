package com.wesmile.plugins;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.List;

/**
 * MySQL 分页生成插件。
 */
public final class MySqlPaginationPlugin extends PluginAdapter {
	private static String PageClassPath = "com.wesmile.plugins.Page";

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) { // add
																													// //
																													// clause
		addPage(topLevelClass, introspectedTable, "page");
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	@Override
	public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element,
			IntrospectedTable introspectedTable) {
		XmlElement page = new XmlElement("if");
		page.addAttribute(new Attribute("test", "page != null"));
		page.addElement(new TextElement("limit #{page.pageNum} , #{page.pageSize}"));
		element.addElement(page);
		return super.sqlMapUpdateByExampleWithoutBLOBsElementGenerated(element, introspectedTable);
	}

	/**
	 * @param topLevelClass
	 * @param introspectedTable
	 * @param name
	 */
	private void addPage(TopLevelClass topLevelClass, IntrospectedTable introspectedTable, String name) {
		topLevelClass.addImportedType(new FullyQualifiedJavaType(PageClassPath));
		CommentGenerator commentGenerator = context.getCommentGenerator();
		Field field = new Field();
		field.setVisibility(JavaVisibility.PROTECTED);
		field.setType(new FullyQualifiedJavaType(PageClassPath));
		field.setName(name);
		commentGenerator.addFieldComment(field, introspectedTable);
		topLevelClass.addField(field);
		char c = name.charAt(0);
		String camel = Character.toUpperCase(c) + name.substring(1);
		Method method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setName("set" + camel);
		method.addParameter(new Parameter(new FullyQualifiedJavaType(PageClassPath), name));
		method.addBodyLine("this." + name + "=" + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
		method = new Method();
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(new FullyQualifiedJavaType(PageClassPath));
		method.setName("get" + camel);
		method.addBodyLine("return " + name + ";");
		commentGenerator.addGeneralMethodComment(method, introspectedTable);
		topLevelClass.addMethod(method);
	}

	/**
	 * This plugin is always valid - no properties are required
	 */
	@Override
    public boolean validate(List<String> warnings) {
		return true;
	}
}
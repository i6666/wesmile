/**
 *    Copyright 2006-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.wesmile.plugins;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.mybatis.generator.internal.util.messages.Messages.getString;

/**
 * @author generator
 */
public class BatchInsertPlugin extends PluginAdapter {
	/**
	 * 修改Mapper类
	 */
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		addBatchInsertSelectiveMethod(interfaze, introspectedTable);
		addBatchInsertMethod(interfaze, introspectedTable);

		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	/**
	 * 修改Mapper.xml
	 */
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
		addBatchInsertSelectiveXml(document, introspectedTable);
		addBatchInsertXml(document, introspectedTable);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	private void addBatchInsertMethod(Interface interfaze, IntrospectedTable introspectedTable) {
		// 设置需要导入的类
		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
		importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
		importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));

		Method ibsmethod = new Method();
		// 1.设置方法可见性
		ibsmethod.setVisibility(JavaVisibility.PUBLIC);
		// 2.设置返回值类型 // int型
		FullyQualifiedJavaType ibsreturnType = FullyQualifiedJavaType.getIntInstance();
		ibsmethod.setReturnType(ibsreturnType);
		// 3.设置方法名
		ibsmethod.setName("insertBatch");
		// 4.设置参数列表
		FullyQualifiedJavaType paramType = FullyQualifiedJavaType.getNewListInstance();
		FullyQualifiedJavaType paramListType;
		if (introspectedTable.getRules().generateBaseRecordClass()) {
			paramListType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		} else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
			paramListType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
		} else {
			//$NON-NLS-1$
			throw new RuntimeException(getString("RuntimeError.12"));
		}
		paramType.addTypeArgument(paramListType);

		ibsmethod.addParameter(new Parameter(paramType, "records"));

		interfaze.addImportedTypes(importedTypes);
		interfaze.addMethod(ibsmethod);
	}

	private void addBatchInsertSelectiveMethod(Interface interfaze, IntrospectedTable introspectedTable) {
		// 设置需要导入的类
		Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
		importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
		importedTypes.add(new FullyQualifiedJavaType(introspectedTable.getBaseRecordType()));

		Method ibsmethod = new Method();
		// 1.设置方法可见性
		ibsmethod.setVisibility(JavaVisibility.PUBLIC);
		// 2.设置返回值类型 // int型
		FullyQualifiedJavaType ibsreturnType = FullyQualifiedJavaType.getIntInstance();
		ibsmethod.setReturnType(ibsreturnType);
		// 3.设置方法名
		ibsmethod.setName("insertBatchSelective");
		// 4.设置参数列表
		FullyQualifiedJavaType paramType = FullyQualifiedJavaType.getNewListInstance();
		FullyQualifiedJavaType paramListType;
		if (introspectedTable.getRules().generateBaseRecordClass()) {
			paramListType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
		} else if (introspectedTable.getRules().generatePrimaryKeyClass()) {
			paramListType = new FullyQualifiedJavaType(introspectedTable.getPrimaryKeyType());
		} else {
			//$NON-NLS-1$
			throw new RuntimeException(getString("RuntimeError.12"));
		}
		paramType.addTypeArgument(paramListType);

		ibsmethod.addParameter(new Parameter(paramType, "records"));

		interfaze.addImportedTypes(importedTypes);
		interfaze.addMethod(ibsmethod);
	}

	public void addBatchInsertXml(Document document, IntrospectedTable introspectedTable) {
		List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
		// 获得要自增的列名
		String incrementField = introspectedTable.getTableConfiguration().getProperties().getProperty("incrementField");
		if (incrementField != null) {
			incrementField = incrementField.toUpperCase();
		}

		XmlElement trimElement = new XmlElement("trim");
		trimElement.addAttribute(new Attribute("prefix", "("));
		trimElement.addAttribute(new Attribute("suffix", ")"));
		trimElement.addAttribute(new Attribute("suffixOverrides", ","));

		XmlElement insertBatchElement = new XmlElement("insert");
		insertBatchElement.addAttribute(new Attribute("id", "insertBatch"));
		insertBatchElement.addAttribute(new Attribute("parameterType", "java.util.List"));

		insertBatchElement.addElement(
				new TextElement("insert into " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
		List<TextElement> values = new ArrayList<>();

		Integer count = 0;
		String fieldTmp = "";
		String valueTmp = "";
		for (IntrospectedColumn introspectedColumn : columns) {
			String columnName = introspectedColumn.getActualColumnName();
			if (columnName.toUpperCase().equals(incrementField)) {
				// 不是自增字段的才会出现在批量插入中
				continue;
			}
			if (count == 2) {
				trimElement.addElement(new TextElement(fieldTmp));
				values.add(new TextElement(valueTmp));
				count = 0;
				fieldTmp = "";
				valueTmp = "";
			}

			fieldTmp += columnName + ",";
			valueTmp += "#{item." + introspectedColumn.getJavaProperty() + ",jdbcType="
					+ introspectedColumn.getJdbcTypeName() + "},";
			count++;
		}

		if (count > 0) {
			trimElement.addElement(new TextElement(fieldTmp));
			values.add(new TextElement(valueTmp));
		}
		insertBatchElement.addElement(trimElement);
		insertBatchElement.addElement(new TextElement(" values "));

		XmlElement foreachElement = new XmlElement("foreach");
		foreachElement.addAttribute(new Attribute("collection", "list"));
		foreachElement.addAttribute(new Attribute("index", "index"));
		foreachElement.addAttribute(new Attribute("item", "item"));
		foreachElement.addAttribute(new Attribute("separator", ","));

		XmlElement trim1Element = new XmlElement("trim");
		trim1Element.addAttribute(new Attribute("prefix", "("));
		trim1Element.addAttribute(new Attribute("suffix", ")"));
		trim1Element.addAttribute(new Attribute("suffixOverrides", ","));

		for (int i = 0; i < values.size(); i++) {
			trim1Element.addElement(values.get(i));
		}
		foreachElement.addElement(trim1Element);
		insertBatchElement.addElement(foreachElement);

		document.getRootElement().addElement(insertBatchElement);
	}

	public void addBatchInsertSelectiveXml(Document document, IntrospectedTable introspectedTable) {
		List<IntrospectedColumn> columns = introspectedTable.getAllColumns();
		// 获得要自增的列名
		String incrementField = introspectedTable.getTableConfiguration().getProperties().getProperty("incrementField");
		if (incrementField != null) {
			incrementField = incrementField.toUpperCase();
		}
		XmlElement javaPropertyAndDbType = new XmlElement("trim");
		javaPropertyAndDbType.addAttribute(new Attribute("prefix", " ("));
		javaPropertyAndDbType.addAttribute(new Attribute("suffix", ")"));
		javaPropertyAndDbType.addAttribute(new Attribute("suffixOverrides", ","));

		XmlElement insertBatchElement = new XmlElement("insert");
		insertBatchElement.addAttribute(new Attribute("id", "insertBatchSelective"));
		insertBatchElement.addAttribute(new Attribute("parameterType", "java.util.List"));

		XmlElement trim1Element = new XmlElement("trim");
		trim1Element.addAttribute(new Attribute("prefix", "("));
		trim1Element.addAttribute(new Attribute("suffix", ")"));
		trim1Element.addAttribute(new Attribute("suffixOverrides", ","));
		for (IntrospectedColumn introspectedColumn : columns) {
			String columnName = introspectedColumn.getActualColumnName();
			if (!columnName.toUpperCase().equals(incrementField)) {
				// 不是自增字段的才会出现在批量插入中
				XmlElement iftest = new XmlElement("if");
				iftest.addAttribute(
						new Attribute("test", "item." + introspectedColumn.getJavaProperty() + "!=null"));
				iftest.addElement(new TextElement(columnName + ","));
				trim1Element.addElement(iftest);
				XmlElement trimiftest = new XmlElement("if");
				trimiftest
						.addAttribute(new Attribute("test", "item." + introspectedColumn.getJavaProperty() + "!=null"));
				trimiftest.addElement(new TextElement("#{item." + introspectedColumn.getJavaProperty() + ",jdbcType="
						+ introspectedColumn.getJdbcTypeName() + "},"));
				javaPropertyAndDbType.addElement(trimiftest);
			}
		}

		XmlElement foreachElement = new XmlElement("foreach");
		foreachElement.addAttribute(new Attribute("collection", "list"));
		foreachElement.addAttribute(new Attribute("index", "index"));
		foreachElement.addAttribute(new Attribute("item", "item"));
		foreachElement.addAttribute(new Attribute("separator", ";"));

		foreachElement.addElement(
				new TextElement("insert into " + introspectedTable.getAliasedFullyQualifiedTableNameAtRuntime()));
		foreachElement.addElement(trim1Element);
		foreachElement.addElement(new TextElement(" values "));
		foreachElement.addElement(javaPropertyAndDbType);

		insertBatchElement.addElement(foreachElement);

		document.getRootElement().addElement(insertBatchElement);
	}

}

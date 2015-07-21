/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.shopping.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.shopping.model.ShoppingItemPrice;
import com.liferay.portlet.shopping.model.ShoppingItemPriceModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the ShoppingItemPrice service. Represents a row in the &quot;ShoppingItemPrice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.shopping.model.ShoppingItemPriceModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ShoppingItemPriceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ShoppingItemPriceImpl
 * @see com.liferay.portlet.shopping.model.ShoppingItemPrice
 * @see com.liferay.portlet.shopping.model.ShoppingItemPriceModel
 * @generated
 */
@ProviderType
public class ShoppingItemPriceModelImpl extends BaseModelImpl<ShoppingItemPrice>
	implements ShoppingItemPriceModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a shopping item price model instance should use the {@link com.liferay.portlet.shopping.model.ShoppingItemPrice} interface instead.
	 */
	public static final String TABLE_NAME = "ShoppingItemPrice";
	public static final Object[][] TABLE_COLUMNS = {
			{ "itemPriceId", Types.BIGINT },
			{ "itemId", Types.BIGINT },
			{ "minQuantity", Types.INTEGER },
			{ "maxQuantity", Types.INTEGER },
			{ "price", Types.DOUBLE },
			{ "discount", Types.DOUBLE },
			{ "taxable", Types.BOOLEAN },
			{ "shipping", Types.DOUBLE },
			{ "useShippingFormula", Types.BOOLEAN },
			{ "status", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("itemPriceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("itemId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("minQuantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("maxQuantity", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("price", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("discount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("taxable", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("shipping", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("useShippingFormula", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table ShoppingItemPrice (itemPriceId LONG not null primary key,itemId LONG,minQuantity INTEGER,maxQuantity INTEGER,price DOUBLE,discount DOUBLE,taxable BOOLEAN,shipping DOUBLE,useShippingFormula BOOLEAN,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table ShoppingItemPrice";
	public static final String ORDER_BY_JPQL = " ORDER BY shoppingItemPrice.itemId ASC, shoppingItemPrice.itemPriceId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ShoppingItemPrice.itemId ASC, ShoppingItemPrice.itemPriceId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.ShoppingItemPrice"), true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.ShoppingItemPrice"), true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.column.bitmask.enabled.ShoppingItemPrice"), true);
	public static final long ITEMID_COLUMN_BITMASK = 1L;
	public static final long ITEMPRICEID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.ShoppingItemPrice"));

	public ShoppingItemPriceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _itemPriceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setItemPriceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _itemPriceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ShoppingItemPrice.class;
	}

	@Override
	public String getModelClassName() {
		return ShoppingItemPrice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("itemPriceId", getItemPriceId());
		attributes.put("itemId", getItemId());
		attributes.put("minQuantity", getMinQuantity());
		attributes.put("maxQuantity", getMaxQuantity());
		attributes.put("price", getPrice());
		attributes.put("discount", getDiscount());
		attributes.put("taxable", getTaxable());
		attributes.put("shipping", getShipping());
		attributes.put("useShippingFormula", getUseShippingFormula());
		attributes.put("status", getStatus());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long itemPriceId = (Long)attributes.get("itemPriceId");

		if (itemPriceId != null) {
			setItemPriceId(itemPriceId);
		}

		Long itemId = (Long)attributes.get("itemId");

		if (itemId != null) {
			setItemId(itemId);
		}

		Integer minQuantity = (Integer)attributes.get("minQuantity");

		if (minQuantity != null) {
			setMinQuantity(minQuantity);
		}

		Integer maxQuantity = (Integer)attributes.get("maxQuantity");

		if (maxQuantity != null) {
			setMaxQuantity(maxQuantity);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Double discount = (Double)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Boolean taxable = (Boolean)attributes.get("taxable");

		if (taxable != null) {
			setTaxable(taxable);
		}

		Double shipping = (Double)attributes.get("shipping");

		if (shipping != null) {
			setShipping(shipping);
		}

		Boolean useShippingFormula = (Boolean)attributes.get(
				"useShippingFormula");

		if (useShippingFormula != null) {
			setUseShippingFormula(useShippingFormula);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getItemPriceId() {
		return _itemPriceId;
	}

	@Override
	public void setItemPriceId(long itemPriceId) {
		_columnBitmask = -1L;

		_itemPriceId = itemPriceId;
	}

	@Override
	public long getItemId() {
		return _itemId;
	}

	@Override
	public void setItemId(long itemId) {
		_columnBitmask = -1L;

		if (!_setOriginalItemId) {
			_setOriginalItemId = true;

			_originalItemId = _itemId;
		}

		_itemId = itemId;
	}

	public long getOriginalItemId() {
		return _originalItemId;
	}

	@Override
	public int getMinQuantity() {
		return _minQuantity;
	}

	@Override
	public void setMinQuantity(int minQuantity) {
		_minQuantity = minQuantity;
	}

	@Override
	public int getMaxQuantity() {
		return _maxQuantity;
	}

	@Override
	public void setMaxQuantity(int maxQuantity) {
		_maxQuantity = maxQuantity;
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public void setPrice(double price) {
		_price = price;
	}

	@Override
	public double getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(double discount) {
		_discount = discount;
	}

	@Override
	public boolean getTaxable() {
		return _taxable;
	}

	@Override
	public boolean isTaxable() {
		return _taxable;
	}

	@Override
	public void setTaxable(boolean taxable) {
		_taxable = taxable;
	}

	@Override
	public double getShipping() {
		return _shipping;
	}

	@Override
	public void setShipping(double shipping) {
		_shipping = shipping;
	}

	@Override
	public boolean getUseShippingFormula() {
		return _useShippingFormula;
	}

	@Override
	public boolean isUseShippingFormula() {
		return _useShippingFormula;
	}

	@Override
	public void setUseShippingFormula(boolean useShippingFormula) {
		_useShippingFormula = useShippingFormula;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			ShoppingItemPrice.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ShoppingItemPrice toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (ShoppingItemPrice)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ShoppingItemPriceImpl shoppingItemPriceImpl = new ShoppingItemPriceImpl();

		shoppingItemPriceImpl.setItemPriceId(getItemPriceId());
		shoppingItemPriceImpl.setItemId(getItemId());
		shoppingItemPriceImpl.setMinQuantity(getMinQuantity());
		shoppingItemPriceImpl.setMaxQuantity(getMaxQuantity());
		shoppingItemPriceImpl.setPrice(getPrice());
		shoppingItemPriceImpl.setDiscount(getDiscount());
		shoppingItemPriceImpl.setTaxable(getTaxable());
		shoppingItemPriceImpl.setShipping(getShipping());
		shoppingItemPriceImpl.setUseShippingFormula(getUseShippingFormula());
		shoppingItemPriceImpl.setStatus(getStatus());

		shoppingItemPriceImpl.resetOriginalValues();

		return shoppingItemPriceImpl;
	}

	@Override
	public int compareTo(ShoppingItemPrice shoppingItemPrice) {
		int value = 0;

		if (getItemId() < shoppingItemPrice.getItemId()) {
			value = -1;
		}
		else if (getItemId() > shoppingItemPrice.getItemId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getItemPriceId() < shoppingItemPrice.getItemPriceId()) {
			value = -1;
		}
		else if (getItemPriceId() > shoppingItemPrice.getItemPriceId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ShoppingItemPrice)) {
			return false;
		}

		ShoppingItemPrice shoppingItemPrice = (ShoppingItemPrice)obj;

		long primaryKey = shoppingItemPrice.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		ShoppingItemPriceModelImpl shoppingItemPriceModelImpl = this;

		shoppingItemPriceModelImpl._originalItemId = shoppingItemPriceModelImpl._itemId;

		shoppingItemPriceModelImpl._setOriginalItemId = false;

		shoppingItemPriceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ShoppingItemPrice> toCacheModel() {
		ShoppingItemPriceCacheModel shoppingItemPriceCacheModel = new ShoppingItemPriceCacheModel();

		shoppingItemPriceCacheModel.itemPriceId = getItemPriceId();

		shoppingItemPriceCacheModel.itemId = getItemId();

		shoppingItemPriceCacheModel.minQuantity = getMinQuantity();

		shoppingItemPriceCacheModel.maxQuantity = getMaxQuantity();

		shoppingItemPriceCacheModel.price = getPrice();

		shoppingItemPriceCacheModel.discount = getDiscount();

		shoppingItemPriceCacheModel.taxable = getTaxable();

		shoppingItemPriceCacheModel.shipping = getShipping();

		shoppingItemPriceCacheModel.useShippingFormula = getUseShippingFormula();

		shoppingItemPriceCacheModel.status = getStatus();

		return shoppingItemPriceCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{itemPriceId=");
		sb.append(getItemPriceId());
		sb.append(", itemId=");
		sb.append(getItemId());
		sb.append(", minQuantity=");
		sb.append(getMinQuantity());
		sb.append(", maxQuantity=");
		sb.append(getMaxQuantity());
		sb.append(", price=");
		sb.append(getPrice());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", taxable=");
		sb.append(getTaxable());
		sb.append(", shipping=");
		sb.append(getShipping());
		sb.append(", useShippingFormula=");
		sb.append(getUseShippingFormula());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.shopping.model.ShoppingItemPrice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>itemPriceId</column-name><column-value><![CDATA[");
		sb.append(getItemPriceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>itemId</column-name><column-value><![CDATA[");
		sb.append(getItemId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minQuantity</column-name><column-value><![CDATA[");
		sb.append(getMinQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maxQuantity</column-name><column-value><![CDATA[");
		sb.append(getMaxQuantity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>price</column-name><column-value><![CDATA[");
		sb.append(getPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxable</column-name><column-value><![CDATA[");
		sb.append(getTaxable());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shipping</column-name><column-value><![CDATA[");
		sb.append(getShipping());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>useShippingFormula</column-name><column-value><![CDATA[");
		sb.append(getUseShippingFormula());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = ShoppingItemPrice.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			ShoppingItemPrice.class
		};
	private long _itemPriceId;
	private long _itemId;
	private long _originalItemId;
	private boolean _setOriginalItemId;
	private int _minQuantity;
	private int _maxQuantity;
	private double _price;
	private double _discount;
	private boolean _taxable;
	private double _shipping;
	private boolean _useShippingFormula;
	private int _status;
	private long _columnBitmask;
	private ShoppingItemPrice _escapedModel;
}
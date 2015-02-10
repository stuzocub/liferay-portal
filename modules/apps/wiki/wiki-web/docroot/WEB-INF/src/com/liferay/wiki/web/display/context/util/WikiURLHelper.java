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

package com.liferay.wiki.web.display.context.util;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.wiki.configuration.WikiServiceConfiguration;
import com.liferay.wiki.model.WikiNode;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author Adolfo Pérez
 */
public class WikiURLHelper {

	public WikiURLHelper(
		RenderRequest renderRequest, RenderResponse renderResponse,
		WikiServiceConfiguration wikiServiceConfiguration) {

		_renderRequest = renderRequest;
		_renderResponse = renderResponse;
		_wikiServiceConfiguration = wikiServiceConfiguration;
	}

	public PortletURL getFrontPageURL(WikiNode node) {
		PortletURL frontPageURL = getWikiNodeBaseURL(node);

		frontPageURL.setParameter("struts_action", "/wiki/view");
		frontPageURL.setParameter(
			"title", _wikiServiceConfiguration.frontPageName());
		frontPageURL.setParameter("tag", StringPool.BLANK);

		return frontPageURL;
	}

	protected PortletURL getWikiNodeBaseURL(WikiNode node) {
		PortletURL portletURL = _renderResponse.createRenderURL();

		portletURL.setParameter("nodeName", node.getName());

		long categoryId = ParamUtil.getLong(_renderRequest, "categoryId", 0);

		if (categoryId > 0) {
			portletURL.setParameter("categoryId", "0");
		}

		return portletURL;
	}

	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private final WikiServiceConfiguration _wikiServiceConfiguration;

}
<%
/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>

<script type="text/javascript">
	var maxDimension = <%= PropsValues.IG_IMAGE_THUMBNAIL_MAX_DIMENSION %>;

	function <portlet:namespace />viewImage(id, name, width, height) {
		var page = Viewport.page();
		var frame = Viewport.frame();

		var maxWidth = Math.max(Math.min(page.x, frame.x) - 150, maxDimension);
		var maxHeight = Math.max(Math.min(page.y, frame.y) - 150, maxDimension);

		var imgWidth = width;
		var imgHeight = height;

		if (imgWidth > maxWidth || imgHeight > maxHeight) {
			if (imgWidth > maxWidth) {
				var x = maxWidth / imgWidth;

				imgWidth = maxWidth;
				imgHeight = x * imgHeight;
			}

			if (imgHeight > maxHeight) {
				var y = maxHeight / imgHeight;

				imgHeight = maxHeight;
				imgWidth = y * imgWidth;
			}
		}

		var winWidth = imgWidth + 36;

		if (winWidth < maxDimension) {
			winWidth = maxDimension;
		}

		var html =
			"<div style='margin-top: 16px; text-align: center;'><img src='<%= themeDisplay.getPathImage() %>/image_gallery?img_id=" + id + "' style='height: " + imgHeight + "px; width" + imgWidth + "px;' /></div>" +
			"<div style='text-align: center;'>" + name + "</div>";

		var messageId = "<portlet:namespace />popup_" + id;
		var buttonsId = "<portlet:namespace />buttons_" + id;

		var popup = Liferay.Popup({
			width: winWidth,
			modal: true,
			noDraggable: true,
			noTitleBar: true,
			message: html,
			messageId: messageId,
			onBeforeClose: function() {
				var buttons = jQuery("#<portlet:namespace />buttons_" + id);

				jQuery("#<portlet:namespace />buttonsContainer_" + id).append(buttons);
			}
		});

		var buttons = jQuery("#" + buttonsId);

		jQuery("#" + messageId).append(buttons);
	}
</script>

<c:if test="<%= results.size() > 0 %>">
	<div class="taglib-search-iterator-page-iterator-top">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</c:if>

<div>

	<%
	for (int i = 0; i < results.size(); i++) {
		IGImage image = (IGImage)results.get(i);

		Image largeImage = ImageLocalServiceUtil.getImage(image.getLargeImageId());
		Image smallImage = ImageLocalServiceUtil.getImage(image.getSmallImageId());

		int topMargin = PropsValues.IG_IMAGE_THUMBNAIL_MAX_DIMENSION - smallImage.getHeight() + 20;
		int sideMargin = (PropsValues.IG_IMAGE_THUMBNAIL_MAX_DIMENSION - smallImage.getWidth() + 20) / 2;
	%>

		<div style="float: left; margin: <%= topMargin %>px <%= sideMargin %>px 0px <%= sideMargin %>px;">
			<div onClick="<portlet:namespace />viewImage(<%= largeImage.getImageId() %>, '<%= image.getName() %>', <%= largeImage.getWidth() %>, <%= largeImage.getHeight() %>)">
				<img src="<%= themeDisplay.getPathImage() %>/image_gallery?img_id=<%= smallImage.getImageId() %>" style="height: <%= smallImage.getHeight() %>; width: <%= smallImage.getWidth() %>;" />
			</div>

			<div style="text-align: center;">
				<%= image.getName() %>

				<c:if test="<%= scores != null %>">
					<br />

					<%
					double score = ((Double)scores.get(i)).doubleValue();

					score = MathUtils.round((score * 10) / 2, 1, BigDecimal.ROUND_UP);
					%>

					<liferay-ui:ratings-score score="<%= score %>" />
				</c:if>
			</div>

			<div id="<portlet:namespace />buttonsContainer_<%= largeImage.getImageId() %>" style="display: none;">
				<div id="<portlet:namespace />buttons_<%= largeImage.getImageId() %>">
					<%@ include file="/html/portlet/image_gallery/image_action.jspf" %>
				</div>
			</div>
		</div>

	<%
	}
	%>

</div>

<c:if test="<%= results.size() > 0 %>">
	<div class="taglib-search-iterator-page-iterator-bottom">
		<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
	</div>
</c:if>
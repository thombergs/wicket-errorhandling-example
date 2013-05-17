package org.wickedsource;

import org.apache.wicket.DefaultExceptionMapper;
import org.apache.wicket.core.request.handler.PageProvider;
import org.apache.wicket.core.request.handler.RenderPageRequestHandler;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.IRequestHandler;

public class MyCustomExceptionMapper extends DefaultExceptionMapper {

	@Override
	public IRequestHandler map(Exception e) {
		if (e instanceof MyCustomException) {
			return pageHandler(HomePage.class);
		} else {
			return super.map(e);
		}
	}

	private IRequestHandler pageHandler(Class<? extends WebPage> pageClass) {
		return new RenderPageRequestHandler(new PageProvider(pageClass));
	}

}

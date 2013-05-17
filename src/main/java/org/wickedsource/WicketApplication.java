package org.wickedsource;

import org.apache.wicket.DefaultExceptionMapper;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.IExceptionMapper;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.settings.def.ExceptionSettings;
import org.apache.wicket.util.IProvider;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see org.wickedsource.Start#main(String[])
 */
public class WicketApplication extends WebApplication {
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();

		// this setting shows the exception stacktrace
		getExceptionSettings().setUnexpectedExceptionDisplay(
				ExceptionSettings.SHOW_EXCEPTION_PAGE);

		// this setting shows the "internal error" page specified below
		getExceptionSettings().setUnexpectedExceptionDisplay(
				ExceptionSettings.SHOW_INTERNAL_ERROR_PAGE);
		getApplicationSettings().setInternalErrorPage(InternalErrorPage.class);

	}

	@Override
	public IProvider<IExceptionMapper> getExceptionMapperProvider() {
		return new IProvider<IExceptionMapper>() {

			@Override
			public IExceptionMapper get() {
				return new MyCustomExceptionMapper();
			}
		};
	}

}

package at.nucle.e4.plugin.preferences.core.internal;


import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;

import at.nucle.e4.plugin.preferences.core.api.IPreferencePageService;


public class PreferenceServiceContextFactory extends ContextFunction {

    @Override
    public Object compute(final IEclipseContext context, final String contextKey) {
        final IPreferencePageService preferenceService = ContextInjectionFactory.make(PreferencePageService.class, context);
        final MApplication application = context.get(MApplication.class);
        final IEclipseContext applicationContext = application.getContext();
        applicationContext.set(IPreferencePageService.class, preferenceService);
        return preferenceService;
    }
}

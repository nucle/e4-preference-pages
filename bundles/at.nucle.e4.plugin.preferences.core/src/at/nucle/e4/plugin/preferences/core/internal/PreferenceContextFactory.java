/*******************************************************************************
 * Copyright (c) 2017 Christian Behon.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Christian Behon
 ******************************************************************************/
package at.nucle.e4.plugin.preferences.core.internal;


import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.MApplication;

import at.nucle.e4.plugin.preferences.core.api.EPreferenceService;


public class PreferenceContextFactory extends ContextFunction {

    @Override
    public Object compute(final IEclipseContext context, final String contextKey) {
        final EPreferenceService preferenceService = ContextInjectionFactory.make(PreferenceService.class, context);
        final MApplication application = context.get(MApplication.class);
        final IEclipseContext applicationContext = application.getContext();
        applicationContext.set(EPreferenceService.class, preferenceService);
        return preferenceService;
    }
}

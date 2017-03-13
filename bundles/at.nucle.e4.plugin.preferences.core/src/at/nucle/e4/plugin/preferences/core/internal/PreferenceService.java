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

import javax.inject.Inject;

import org.eclipse.jface.preference.PreferenceManager;

import at.nucle.e4.plugin.preferences.core.api.EPreferenceService;

public class PreferenceService implements EPreferenceService {


	@Inject
	PreferenceRegistry registry;

	@Override
	public PreferenceManager getPreferenceManager() {
		System.out.println("SERVICE CALLED");
		return registry.getPreferenceManager();
	}

}

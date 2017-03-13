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

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.jface.preference.PreferenceManager;

import at.nucle.e4.plugin.preferences.core.api.EPreferenceService;
import at.nucle.e4.plugin.preferences.core.internal.registry.PreferenceRegistry;

public class PreferenceService implements EPreferenceService {

	@Inject
	PreferenceRegistry preferenceRegistry;

	private PreferenceManager preferenceManager;

	@PostConstruct
	public void create() {
		this.preferenceManager = new PreferenceManager();
	}

	@Override
	public PreferenceManager getPreferenceManager() {
		return this.preferenceRegistry.createPages(this.preferenceManager);
	}

	@PreDestroy
	public void destroy() {
		if (this.preferenceManager != null) {
			this.preferenceManager.removeAll();
			this.preferenceManager = null;
		}
	}
}

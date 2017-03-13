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
package at.nucle.e4.preferences.example.handler;


import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Shell;

import at.nucle.e4.plugin.preferences.core.api.EPreferenceService;


public class PreferenceHandler {

	@Execute
	public void execute(Shell shell, EPreferenceService service) {
        final PreferenceDialog dlg = new PreferenceDialog(shell, service.getPreferenceManager());
        dlg.create();
        dlg.open();
	}
}

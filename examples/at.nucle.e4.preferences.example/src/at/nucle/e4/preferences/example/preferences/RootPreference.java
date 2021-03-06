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
package at.nucle.e4.preferences.example.preferences;

import javax.inject.Inject;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

import at.nucle.e4.preferences.example.injection.CustomInjection;

public class RootPreference extends FieldEditorPreferencePage {

	@Inject
	CustomInjection injection;

	@Override
	protected void createFieldEditors() {
		addField(new BooleanFieldEditor("truefalse", "dsda", getFieldEditorParent()));
		injection.call();
	}

}

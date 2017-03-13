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
package at.nucle.e4.preferences.example.injection;

import org.eclipse.e4.core.di.annotations.Creatable;

@Creatable
public class CustomInjection {

	public void call() {
		System.out.println("Hello");
	}
}

package at.nucle.e4.plugin.preferences.core.internal;

import javax.inject.Inject;

import org.eclipse.jface.preference.PreferenceManager;

import at.nucle.e4.plugin.preferences.core.api.IPreferencePageService;

public class PreferencePageService implements IPreferencePageService {


	@Inject
	PreferenceRegistry registry;

	@Override
	public PreferenceManager getPreferenceManager() {
		System.out.println("SERVICE CALLED");
		return registry.getPreferenceManager();
	}

}

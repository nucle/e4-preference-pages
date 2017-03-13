package at.nucle.e4.preferences.example.preferences;

import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.core.runtime.preferences.InstanceScope;

import at.nucle.e4.plugin.preferences.core.api.IPreferenceScope;

public class InstanceStoreScope implements IPreferenceScope {

	@Override
	public IScopeContext getScopeContext() {
		return InstanceScope.INSTANCE;
	}

	@Override
	public String getNode() {
		return "at.nucle.git";
	}

}

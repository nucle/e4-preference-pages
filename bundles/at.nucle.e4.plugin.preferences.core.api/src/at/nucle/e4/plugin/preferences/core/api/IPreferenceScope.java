package at.nucle.e4.plugin.preferences.core.api;

import org.eclipse.core.runtime.preferences.IScopeContext;

public interface IPreferenceScope {

	IScopeContext getScopeContext();

	String getNode();
}

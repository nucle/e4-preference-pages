package at.nucle.e4.plugin.preferences.core.internal.registry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Creatable;

import at.nucle.e4.plugin.preferences.core.api.IPreferenceScope;
import at.nucle.e4.plugin.preferences.core.internal.context.PreferenceScopeContext;

@Creatable
public class PreferenceScopeRegistry {

	private static final String TAG = PreferenceRegistry.class.getSimpleName();

	private static String PREFERENCE_SCOPE_EXTENSION_POINT_ID = "at.nucle.e4.plugin.preference.scope";
	private static final String ELEMENT_SCOPE = "scope";
	private static final String ATTRIBUTE_CLASS = "class";

	private Map<String, PreferenceScopeContext> scopes = new HashMap<>();

	@PostConstruct
	public void initialize() {
		getConfigurationElements().forEach(element -> {
			if (element.getAttribute(ATTRIBUTE_CLASS) != null) {
				try {
					IPreferenceScope scope = (IPreferenceScope) element.createExecutableExtension(ATTRIBUTE_CLASS);
					scopes.put(element.getNamespaceIdentifier(),
							new PreferenceScopeContext(scope.getScopeContext(), scope.getNode()));
					System.out.println(element.getNamespaceIdentifier());
				} catch (CoreException e) {
					System.out.println(TAG + " Class must implement IPreferenceScope " + e);
				}
			} else {
				System.out.println(TAG + " Attribute class may not be null");
			}
		});
	}

	private List<IConfigurationElement> getConfigurationElements() {
		return filterElementByTag(
				Platform.getExtensionRegistry().getConfigurationElementsFor(PREFERENCE_SCOPE_EXTENSION_POINT_ID));
	}

	private Predicate<IConfigurationElement> isPreference = config -> ELEMENT_SCOPE.equals(config.getName());

	private List<IConfigurationElement> filterElementByTag(IConfigurationElement[] configurationElements) {
		return Stream.of(configurationElements).filter(isPreference).collect(Collectors.toList());
	}

	public PreferenceScopeContext findPreferenceStore(String bundleId) {
		PreferenceScopeContext store = scopes.get(bundleId);
		if (store == null) {
			store = new PreferenceScopeContext(InstanceScope.INSTANCE, bundleId);
		}
		return store;
	}
}

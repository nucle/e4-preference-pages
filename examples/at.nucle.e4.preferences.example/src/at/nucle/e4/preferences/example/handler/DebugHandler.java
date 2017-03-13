package at.nucle.e4.preferences.example.handler;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.prefs.Preferences;

import at.nucle.e4.plugin.preferences.core.api.EPreferenceService;

public class DebugHandler {
	@Execute
	public void execute(Shell shell, EPreferenceService service) {
		Preferences preferences = InstanceScope.INSTANCE.getNode("at.nucle.git");
		boolean isTrue = preferences.getBoolean("truefalse", false);
		System.out.println(isTrue);

		String text = preferences.get("text", "null");
		System.out.println(text);
	}
}

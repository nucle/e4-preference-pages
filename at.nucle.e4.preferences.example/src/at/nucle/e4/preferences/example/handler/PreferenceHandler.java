package at.nucle.e4.preferences.example.handler;


import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.jface.preference.PreferenceDialog;
import org.eclipse.swt.widgets.Shell;

import at.nucle.e4.plugin.preferences.core.api.IPreferencePageService;

public class PreferenceHandler {

	@Execute
	public void execute(Shell shell, IPreferencePageService service) {
        final PreferenceDialog dlg = new PreferenceDialog(shell, service.getPreferenceManager());
        dlg.create();
        dlg.open();
	}
}

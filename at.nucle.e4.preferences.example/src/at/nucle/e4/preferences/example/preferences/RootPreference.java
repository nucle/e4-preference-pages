package at.nucle.e4.preferences.example.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;

public class RootPreference extends FieldEditorPreferencePage{

	@Override
	protected void createFieldEditors() {
		addField(new BooleanFieldEditor("sddd", "dsda", getFieldEditorParent()));
	}

}

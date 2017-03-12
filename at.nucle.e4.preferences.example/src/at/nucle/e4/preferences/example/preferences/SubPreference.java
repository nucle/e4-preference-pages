package at.nucle.e4.preferences.example.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;

public class SubPreference extends FieldEditorPreferencePage{

	@Override
	protected void createFieldEditors() {
		addField(new StringFieldEditor("dsdsdd", "sdsds", getFieldEditorParent()));
	}

}

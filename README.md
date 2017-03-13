# e4-preference-pages
Managing preference pages with an extension point in Eclipse 4. 

### Extendion Points:

|Extension  | Preference Page                                               |
|-----------|---------------------------------------------------------------|
| class*    | Must implement PreferencePage or FieldEditorPreferencePage    |
| id*       | Id of the page e.g. page_general                              |
| title     | Title of the page                                             |
| category  | Rood node/id e.g. page_root                                   |
| order*    | Page position                                                 |


|Extension  | Preference Scope                                              |
|-----------|---------------------------------------------------------------|
| class*    | Must implement IPreferenceStore                               |



### Show prefrences example:
Inject EPreferenceService and set preference manager in preference dialog.
```java
    @Execute
    public void showPreferences(Shell shell, EPreferenceService service) {
        final PreferenceDialog dlg = new PreferenceDialog(shell, service.getPreferenceManager());
        dlg.create();
        dlg.open();
    }
```
A simple preference page which extends FieldEditorPreferencePage. 
Furthermore dependency injection is also available if you need it.
```java
public class PreferenceGeneralPage extends FieldEditorPreferencePage {

    @Inject
    MyService service;

    public PreferenceGeneralPage() {
        super(GRID);
        setTitle("General");
    }

    @Override
    protected void createFieldEditors() {
        addField(new ColorFieldEditor("pref_text_color", "Text color:", getFieldEditorParent()));
        addField(new ColorFieldEditor("pref_link_color", "Link color:", getFieldEditorParent()));
    }
}
```

### Define custom instance scope:

TODO example

TODO download section

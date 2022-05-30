package Week14;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class JavaFilter extends FileFilter {

	private static final String JAVA = "java";
	private static final char DOT = '.';
	//accepts only directories and
	//files with .java extension only
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		if (extension(f).equalsIgnoreCase(JAVA)) {
			return true;
		} else {
			return false;
		}
	}
	
	//description of the filtered files
	public String getDescription( ) {
		return "Java source files (.java)";
	}
	//extracts the extension from the filename
	private String extension(File f) {
		String filename = f.getName();
		int loc = filename.lastIndexOf(DOT);
		if (loc > 0 && loc < filename.length() - 1) {
		//make sure the dot is not
		//at the first or the last character position
		return filename.substring(loc+1);
		} else {
		return "";
		}
	}
}

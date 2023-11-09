package br.unifor.grafo.floydwarshall;
import java.io.File;

import javax.swing.filechooser.FileFilter;


public class FiltroFiles extends FileFilter {

	public boolean accept(File f) {
		String extensao = getExtension(f);
		if(f.isDirectory())
			return true;
		if(extensao != null && f.isFile() && extensao.equals("txt"))
			return true;
		return false;
	}

	public String getDescription() {
		
		return "*.txt";
	}
	
	private String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }

}

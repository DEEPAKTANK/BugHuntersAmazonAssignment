package Kairos.Hunters.Library;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * @author KT1560 (Deepak Tank)
 * @CreatedDate 05-05-2023
 * 
 * @outputparam  returns particular data
 */

public class DataUtility {
	ConstantUtils path=new ConstantUtils();

	public String fetchProperty(String key)  {

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path.getPropertyPath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties pobj = new Properties();
		try {
			pobj.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pobj.getProperty(key);
	}
	
}

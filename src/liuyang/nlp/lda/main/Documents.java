package liuyang.nlp.lda.main;

import java.util.ArrayList;
import java.util.Map;

/**Class for corpus which consist of M documents
 * @author yangliu
 * @blog http://blog.csdn.net/yangliuy
 * @mail yang.liu@pku.edu.cn
 */

public class Documents {
	
	ArrayList<Document> docs; 
	Map<String, Integer> termToIndexMap;
	ArrayList<String> IndexToTermMap;
	Map<String,Integer> termCountMap;
	
	public static class Document {	
		private String docName;
		int[] docWords;
		
		public Document(String docName, Map<String, Integer> termToIndexMap, ArrayList<String> IndexToTermMap, Map<String, Integer> termCountMap){
			
		}
		
	}
	
	

}

package liuyang.nlp.lda.main;

/**Liu Yang's for implementation of Gibbs Sampling of LDA
 * @author yangliu
 * @blog http://blog.csdn.net/yangliuy
 * @mail yang.liu@pku.edu.cn
 */

public class LdaGibbsSampling {
	
	int [][] doc;
	int V, K, M;
	int [][] z;
	double alpha; //doc-topic dirichlet prior parameter 
	double beta; //topic-word dirichlet prior parameter
	int [][] nmk;//given document m, count times of topic k. M*K
	int [][] nkt;//given topic k, count times of term t. K*V
	int [] nmkSum;//Sum for each row in nmk
	int [] nktSum;//Sum for each row in nkt
	double [][] phi;//Parameters for topic-word distribution K*V
	double [][] theta;//Parameters for doc-topic distribution M*K
	int iterations;//Times of iterations
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Initialize all count variables
		

	}

}

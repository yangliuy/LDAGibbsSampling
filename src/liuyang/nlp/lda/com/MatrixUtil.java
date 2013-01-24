package liuyang.nlp.lda.com;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class MatrixUtil {
	// irregular array
	public static int[][] getArray() {
		int [][] num={{1,2,3},{4,5},{2}};
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++)
				System.out.println(num[i][j]);
		}
		return num;
	}
	public static void printArray(int [][] num) {
		//int [][] num={{1,2,3},{4,5},{2}};
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++)
				System.out.print(num[i][j] + "\t");
			System.out.println();
		}
	}
	public static void printArray(short [][] num) {
		//int [][] num={{1,2,3},{4,5},{2}};
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < num[i].length; j++)
				System.out.print(num[i][j] + "\t");
			System.out.println();
		}
	}
	
	public static void printArray(int[] num) {
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	}
	
	public static void printArray(long[] num) {
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	}
	
	public static void printArray(double[] num) {
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] + "\t");
		}
		System.out.println();
	}
	public static void printArray(boolean[][] bs) {
		for(int i = 0; i < bs.length; i++) {
			for(int j = 0; j < bs[i].length; j++) {
				if(bs[i][j])
					System.out.print("1\t");
				else
					System.out.print("0\t");
			}
			System.out.println();
		}
	}
	public static double sumRow(int[][] matrix, int u) {
		double a = 0.0D;
		for(int m = 0; m < matrix[u].length; m++) {
			a += matrix[u][m];
		}
		return a;
	}
	public static float sum(double[] a2) {
		long a = 0l;
		for(int i = 0; i < a2.length; i++) {
			a += a2[i];
		}
		return a;
	}
	public static int max(int[] flag) {
		int max = flag[0];
		for(int i = 1; i < flag.length; i++) {
			if(flag[i] > max)
				max = flag[i];
		}
		return max;
	}
	public static double max(double[] flag) {
		double max = flag[0];
		for(int i = 1; i < flag.length; i++) {
			if(flag[i] > max)
				max = flag[i];
		}
		return max;
	}
	public static double min(double[] flag) {
		double min = flag[0];
		for(int i = 1; i < flag.length; i++) {
			if(flag[i] < min)
				min = flag[i];
		}
		return min;
	}
}

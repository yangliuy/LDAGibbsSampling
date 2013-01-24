package liuyang.nlp.lda.com;
/**
 * 	This class contains common operations for data structure like array, arrayList, HashMap etc.
 * 
 * */

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class ComUtil {
	/**
	 * String Operations
	 * */
	public static void tokenize(String line, ArrayList<String> tokens) {
		StringTokenizer strTok = new StringTokenizer(line);
		while (strTok.hasMoreTokens()) {
			String token = strTok.nextToken();
			tokens.add(token);
		}
	}

	/**
	 * Print
	 * */
	public static void print(ArrayList tokens) {
		for (int i = 0; i < tokens.size(); i++) {
			System.out.print(tokens.get(i) + " ");
		}
		System.out.print("\n");
		System.out.print("\n");
	}

	public static void print(String[] files) {

		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i] + " ");
		}
		System.out.print("\n");
	}

	public static void print(double[] probs, String string, String end) {
		for(int i = 0; i < probs.length; i++) {
			System.out.print(probs[i] + string);
		}
		System.out.print(end);
	}

	/**
	 * HashMap Operations
	 * */
	public static void printHash(HashMap<String, Integer> hashMap) {
		System.out.println("Print HashMap");
		Set s = hashMap.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			System.out.println(m.getKey() + "\t" + m.getValue());
		}
	}

	public static ArrayList<String> getHashMap(HashMap<String, String> hm) {
		ArrayList<String> a = new ArrayList<String>();
		Set s = hm.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			a.add(m.getKey() + "\t" + m.getValue());
		}
		return a;
	}

	public static ArrayList<String> getHashMap2(HashMap<String, Integer> hm) {
		ArrayList<String> a = new ArrayList<String>();
		Set s = hm.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			a.add(m.getKey() + "\t" + m.getValue());
		}
		return a;
	}

	public static String getKeysFromValue(HashMap<Integer, String> hm,
			String value) {
		Set s = hm.entrySet();
		// Move next key and value of HashMap by iterator
		Iterator it = s.iterator();
		while (it.hasNext()) {
			// key=value separator this by Map.Entry to get key and value
			Map.Entry m = (Map.Entry) it.next();
			if (m.getValue().equals(value))
				return m.getKey() + "";
		}
		System.err.println("Error, can't find the data in Hashmap!");
		return null;
	}

	public static void readHash(String type_map, HashMap<String, String> typeMap) {

		ArrayList<String> types = new ArrayList<String>();
		ArrayList<String> tokens = new ArrayList<String>();

		if (type_map != null) {
			FileUtil.readLines(type_map, types);
			for (int i = 0; i < types.size(); i++) {
				if (!types.get(i).isEmpty()) {
					ComUtil.tokenize(types.get(i), tokens);
					if (tokens.size() != 0) {
						if (tokens.size() != 2) {
							for (int j = 0; j < tokens.size(); j++) {
								System.out.print(tokens.get(j) + " ");
							}
							System.err
									.println(type_map
											+ " Error ! Not two elements in one line !");
							return;
						}
						if (!typeMap.containsKey(tokens.get(0)))
							typeMap.put(tokens.get(0), tokens.get(1));
						else {
							System.out.println(tokens.get(0) + " "
									+ tokens.get(1));
							System.err.println(type_map
									+ " Error ! Same type in first column !");
							return;
						}
					}
					tokens.clear();
				}
			}
		}
	}

	public static void readHash2(String type_map,
			HashMap<String, Integer> hashMap) {
		ArrayList<String> types = new ArrayList<String>();
		ArrayList<String> tokens = new ArrayList<String>();

		if (type_map != null) {
			FileUtil.readLines(type_map, types);
			for (int i = 0; i < types.size(); i++) {
				if (!types.get(i).isEmpty()) {
					ComUtil.tokenize(types.get(i), tokens);
					if (tokens.size() != 0) {
						if (tokens.size() != 2) {
							for (int j = 0; j < tokens.size(); j++) {
								System.out.print(tokens.get(j) + " ");
							}
							System.err
									.println(type_map
											+ " Error ! Not two elements in one line !");
							return;
						}
						if (!hashMap.containsKey(tokens.get(0)))
							hashMap.put(tokens.get(0),
									new Integer(tokens.get(1)));
						else {
							System.out.println(tokens.get(0) + " "
									+ tokens.get(1));
							System.err.println(type_map
									+ " Error ! Same type in first column !");
							return;
						}
					}
					tokens.clear();
				}
			}
		}
	}

	public static void readHash3(String type_map,
			HashMap<String, Double> hashMap) {

		ArrayList<String> types = new ArrayList<String>();
		ArrayList<String> tokens = new ArrayList<String>();

		if (type_map != null) {
			FileUtil.readLines(type_map, types);
			for (int i = 0; i < types.size(); i++) {
				if (!types.get(i).isEmpty()) {
					ComUtil.tokenize(types.get(i), tokens);
					if (tokens.size() != 0) {
						if (tokens.size() != 2) {
							for (int j = 0; j < tokens.size(); j++) {
								System.out.print(tokens.get(j) + " ");
							}
							System.err
									.println(type_map
											+ " Error ! Not two elements in one line !");
							return;
						}
						if (!hashMap.containsKey(tokens.get(0)))
							hashMap.put(tokens.get(0),
									new Double(tokens.get(1)));
						else {
							System.out.println(tokens.get(0) + " "
									+ tokens.get(1));
							System.err.println(type_map
									+ " Error ! Same type in first column !");
							return;
						}
					}
					tokens.clear();
				}
			}
		}
	}

	public static double readHashTopValue(HashMap<String, Integer> scores, int k) {
		List list = new LinkedList(scores.entrySet());
		int count = 0;
		int value = 0;
		double res = 0;
		for (Iterator it = list.iterator(); count < k && it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			value = (Integer) entry.getValue();
			res += (double) value * Math.log(2) / Math.log(count + 2);
			// res += (Integer) entry.getValue();
			count++;
		}
		return res;
	}

	/**
	 * Frequently used functions
	 * */
	static public int count(String a, String contains) {
		int i = 0;
		int count = 0;
		while (a.contains(contains)) {
			i = a.indexOf(contains);
			a = a.substring(0, i)
					+ a.substring(i + contains.length(), a.length());
			count++;
		}
		return count;
	}

	@SuppressWarnings("unchecked")
	public static HashMap<?,?> sortByValue(HashMap<?,?> map, final int flag) {
		// flag = 0 decreasing order otherwise increasing
		List list = new LinkedList(map.entrySet());
		Collections.sort(list, new Comparator() {
			public int compare(Object o1, Object o2) {
				if(flag == 0 )
					return ((Comparable) ((Map.Entry) (o2)).getValue())
						.compareTo(((Map.Entry) (o1)).getValue());
				else
					return ((Comparable) ((Map.Entry) (o1)).getValue())
					.compareTo(((Map.Entry) (o2)).getValue());
			}
		});

		HashMap result = new LinkedHashMap();
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			result.put(entry.getKey(), entry.getValue());
		}
		return result;
	}

	public static double getSumValue(HashMap<String, Double> map) {
		Double count = 0.0D;
		List list = new LinkedList(map.entrySet());
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			count += map.get(entry.getKey());
		}
		return count;
	}

	public static int getFrequentElement(int[] bcp) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Integer> uniId = new ArrayList<Integer>();
		int id = 0;

		for (int col = 0; col < bcp.length; col++) {
			// System.out.print(bcp[col] + "\t");
			int no = 0;
			if (!map.containsKey(bcp[col])) {
				map.put(bcp[col], id++);
				count.add(1);
				uniId.add(bcp[col]);
			} else {
				no = map.get(bcp[col]);
				count.set(no, count.get(no) + 1);
			}
		}

		int maximum = Integer.MIN_VALUE;
		int maxId = Integer.MIN_VALUE;
		for (int i = 0; i < count.size(); i++) {
			// System.out.print(uniId.get(i) + ":" + count.get(i) + ",\t");
			if (maximum < count.get(i)) {
				maximum = count.get(i);
				maxId = uniId.get(i);
			}
		}
		// System.out.println();

		map.clear();
		uniId.clear();
		count.clear();
		return maxId;
	}

	public static void getFrequentElement(int[][] bcp, int[] res, char flag) {
		if (flag == 'r') {
			for (int row = 0; row < bcp.length; row++) {
				res[row] = getFrequentElement(bcp[row]);
			}
		} else {
			int colL = bcp[0].length;
			int[] column = new int[bcp.length];
			for (int col = 0; col < colL; col++) {
				for (int row = 0; row < bcp.length; row++) {
					column[row] = bcp[row][col];
				}
				res[col] = getFrequentElement(column);
			}
		}
	}

	public static short getFrequentElement(short[] bcp) {
		HashMap<Short, Short> map = new HashMap<Short, Short>();
		ArrayList<Short> count = new ArrayList<Short>();
		ArrayList<Short> uniId = new ArrayList<Short>();
		short id = 0;

		for (short col = 0; col < bcp.length; col++) {
			// System.out.print(bcp[col] + "\t");
			short no = 0;
			if (!map.containsKey(bcp[col])) {
				map.put(bcp[col], id++);
				count.add((short) 1);
				uniId.add(bcp[col]);
			} else {
				no = map.get(bcp[col]);
				count.set(no, (short) (count.get(no) + 1));
			}
		}

		short maximum = Short.MIN_VALUE;
		short maxId = Short.MIN_VALUE;
		for (int i = 0; i < count.size(); i++) {
			// System.out.print(uniId.get(i) + ":" + count.get(i) + ",\t");
			if (maximum < count.get(i)) {
				maximum = count.get(i);
				maxId = uniId.get(i);
			}
		}
		// System.out.println();

		map.clear();
		uniId.clear();
		count.clear();
		return maxId;
	}

	public static boolean getFrequentElementBinary(int[] sample) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<Integer> uniId = new ArrayList<Integer>();
		int id = 0;

		for (int col = 0; col < sample.length; col++) {
			// System.out.print(bcp[col] + "\t");
			int no = 0;
			if (!map.containsKey(sample[col])) {
				map.put(sample[col], id++);
				count.add(1);
				uniId.add(sample[col]);
			} else {
				no = map.get(sample[col]);
				count.set(no, count.get(no) + 1);
			}
		}

		int maximum = Integer.MIN_VALUE;
		int maxId = Integer.MIN_VALUE;
		for (int i = 0; i < count.size(); i++) {
			// System.out.print(uniId.get(i) + ":" + count.get(i) + ",\t");
			if (maximum < count.get(i)) {
				maximum = count.get(i);
				maxId = uniId.get(i);
			}
		}
		// System.out.println();

		map.clear();
		uniId.clear();
		count.clear();
		if(maxId == 1)
			return true;
		else
			return false;
	}
	
	public static int[] CountElmt(ArrayList<Integer> newScores1,
			ArrayList<Integer> scores) {
		int a[] = new int[scores.size()];
		for (int i = 0; i < scores.size(); i++) {
			a[i] = 0;
		}
		for (int i = 0; i < newScores1.size(); i++) {
			int value = newScores1.get(i);
			int pos = scores.indexOf(value);
			a[pos]++;
		}
		return a;
	}

	public static int countCommElmts(ArrayList<Integer> newScores1,
			ArrayList<Integer> newScores2) {
		int count = 0;
		for (int i = 0; i < newScores1.size(); i++) {
			if (newScores1.get(i) == newScores2.get(i))
				count++;
		}
		return count;
	}

	public static void uniqe(int[] words, ArrayList<Integer> tempUniqueWords,
			ArrayList<Integer> tempCounts) {
		for (int i = 0; i < words.length; i++) {
			if (tempUniqueWords.contains(words[i])) {
				int index = tempUniqueWords.indexOf(words[i]);
				tempCounts.set(index, tempCounts.get(index) + 1);
			} else {
				tempUniqueWords.add(words[i]);
				tempCounts.add(1);
			}
		}
	}

	public static void uniqe(ArrayList<Integer> items) {
		// add elements to al, including duplicates
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.addAll(items);
		items.clear();
		items.addAll(hs);
	}

	public static void getTop(float[] array, ArrayList<Integer> rankList, int i) {
		rankList.clear();
		
		int index = 0;
		HashSet<Integer> scanned = new HashSet<Integer>();
		float max = Float.MIN_VALUE;
		for (int m = 0; m < i && m < array.length; m++) {
			boolean flag = false;
			max = Float.MIN_VALUE;
			for (int no = 0; no < array.length; no++) {
				if (!scanned.contains(no) && array[no] >= max) {
					index = no;
					max = array[no];
					flag = true;
				}
			}
			if(flag) { // found value
				scanned.add(index);
				rankList.add(index);
	//			rankProbs.add(array[index]);
			}
			//System.out.println(m + "\t" + index);
		}
	}

	public static void getTop(float[] array, ArrayList<Integer> rankList,
			ArrayList<Float> rankProbs, int i) {
		// clear
		rankList.clear();
		rankProbs.clear();
		//
		int index = 0;
		int count = 0;
		HashSet<Integer> scanned = new HashSet<Integer>();
		float max = Float.MIN_VALUE;
		for (int m = 0; m < i && m < array.length; m++) {
			boolean flag = false;
			max = Float.MIN_VALUE;
			for (int no = 0; no < array.length; no++) {
				if (array[no] >= max && !scanned.contains(no)) {
					index = no;
					max = array[no];
					flag = true;
				}
			}
			if(flag) { // found value
				scanned.add(index);
				rankList.add(index);
				rankProbs.add(array[index]);
			}
			//System.out.println(m + "\t" + index);
		}
	}

	public static void getTopNZ(float[] array, int[] counts,
			ArrayList<Integer> rankList, ArrayList<Float> rankProbs, int i, int threshold) {
		// clear
		rankList.clear();
		rankProbs.clear();
		//
		int index = 0;
		float max = Float.MIN_VALUE;
		for (int m = 0; m < i && m < array.length; m++) {
			boolean flag = false;
			max = Float.MIN_VALUE;
			for (int no = 0; no < array.length; no++) {
				if(counts[no] >= threshold) {
					if (array[no] >= max && !rankList.contains(no)) {
						index = no;
						max = array[no];
						flag = true;
					}
				}
			}
			if(flag) { // found value
				rankList.add(index);
//				rankProbs.add(array[index]);
				rankProbs.add(counts[index] + 0.0f);
			}
			//System.out.println(m + "\t" + index);
		}
	}

	public static int sample(double[] probs, int T) {
		// roulette sampling
		
		double []pt = new double[T];
		//System.out.print(p[0]);
		pt[0] = probs[0];
		for (int i = 1; i < T; i++) {
			pt[i] = probs[i] + pt[i-1];
//			System.out.print(" " + pt[i]);
		}
//		System.out.println();

		// scaled sample because of unnormalized p[]
		double rouletter = (double) (Math.random() * pt[T - 1]);
		short sample = 0;
		for (sample = 0; sample < T; sample++) {
			if (pt[sample] > rouletter)
				break;
		}
//		System.out.println(rouletter + "\t" + sample);
		
		if(sample < 0 | sample >= T) {
			ComUtil.print(probs, "\t", "\n");
			System.out.println("Sampling error!");
			System.exit(0);
		}
		return sample;
	}
}
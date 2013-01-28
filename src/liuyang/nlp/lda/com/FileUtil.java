package liuyang.nlp.lda.com;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


public class FileUtil {

	public static void readLines(String file, ArrayList<String> lines) {
		BufferedReader reader = null;

		try {

			reader = new BufferedReader(new FileReader(new File(file)));

			String line = null;
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void writeLines(String file, HashMap<?, ?> hashMap) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(new File(file)));

			Set<?> s = hashMap.entrySet();
			Iterator<?> it = s.iterator();
			while (it.hasNext()) {
				Map.Entry m = (Map.Entry) it.next();
				writer.write(m.getKey() + "\t" + m.getValue() + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void writeLines(String file, ArrayList<?> counts) {
		BufferedWriter writer = null;

		try {

			writer = new BufferedWriter(new FileWriter(new File(file)));

			for (int i = 0; i < counts.size(); i++) {
				writer.write(counts.get(i) + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void writeLines(String file, ArrayList<String> uniWordMap,
			ArrayList<Integer> uniWordMapCounts) {
		BufferedWriter writer = null;

		try {

			writer = new BufferedWriter(new FileWriter(new File(file)));

			for (int i = 0; i < uniWordMap.size()
					|| i < uniWordMapCounts.size(); i++) {
				writer.write(uniWordMap.get(i) + "\t" + uniWordMapCounts.get(i)
						+ "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void writeLinesSorted(String file, ArrayList<?> uniWordMap,
			ArrayList<?> uniWordMapCounts, int flag) {
		// flag = 0 decreasing order otherwise increasing
		HashMap map = new HashMap();
		if (uniWordMap.size() != uniWordMapCounts.size()) {
			System.err.println("Array sizes are not equal!!! Function returned.");
		} else {
			for (int i = 0; i < uniWordMap.size(); i++) {
				map.put(uniWordMap.get(i), uniWordMapCounts.get(i));
			}
			map = (HashMap<String, Integer>) ComUtil.sortByValue(map, flag);
			writeLines(file, map);
			map.clear();
		}
	}

	public static void tokenize(String line, ArrayList<String> tokens) {
		StringTokenizer strTok = new StringTokenizer(line);
		while (strTok.hasMoreTokens()) {
			String token = strTok.nextToken();
			tokens.add(token);
		}
	}

	public static void print(ArrayList<?> tokens) {
		for (int i = 0; i < tokens.size(); i++) {
			System.out.print(tokens.get(i) + " ");
		}
		System.out.print("\n");
	}

	// HashMap Operations
	public static void printHash(HashMap<String, Integer> hashMap) {
		Set<?> s = hashMap.entrySet();
		Iterator<?> it = s.iterator();
		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			System.out.println(m.getKey() + "\t" + m.getValue());
		}
	}

	public static ArrayList<String> getHashMap(HashMap<?, ?> hm) {
		ArrayList<String> a = new ArrayList<String>();
		Set<?> s = hm.entrySet();
		Iterator<?> it = s.iterator();
		while (it.hasNext()) {
			Map.Entry m = (Map.Entry) it.next();
			a.add(m.getKey() + "\t" + m.getValue());
		}
		return a;
	}

	public static String getKeysFromValue(HashMap<Integer, String> hm,
			String value) {
		Set<?> s = hm.entrySet();
		// Move next key and value of HashMap by iterator
		Iterator<?> it = s.iterator();
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
			readLines(type_map, types);
			for (int i = 0; i < types.size(); i++) {
				if (!types.get(i).isEmpty()) {
					FileUtil.tokenize(types.get(i), tokens);
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
			readLines(type_map, types);
			for (int i = 0; i < types.size(); i++) {
				if (!types.get(i).isEmpty()) {
					FileUtil.tokenize(types.get(i), tokens);
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
			HashMap<String, Integer> hashMap) {

		ArrayList<String> types = new ArrayList<String>();
		ArrayList<String> tokens = new ArrayList<String>();

		if (type_map != null) {
			readLines(type_map, types);
			for (int i = 0; i < types.size(); i++) {
				if (!types.get(i).isEmpty()) {
					FileUtil.tokenize(types.get(i), tokens);
					if (tokens.size() != 0) {
						if (tokens.size() < 2) {
							for (int j = 0; j < tokens.size(); j++) {
								System.out.print(tokens.get(j) + " ");
							}
							System.err
									.println(type_map
											+ " Error ! Not two elements in one line !");
							return;
						}
						String key = tokens.get(0);
						String value = tokens.get(tokens.size() - 1);
						for (int no = 1; no < tokens.size() - 1; no++) {
							key += " " + tokens.get(no);
						}
						if (!hashMap.containsKey(key))
							hashMap.put(key, new Integer(value));
						else {
							System.out.println(key + " " + value);
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

	/**
	 * Create a directory by calling mkdir();
	 * 
	 * @param dirFile
	 */
	public static void mkdir(File dirFile) {
		try {
			// File dirFile = new File(mkdirName);
			boolean bFile = dirFile.exists();
			if (bFile == true) {
				System.err.println("The folder exists.");
			} else {
				System.err
						.println("The folder do not exist,now trying to create a one...");
				bFile = dirFile.mkdir();
				if (bFile == true) {
					System.out.println("Create successfully!");
				} else {
					System.err
							.println("Disable to make the folder,please check the disk is full or not.");
				}
			}
		} catch (Exception err) {
			System.err.println("ELS - Chart : unexpected error");
			err.printStackTrace();
		}
	}

	public static void mkdir(File file, boolean b) {
		if(b) {// true delete first
			deleteDirectory(file);
			mkdir(file);
		} else {
			mkdir(file);
		}
	}

	/**
	 * 
	 * @param path
	 * @return
	 */
	static public boolean deleteDirectory(File path) {
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (path.delete());
	}

	/**
	 * List files in a given directory
	 * 
	 * */
	static public String[] listFiles(String inputdir) {
		File dir = new File(inputdir);

		String[] children = dir.list();
		if (children == null) {
			// Either dir does not exist or is not a directory
		} else {
			for (int i = 0; i < children.length; i++) {
				// Get filename of file or directory
				String filename = children[i];
			}
		}

		return children;
	}

	/**
	 * List files in a given directory
	 * 
	 * */
	static public String[] listFilteredFiles(String inputdir,
			final String filterCondition) {
		File dir = new File(inputdir);

		String[] children = dir.list();
		// It is also possible to filter the list of returned files.
		// This example does not return any files that start with `.'.
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(filterCondition);
			}
		};
		children = dir.list(filter);

		return children;
	}

	/**
	 * List files recursively in a given directory
	 * 
	 * */
	static public void listFilesR() {
		File dir = new File("directoryName");

		String[] children = dir.list();

		// The list of files can also be retrieved as File objects
		File[] files = dir.listFiles();

		// This filter only returns directories
		FileFilter fileFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		files = dir.listFiles(fileFilter);

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

	public static void print(String[] files) {

		for (int i = 0; i < files.length; i++) {
			System.out.print(files[i] + " ");
		}
		System.out.print("\n");
	}

	public static void print(int[] c1) {
		for (int i = 0; i < c1.length; i++) {
			System.out.print(c1[i] + " ");
		}
		System.out.println();
	}

	public static void test() {
		String a = "fdsfdsaf";
		a += "\nfdsaf fd fd";
		a += "\nfd sf fd fd\n";
		System.out.println(a);
		a = a.replaceAll("\n+", " ");
		System.out.println(a);
		System.exit(0);
	}

	public static void readHash(String type_map, HashMap<String, String> typeMap, boolean flag) {

		ArrayList<String> types = new ArrayList<String>();
		ArrayList<String> tokens = new ArrayList<String>();
		
		if(type_map != null) {
			readLines(type_map, types);
			for (int i = 0; i < types.size(); i++) {
				if (!types.get(i).isEmpty()) {
					FileUtil.tokenize(types.get(i), tokens);
					if(tokens.size() != 0) {
						if (tokens.size() != 2) {
							for(int j = 0; j < tokens.size(); j++) {
								System.out.print(tokens.get(j)+" ");
							}
							System.err
									.println(type_map + " Error ! Not two elements in one line !");
							return;
						}
						String tokens0 = "";
						String tokens1 = "";
						if(flag) {
							tokens0 = tokens.get(0).trim();
							tokens1 = tokens.get(1).trim();
						} else {
							tokens0 = tokens.get(1).trim();
							tokens1 = tokens.get(0).trim();
						}
						if (!typeMap.containsKey(tokens0))
							typeMap.put(tokens0, tokens1);
						else {
							System.err.println(tokens0 + " " + tokens1);
							System.err
									.println(type_map + " Ignore this one ! Same type in first column !");
						}
					}
					tokens.clear();
				}
			}
		}
	}

	public static String filter4tokenization(String inputstring) {
//		inputstring = "fds fds Won't won't can't Can't ain't";
		// aggregate common tokenization error
		inputstring = inputstring.replaceAll("(?i)won't", "will not");
		inputstring = inputstring.replaceAll("(?i)can't", "can not");
		inputstring = inputstring.replaceAll("(?i)shan't", "shall not");
		inputstring = inputstring.replaceAll("(?i)ain't", "am not");
		return inputstring;
	}

	public static void tokenizeAndLowerCase(String line, ArrayList<String> tokens) {
		// TODO Auto-generated method stub
		StringTokenizer strTok = new StringTokenizer(line);
		while (strTok.hasMoreTokens()) {
			String token = strTok.nextToken();
			tokens.add(token.toLowerCase().trim());
		}
	}
}
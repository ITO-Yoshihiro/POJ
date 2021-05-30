/**
 * Main.java
 *
 * 2021/05/29 ito.y
 *
 * Copyright (c)2021, ADMAX Corporation. All rights reserved.
 */
package jp.co.admax.poj.problem1002;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem No.1002
 * 487-3279
 * 
 * @author ito.y
 *
 */
public class Main {
	static String numb = "000011112ABC3DEF4GHI5JKL6MNO7PRS8TUV9WXY";

	private static List<String>getInput() {
		List<String> inp = new ArrayList<String>();
		
//		Scanner cin = new Scanner(System.in);
//		while (cin.hasNext()) {
//			inp.add(cin.nextLine());
//		}
//		cin.close();
		
		inp.add("12");
		inp.add("4873279");
		inp.add("ITS-EASY");
		inp.add("888-4567");
		inp.add("3-10-10-10");
		inp.add("888-GLOP");
		inp.add("TUT-GLOP");
		inp.add("967-11-11");
		inp.add("310-GINO");
		inp.add("F101010");
		inp.add("888-1200");
		inp.add("-4-8-7-3-2-7-9-");
		inp.add("487-3279");
		
		return inp;
	}
	
	public static class DoublyList {
		DoublyList next;
		DoublyList prev;
		String value;
		int count;
		
		DoublyList(String val) {
			this.value = val;
			this.count = 1;
		}
		int increment() {
			return this.count++;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		List<String> inp = getInput();
		DoublyList head = null;

		
		try {

			int count = Integer.parseInt(inp.get(0));
			for (int i=0; i<count; i++) {
				String tel = getTelephone(inp.get(i+1));
				head = insertTelephone(head, tel);
				//printList(head);
			}
			
			printResult(head);

			//System.out.println("finished.");			
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	static void printResult(DoublyList head) {
		DoublyList ptr = head;
		boolean isDuplicate = false;
		
		while (ptr != null) {
			if (ptr.count > 1) {
				isDuplicate = true;
				System.out.println(ptr.value + " " + ptr.count);
			}
			ptr = ptr.next;
		}
		
		if (!isDuplicate) {
			System.out.println("No duplicates.");
		}
	}

	static void printList(DoublyList head) {
		DoublyList ptr = head;
		
		while (ptr != null) {
			System.out.println(ptr.value + " " + ptr.count);
			ptr = ptr.next;
		}
	}

	static private DoublyList insertTelephone(DoublyList head, String val) {
		System.out.println("["+val+"]");
		DoublyList ptr = head;
		while (ptr != null) {
			System.out.println(ptr.value+"("+ptr.count+")");
			int cmp = val.compareTo(ptr.value);
			if (cmp == 0) {
				//System.out.println("INCREMENT");
				// 同じ電話番号があればインクリメントする
				ptr.increment();
				break;
			}
			else if (cmp < 0) {
				System.out.println("INSERT RIGHT");
				// 着目ノードより小さい場合は、右側に挿入
				DoublyList tmp = new DoublyList(val);
				tmp.next = ptr;
				tmp.prev = ptr.prev;
				if (ptr == head) {
					head = tmp;
				}
				else {
					ptr.prev.next = tmp;
				}
				ptr.prev = tmp;
				break;
			}

			if (ptr.next != null) {
				ptr = ptr.next;
			}
			else {
				System.out.println("INSERT LEFT");
				// 着目ノードが左端の場合は、左側に挿入
				DoublyList tmp = new DoublyList(val);
				tmp.next = ptr.next;
				tmp.prev = ptr;
				ptr.next = tmp;
				break;
			}
		}
		if (head == null) {
			head = new DoublyList(val);
			System.out.println(head.value+"<"+head.count+">");
		}
		
		return head;
	}
	
	static private String getTelephone(String str) {
		StringBuilder sb = new StringBuilder();
		String chr = "";
		String num = "";

		try {
			for (int i=0; i<str.length(); i++) {
				chr = str.substring(i, i+1);
				num = convertNumber(chr);
				sb.append(num);
			}
		}
		catch (Exception e) {
			System.out.println(e);
			return "";
		}
		
		String ret = sb.toString().substring(0, 3)
					+ "-"
					+ sb.toString().substring(3, 7);

		return ret;
	}
	
	static private String convertNumber(String ch) {
		int pos = 0;
		String nm = "";

		if (!ch.equals("-")) {
			for (int j=0; j<numb.length(); j++) {
				String x = numb.substring(j, j+1);
				if (x.equals(ch)) {
					pos = (j / 4) * 4;
					nm = numb.substring(pos, pos+1);
					break;
				}
			}
		}

		return nm;
	}
}

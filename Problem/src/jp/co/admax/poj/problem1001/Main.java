/**
 * Main.java
 *
 * 2021/05/29 ito.y
 *
 * Copyright (c)2021, ADMAX Corporation. All rights reserved.
 */
package jp.co.admax.poj.problem1001;

import java.util.Scanner;

/**
 * Problem No.1001
 * Exponentiation
 * 
 * @author ito.y
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			try {
				StringBuilder sb = new StringBuilder();
				String inp = cin.nextLine();
				String r = inp.substring(0,6);
				System.out.println("inp="+inp+",r="+r);
				int p = 0;
//				int k = 0;
				for (int i=0; i<r.length(); i++) {
					String ch = r.substring(i,i+1);
					if (ch.equals(".")) {
						p = i;
					}
					else if (ch.equals("0") && (p==0)) {
						;
					}
					else {
						sb.append(ch);
					}
				}
				p = 5 - p;
				System.out.println(sb.toString()+" ("+p+")");

				double x = Double.parseDouble(sb.toString());
				double y = x / Math.pow(10, p);
				System.out.println(y);
				
//				String a = sb.toString();
//				String b = sb.toString();


//				int n = Integer.parseInt(inp.substring(7,9).trim());
//				BigDecimal z = new BigDecimal(r);
//				for (int i=1; i<n; i++) {
//					z = z.multiply(new BigDecimal(r));
//				}
//				System.out.println(z.toString());
			}
			catch (Exception e) {
				System.err.println(e);
				break;
			}
		}
		cin.close();
		System.out.println("finished.");
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.micedre.bingo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author micedre
 */
public class BingoStrip implements Serializable {

	private int serial;
	private int[][] page = new int[18][9];
	private Random rnd;

	public BingoStrip(int serial) {
		this.serial = serial;
		rnd = new Random(serial);
		init();
	}

	public int[][] getPage() {
		return page;
	}

	private void init() {

		int[] rowcount = new int[18];
		List<Integer> nombres = new ArrayList<Integer>();
		for (int i = 1; i < 91; i++) {
			nombres.add(i);
		}
		List<List<Integer>> nombresParDizaine = new ArrayList<List<Integer>>();
		for (int i = 0; i < 9; i++) {

			nombresParDizaine.add(new ArrayList<Integer>());
		}
		for (Integer nb : nombres) {
			int realDixaine = nb / 10 == 9 ? 8 : nb / 10;
			nombresParDizaine.get(realDixaine).add(nb);

		}
		for (List<Integer> list : nombresParDizaine) {
			Collections.shuffle(list, rnd);
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 6; j++) {
				int index;
				do {
					index = rnd.nextInt(3);
				} while (!(rowcount[j * 3 + index] < 5));

				page[j * 3 + index][i] = nombresParDizaine.get(i).get(0);
				rowcount[j * 3 + index]++;
				nombres.remove(nombresParDizaine.get(i).get(0));
				nombresParDizaine.get(i).remove(0);

			}
		}
		Collections.shuffle(nombres, rnd);
		for (int i = 0; i < 36; i++) {
			int value = nombres.get(0);
			int dixaine = value / 10 == 9 ? 8 : value / 10;
			boolean found = false;

			for (int j = 0; j < 18; j++) {
				if (page[j][dixaine] == 0 && rowcount[j] < 5) {
					page[j][dixaine] = value;
					rowcount[j]++;
					found = true;
					break;
				}
			}

			if (!found) {
				System.out.println("Can't find a place for " + value);

				int lineTofill = -1;
				for (int j = rowcount.length - 1; j >= 0; j--) {
					if (rowcount[j] < 5) {
						lineTofill = j;
						break;
					}
				}
				System.out.println("linetofill" + lineTofill);

				outerloop: for (int j = rowcount.length - 1; j >= 0; j--) {
					for (int k = 0; k < 9; k++) {
						if (rowcount[j] == 5 && page[j][k] != 0
								&& page[lineTofill][k] == 0
								&& page[j][dixaine] == 0) {
							System.out.println("Swapping value from " + j
									+ ", " + k);
							page[j][dixaine] = value;
							page[lineTofill][k] = page[j][k];
							page[j][k] = 0;
							rowcount[lineTofill]++;
							break outerloop;
						}
					}
				}
			}
			nombres.remove(0);
		}
		Integer[] temp;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < page[0].length; j++) {
				temp = new Integer[] { page[3 * i][j], page[3 * i + 1][j],
						page[3 * i + 2][j] };
				
				Arrays.sort(temp,new IntComparateur());
				page[3 * i][j] = temp[0];
				page[3 * i + 1][j] = temp[1];
				page[3 * i + 2][j] = temp[2];
			}
		}
		System.out.println("\n Final result :");
		for (int i = 0; i < page.length; i++) {
			for (int j = 0; j < page[0].length; j++) {
				System.out.print(page[i][j] + ",");

			}
			System.out.println();
		}

	}

	public int getSerial() {
		return serial;
	}

}

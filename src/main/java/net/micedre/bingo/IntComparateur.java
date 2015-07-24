package net.micedre.bingo;

import java.util.Comparator;

public class IntComparateur implements Comparator<Integer> {

	public int compare(Integer o1, Integer o2) {
		if(o1==0 || o2==0||o1==o2)return 0;
		if(o1<o2)return -1;
		return 1;
	}

}

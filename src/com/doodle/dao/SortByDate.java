package com.doodle.dao;

import java.util.Comparator;
import java.util.Date;


public class SortByDate  implements Comparator {
	 public int compare(Object o1, Object o2) {
		  Message s1 = (Message) o1;
		  Message s2 = (Message) o2;
		  return s1.getChatdate().compareTo(s2.getChatdate());
	 }
}

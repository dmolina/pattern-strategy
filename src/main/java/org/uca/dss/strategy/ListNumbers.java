package org.uca.dss.strategy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.primitives.Doubles;

/**
 * This class store and sort the list numbers
 * @author daniel
 *
 */
public class ListNumbers {
	private List<Double> numbers;

	public ListNumbers() {
		numbers = new LinkedList<Double>();
	}
	/**
	 * Constructor, it is able to read a string of number with space as separator
	 * @param input string with the list of values
	 */
	public ListNumbers(String input) {
		String words[] = StringUtils.split(input, " ");
		numbers = new LinkedList<Double>();

		for (String word : words) {
			try {
				numbers.add(new Double(word));
			} catch (Exception e) {

			}
		}
	}

	/**
	 * @return the numbers
	 */
	public String toString() {
		return StringUtils.join(numbers, ", ");		
	}

	public void sort() {
		// Put in array to print it more easily
		double[] list = Doubles.toArray(numbers);
		int j; 
		boolean flag = true;   // set flag to true to begin first pass
		double temp;   //holding variable

		while ( flag ) {
			flag= false;    //set flag to false awaiting a possible swap
			for( j=0;  j < list.length -1;  j++ )
			{
				if ( list[ j ] > list[j+1] )   // change to > for ascending sort
				{
					temp = list[ j ];                //swap elements
					list[ j ] = list[ j+1 ];
					list[ j+1 ] = temp;
					flag = true;              //shows a swap occurred 
				}
			}
		} 

		numbers = new ArrayList<Double>(Doubles.asList(list));
	}
	
	public boolean isEmpty() {
		return numbers.isEmpty();		 
	}

}

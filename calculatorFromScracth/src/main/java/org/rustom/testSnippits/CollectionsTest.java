
package org.rustom.testSnippits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.mvel2.optimizers.impl.refl.nodes.ArrayLength;

public class CollectionsTest {
	public static void main(String[] args){
		Integer[] a = {1,2,3,4};
		ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(a));
		System.out.println(arrayList);
		Iterator arrayListIterator = arrayList.iterator();
		System.out.println(arrayListIterator.next());
		System.out.println(arrayListIterator.next());
		System.out.println(arrayListIterator.next());
		System.out.println(arrayListIterator.next());
//		System.out.println(arrayListIterator.next()); //throws an exception here
	}
}

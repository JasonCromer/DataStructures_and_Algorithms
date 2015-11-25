/*
	Given a set of intervals (i.e. {1,2}, {2,4}, {3,6}, {8,10}..) merge 
	those that are overlapping.

	Note: This code will not compile. This is merely pseudo-code.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Interval {
	int start;
	int end;

	public Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeOverlappingIntervals{

	public static void main(String[] args) throws java.lang.Exception {
		//Create a list of Intervals
		ArrayList<Interval> intervalList = new ArrayList<>();

		//add intervals
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15, 18);

		intervalList.add(i1);
		intervalList.add(i2);
		intervalList.add(i3);
		intervalList.add(i4);

		ArrayList<Interval> results = mergeIntervals(intervalList);

		for(Interval i : results) {
			System.out.println(i.start + "," + i.end);
		}

	}


	public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals){
		if(intervals.size() == 0 || intervals.size() == 1) return intervals;

		Collections.sort(intervals, new IntervalComparator());

		//Create first item to compare to next interval
		Interval first = intervals.get(0);
		int start = first.start;
		int end = first.end;

		ArrayList<Interval> result = new ArrayList<>();

		for(int i = 1; i < intervals.size(); i++){
			Interval current = intervals.get(i);

			//Compare to our first item and modify
			if(current.start <= end){
				end = Math.max(current.end, end);
			}
			else{
				result.add(new Interval(start, end));
				start = current.start;
				end = current.end;
			}
		}

		result.add(new Interval(start,end));

		return result;
	}

}


class IntervalComparator implements Comparator {
	public int compare(Interval interval1, Interval interval2){
		return interval1.start - interval2.start;
	}
}

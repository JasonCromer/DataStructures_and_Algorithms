/*
Solution

A naive solution would loop through both availability arrays and check every possible pair of availability time spans for a minimal overlap of dur seconds.
Such a solution is not efficient and involves O(⋅m) runtime complexity (when n and m are lengths of timesA and timesB), and O(1) space complexity.

We can do better than that if the availability arrays are sorted (always consider asking your interviewer if the input is sorted).
Even if availability arrays are not sorted, we can still do better by sorting them first.
Since we know nothing else about the times, we can sort each availability array by start times at O(n∙log n) time complexity (when n is the number of time slots in the array).

After taking care of sorting, we can iterate over both arrays at once.
We use one index for each array, while forwarding one index at a time.
At each step we check if:

No overlap exists:
One time span ends before the other starts.
In this case, increase the index of the array with the earlier time.
Overlap exists for at least dur seconds:
The minimum of both end times is more than dur seconds after the maximum of both start times.
In this case, we've found a meeting time.
Overlap exists for less than dur seconds:
we've eliminated both previous cases.
In this case, we increase the index of the array with the earlier start time of its next time span.

*/


[x1,x2] 
[y1,y2]

10,18
12,15


int x1,x2,y1,y2;
startIndex = 0;
endIndex = 1;

maxLength = max(arrayB.length, arrayA.length);
minLength = min(arrayB.length, arrayA.length);

arrayMax = getMaxArray(arrayA, arrayB);
arrayMin = getMinArray(arrayA, arrayB);

bufferArray[][] overlapTimes;

for(int i = 0; i< minLength; i++){
	x1 = arrayMin[i][startIndex];
	x2 = arrayMin[i][endIndex];

	for(int j = 0; j < maxLength; i++){
		y1 = arrayMax[j][startIndex];
		y2 = arrayMax[j][endIndex];

		if(abs(x1-y2) >= 3 && abs(y1-x2) >= 3){
			overlapTimes[j][startIndex] = max(x1,y1);
			overlapTimes[j][endIndex] = min(x2,y2);
		}
	}
}

return overlapTimes;
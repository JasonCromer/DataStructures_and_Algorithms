 
class MergeStringIntervals{
    
    public static void main(String[] args){

        String intervalString = "1:10, 9:15,16:17:19:25";

        compactAndSort(intervalString);
    }






    static String compactAndSort(String ranges) {

        
        //If we have an empty string, return empty string
        if(ranges == null){
            return "";
        }
        else if(ranges.length() < 1){
            return "";
        }
        
        //Strip the string of spaces
        ranges = ranges.replaceAll("\\s+","");
        
        //Convert to String Array
        String[] rangeStringArray = ranges.split(",");
        
        //Create list for our intervals
        ArrayList<IntervalItem> intervals = new ArrayList<>();
        
        //Parse through 
        for(int i = 0; i < rangeStringArray.length; i++){
            String[] buffer = rangeStringArray[i].split(":");
            int startNumberIndex = 0;
            int endNumberIndex = 1;
            
            //Add our start and end intervals to a new IntervalItem
            try{
                int start = Integer.parseInt(buffer[startNumberIndex]);
                int end = Integer.parseInt(buffer[endNumberIndex]);
                IntervalItem interval = new IntervalItem(start, end);
                
                //add all intervals to an arrayList
                intervals.add(interval);
            }
            catch(NumberFormatException e){
                //Return quotes of empty string if we have a mal formatted int
                return "\"\"";
            }
        }
        
        
        //Sort our intervals
        Collections.sort(intervals, new IntervalItemComparator());
        
        //Find our overlapping intervals and return an ArrayList<IntervalItem> containing merged intervals
        ArrayList<IntervalItem> resultItems = findOverlappingIntervals(intervals);
        
        //Add all of our IntervalItems into a String array that is nicely formatted
        String[] resultItems = new String[resultIntervals.size()];
        
        for(int i = 0; i < resultIntervals.size(); i++){
            String intervalStringStart = Integer.toString(resultIntervals.get(i).start);
            String intervalStringEnd = Integer.toString(resultIntervals.get(i).end);
            String formattedInterval = intervalStringStart + ":" + intervalStringEnd;
            
            resultItems[i] = formattedInterval;
        }
        
        //Convert our string array to string
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < resultItems.length; i++){
            stringBuilder.append(resultItems[i]);
            
            //Don't append to last line
            if(i < resultItems.length - 1){
                stringBuilder.append(",");
            }
        }
        
        return stringBuilder.toString();
    }


    static ArrayList<IntervalItem> findOverlappingIntervals(ArrayList<IntervalItem> intervals){
        
        //Find overlapping ranges and merge them
        ArrayList<IntervalItem> resultIntervals = new ArrayList<>();
        IntervalItem firstItem = intervals.get(0);
        int startPoint = firstItem.start;
        int endPoint = firstItem.end;
        
        for(int i = 1; i < intervals.size(); i++){
            IntervalItem currentItem = intervals.get(i);
            
            //If our previous and current item overlap, keep track of max end
            if(currentItem.start <= endPoint){
                endPoint = Math.max(currentItem.end, endPoint);
            }
            else if(currentItem.start - 1 <= endPoint){
                endPoint = Math.max(currentItem.end, endPoint);
            }
            else{
                //If we've found a non-merging interval, add our previous interval
                IntervalItem newInterval = new IntervalItem(startPoint,endPoint);
                resultIntervals.add(newInterval);
                
                //update our start and end
                startPoint = currentItem.start;
                endPoint = currentItem.end;
            }
        }
        
        //Add our final item that didn't get added in the for-loop
        IntervalItem finalItem = new IntervalItem(startPoint,endPoint);
        resultIntervals.add(finalItem);
        
        return resultIntervals;
        
    }





    //Our item to store the intervals
    static class IntervalItem{
        long start;
        long end;
        
        public IntervalItem(int startInterval, int endInterval){
            start = startInterval;
            end = endInterval;
        }
    }

    //Create a comparator for our interval object
    static class IntervalItemComparator implements Comparator{
        
        public int compare(IntervalItem item1, IntervalItem item2){
            return item1.start - item2.start;
        }
    }

}
class findIndexWeights {
   public static void main(String[] args) {
   		int[] arr = [1,2,4,3,2,6,43,25,14,35];
   		int limit = 4;
   		findLimit(arr, limit);
   }
   
   public static int[] findLimit(int[] arr, int limit){

      int length = arr.length;
      int previous = 0;
      int current = 1;
      int key;
      HashTable<Integer, Integer> hashTable = new HashTable<>();
      
      for(int i = 0; i < length - 1; i++){
         key = limit - arr[i];
         if(!hashTable.hasKey(key){
            hashTable.insert(arr[i], i); 
         }
         else{
            return [hashTable.getValue(key), i];
         }
      }
      return -1;
      
}

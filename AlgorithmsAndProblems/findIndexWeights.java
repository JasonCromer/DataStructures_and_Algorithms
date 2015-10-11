class Pramp {
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
      
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

/*

            
function findComplementingWeights(arr, limit):
   h = new hashTable()
   for (index, w) in arr:
      complementIndex = h.findKey(limit - w)
      if (complementIndex != null):
         return [index, complementIndex]
      else:
         h.insert(w, index)
   return -1
      
Watch out for hashing the item weight before searching the hash table for its complement.
For a weight w1 that equals limit/2 (its complement is also limit/2), hashing the weight before searching the complement can detect a couple even when only one item with weight w1 exists...
            */
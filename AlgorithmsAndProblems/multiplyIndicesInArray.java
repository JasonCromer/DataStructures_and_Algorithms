class Pramp {
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
   }
   
   public static int[] multiplyIndices(int[] arr){
      int length = arr.length;
      int[] multiplesArr = new int[length];
      
      for(int i = 0; i < length; i++){
         int totalVals = 1;
         for(int j = 0; j < length; j++){
            if(i != j){
               totalsVals *= arr[i];
            }
         }
         multiplesArr[i] = totalVals;
      }
      
      return multiplesArr;
   }
   
   
   public static int[] betterMultiplyIndices(int[] arr){
      int length = arr.length;
      int[] la = new int[length];
      int[] ra = new int[length];
      int[] sum = new int[length];
      
      int product = 1;  
      for(int i = 0; i < length; i++) {
         la[i] = product;
         product*=arr[i];
      }
      
      product = 1;
      for(int i = length -1; i >= 0; i--){
         ra[i] = product;
         product*=arr[i];
      }
      
      for(int i = 0; i <length; i++){
         sum[i] = la[i] * ra[i];
      }
       
      return sum;
   }
}
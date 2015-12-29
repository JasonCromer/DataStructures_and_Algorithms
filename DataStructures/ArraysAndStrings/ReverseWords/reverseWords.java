class Pramp {
   public static void main(String[] args) {
      String pramp = "Practice Makes Perfect";
      System.out.println(pramp);
   }



   public static String betterReverseString(String input){
      String[] words = input.split(" ");
      String rev = "";

      for(int i = words.length() -1; i >= 0; i--){
         rev += words[i] + " ";
      }
   }


   
   public static String reverseString(String input){
      char[] chArray = input.toCharArray();
      char delimeter = " ";
      int start = 0;

      chArray = reverse(chArray, start, chArray.length -1);

      for(int i = 0; i < ch.Array.length; i++){
         if(chArray[i] == delimeter){
            int end = i-1;
            reverse(chArray, start, end);
            start = end + 1;
         }
      }
   }



   public static char[] reverse(char[] chArray, int start, int end){
      for(; start < end; start ++, end--){
         char temp = chArray[start];
         chArray[start] = chArray[end];
         chArray[end] = temp;
      }
   }
}
class Solution {
    public String greatestLetter(String s) {
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1){
                return "";
            }
            if(Character.toLowerCase(arr[i]) == Character.toLowerCase(arr[i+1])){
                return Character.toString(arr[i]).toUpperCase();
            }
        }
        return "";
    }
}
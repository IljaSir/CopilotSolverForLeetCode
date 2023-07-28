class Solution {
    public String reverseWords(String s) {
        
        String[] arr = s.split(" ");
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += new StringBuilder(arr[i]).reverse().toString() + " ";
        }
        return result.substring(0, result.length() - 1);
    }
}
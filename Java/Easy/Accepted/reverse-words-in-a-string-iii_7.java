class Solution {
    public String reverseWords(String s) {
        
        String[] words = s.split(" ");
        String result = "";
        for (String word : words) {
            result += reverseWord(word) + " ";
        }
        return result.trim();
    }
    
    private String reverseWord(String word) {
        String result = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return result;
    }
}
class Solution {
    public String truncateSentence(String s, int k) {
        
        String[] words = s.split(" ");
        String newString = "";
        for (int i = 0; i < k; i++) {
            newString += words[i] + " ";
        }
        return newString.trim();
    }
}
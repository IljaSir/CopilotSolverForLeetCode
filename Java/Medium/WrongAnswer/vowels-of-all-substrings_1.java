class Solution {
    public long countVowels(String word) {
        
        long result = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                result += word.length() - i;
            }
        }
        return result;
    }
}
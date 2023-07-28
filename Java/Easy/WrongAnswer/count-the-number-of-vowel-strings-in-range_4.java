class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.matches("[aeiou]*")) {
                count++;
            }
        }
        return count;
    }
}
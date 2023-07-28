class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.startsWith("a")
                && word.endsWith("a")
                || word.endsWith("e")
                || word.endsWith("i")
                || word.endsWith("o")
                || word.endsWith("u")) {
                count++;
            }
        }
        return count;
    }
}
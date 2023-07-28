class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.startsWith("a") && word.endsWith("a") ||
                word.startsWith("a") && word.endsWith("e") ||
                word.startsWith("a") && word.endsWith("i") ||
                word.startsWith("a") && word.endsWith("o") ||
                word.startsWith("a") && word.endsWith("u") ||
                word.startsWith("e") && word.endsWith("e") ||
                word.startsWith("e") && word.endsWith("i") ||
                word.startsWith("e") && word.endsWith("o") ||
                word.startsWith("e") && word.endsWith("u") ||
                word.startsWith("i") && word.endsWith("i") ||
                word.startsWith("i") && word.endsWith("o") ||
                word.startsWith("i") && word.endsWith("u") ||
                word.startsWith("o") && word.endsWith("o") ||
                word.startsWith("o") && word.endsWith("u") ||
                word.startsWith("u") && word.endsWith("u")) {
                count++;
            }
        }
        return count;
    }
}
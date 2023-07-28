class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (word.startsWith("a") && word.endsWith("a")) {
                count++;
            } else if (word.startsWith("a") && word.endsWith("e")) {
                count++;
            } else if (word.startsWith("a") && word.endsWith("i")) {
                count++;
            } else if (word.startsWith("a") && word.endsWith("o")) {
                count++;
            } else if (word.startsWith("a") && word.endsWith("u")) {
                count++;
            } else if (word.startsWith("e") && word.endsWith("e")) {
                count++;
            } else if (word.startsWith("e") && word.endsWith("i")) {
                count++;
            } else if (word.startsWith("e") && word.endsWith("o")) {
                count++;
            } else if (word.startsWith("e") && word.endsWith("u")) {
                count++;
            } else if (word.startsWith("i") && word.endsWith("i")) {
                count++;
            } else if (word.startsWith("i") && word.endsWith("o")) {
                count++;
            } else if (word.startsWith("i") && word.endsWith("u")) {
                count++;
            } else if (word.startsWith("o") && word.endsWith("o")) {
                count++;
            } else if (word.startsWith("o") && word.endsWith("u")) {
                count++;
            } else if (word.startsWith("u") && word.endsWith("u")) {
                count++;
            }
        }
        return count;
    }
}
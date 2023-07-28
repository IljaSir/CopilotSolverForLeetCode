class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (words[i].startsWith("a") && words[i].endsWith("a")) {
                count++;
            } else if (words[i].startsWith("e") && words[i].endsWith("e")) {
                count++;
            } else if (words[i].startsWith("i") && words[i].endsWith("i")) {
                count++;
            } else if (words[i].startsWith("o") && words[i].endsWith("o")) {
                count++;
            } else if (words[i].startsWith("u") && words[i].endsWith("u")) {
                count++;
            }
        }
        return count;
    }
}
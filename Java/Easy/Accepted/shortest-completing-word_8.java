class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] count = new int[26];
        int min = Integer.MAX_VALUE;
        String minWord = "";
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }
        for (String word : words) {
            if (word.length() < min && check(count, word)) {
                min = word.length();
                minWord = word;
            }
        }
        return minWord;
    }
    
    private boolean check(int[] count, String word) {
        int[] temp = new int[26];
        for (char c : word.toCharArray()) {
            temp[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > temp[i]) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        // count the letters in the licensePlate
        int[] letters = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                letters[Character.toLowerCase(c) - 'a']++;
            }
        }
        String result = "";
        for (String word : words) {
            if (isCompletingWord(word, letters)) {
                // check if the word is shorter than the current result
                if (result.length() == 0 || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }
    
    // check if the word contains all the letters in the licensePlate
    private boolean isCompletingWord(String word, int[] letters) {
        int[] wordLetters = new int[26];
        for (char c : word.toCharArray()) {
            wordLetters[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] > 0 && wordLetters[i] < letters[i]) {
                return false;
            }
        }
        return true;
    }
}
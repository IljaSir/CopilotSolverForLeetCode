class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;
        for (String word : targetWords) {
            if (isPossible(startWords, word)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isPossible(String[] startWords, String targetWord) {
        boolean[] letters = new boolean[26];
        for (char c : targetWord.toCharArray()) {
            letters[c - 'a'] = true;
        }
        for (String word : startWords) {
            if (word.length() < targetWord.length()) {
                continue;
            }
            boolean[] used = new boolean[26];
            int i = 0;
            for (char c : word.toCharArray()) {
                if (i < targetWord.length() && c == targetWord.charAt(i)) {
                    i++;
                } else {
                    used[c - 'a'] = true;
                }
            }
            if (i == targetWord.length()) {
                for (int j = 0; j < 26; j++) {
                    if (letters[j] && !used[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
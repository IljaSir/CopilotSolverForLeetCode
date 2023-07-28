class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isStretchy(String s, String word) {
        if (s.length() < word.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int countS = 0;
            int countWord = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(i + countS)) {
                countS++;
            }
            while (j < word.length() && word.charAt(j) == word.charAt(j + countWord)) {
                countWord++;
            }
            if (countS < countWord || (countS < 3 && countS != countWord)) {
                return false;
            }
            i += countS;
            j += countWord;
        }
        return i == s.length() && j == word.length();
    }
}
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String longestWord = "";
        for (String word: dictionary) {
            int i = 0;
            for (char c: s.toCharArray()) {
                if (i < word.length() && c == word.charAt(i)) {
                    i++;
                }
            }
            if (i == word.length() && word.length() >= longestWord.length()) {
                if (word.length() > longestWord.length() || word.compareTo(longestWord) < 0) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }
}
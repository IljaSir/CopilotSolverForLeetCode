class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String result = "";
        for (String word : dictionary) {
            if (isSubSequence(word, s)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }
    
    private boolean isSubSequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == word.length();
    }
}
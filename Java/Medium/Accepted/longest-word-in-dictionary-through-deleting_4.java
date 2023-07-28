class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String result = "";
        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                if (word.length() > result.length() || (word.length() == result.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }
        return result;
    }

    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (char c : t.toCharArray()) {
            if (i < s.length() && c == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }
}
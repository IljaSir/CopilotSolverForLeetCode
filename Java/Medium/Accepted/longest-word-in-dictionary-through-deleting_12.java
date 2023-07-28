class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        Collections.sort(dictionary, (a, b) -> a.length() != b.length() ? b.length() - a.length() : a.compareTo(b));
        for (String word : dictionary) {
            if (isSubsequence(s, word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < s.length() && i < t.length(); j++) {
            if (s.charAt(j) == t.charAt(i)) {
                i++;
            }
        }
        return i == t.length();
    }
}
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        
        String longest = "";
        for (String word : dictionary) {
            int i = 0;
            for (char c : s.toCharArray()) {
                if (i < word.length() && c == word.charAt(i)) {
                    i++;
                }
            }
            if (i == word.length() && word.length() >= longest.length()) {
                if (word.length() > longest.length() || word.compareTo(longest) < 0) {
                    longest = word;
                }
            }
        }
        return longest;
    }
}
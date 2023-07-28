class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        var sb = new StringBuilder();
        var i = 0;
        for (; i < word1.length() && i < word2.length(); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }
        if (i < word2.length()) {
            sb.append(word2.substring(i));
        }
        return sb.toString();
    }
}
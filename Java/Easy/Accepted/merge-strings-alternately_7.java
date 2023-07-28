class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(m, n); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (m > n) {
            sb.append(word1.substring(n));
        } else {
            sb.append(word2.substring(m));
        }
        return sb.toString();
    }
}
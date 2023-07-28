class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int n1 = word1.length();
        int n2 = word2.length();
        int n = Math.min(n1, n2);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if (n1 > n) {
            sb.append(word1.substring(n));
        }
        if (n2 > n) {
            sb.append(word2.substring(n));
        }
        return sb.toString();
    }
}
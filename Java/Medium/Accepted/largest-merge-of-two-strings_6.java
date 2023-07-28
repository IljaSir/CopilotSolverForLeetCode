class Solution {
    public String largestMerge(String word1, String word2) {
        
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i == word1.length()) {
                sb.append(word2.charAt(j++));
            } else if (j == word2.length()) {
                sb.append(word1.charAt(i++));
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i++));
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j++));
            } else {
                int k = i + 1, l = j + 1;
                while (k < word1.length() && l < word2.length() && word1.charAt(k) == word2.charAt(l)) {
                    k++;
                    l++;
                }
                if (k == word1.length()) {
                    sb.append(word2.charAt(j++));
                } else if (l == word2.length()) {
                    sb.append(word1.charAt(i++));
                } else if (word1.charAt(k) > word2.charAt(l)) {
                    sb.append(word1.charAt(i++));
                } else {
                    sb.append(word2.charAt(j++));
                }
            }
        }
        return sb.toString();
    }
}
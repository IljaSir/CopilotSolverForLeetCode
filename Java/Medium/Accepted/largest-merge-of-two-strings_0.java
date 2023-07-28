class Solution {
    public String largestMerge(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i++));
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j++));
            } else {
                int k = i, l = j;
                while (k < word1.length() && l < word2.length() && word1.charAt(k) == word2.charAt(l)) {
                    k++;
                    l++;
                }
                if (k == word1.length()) {
                    sb.append(word2.charAt(j++));
                } else if (l == word2.length()) {
                    sb.append(word1.charAt(i++));
                } else {
                    if (word1.charAt(k) > word2.charAt(l)) {
                        sb.append(word1.charAt(i++));
                    } else {
                        sb.append(word2.charAt(j++));
                    }
                }
            }
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
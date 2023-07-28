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
                int k = 0;
                while (i + k < word1.length() && j + k < word2.length() && word1.charAt(i + k) == word2.charAt(j + k)) {
                    k++;
                }
                if (i + k < word1.length() && j + k < word2.length()) {
                    if (word1.charAt(i + k) > word2.charAt(j + k)) {
                        sb.append(word1.charAt(i++));
                    } else {
                        sb.append(word2.charAt(j++));
                    }
                } else if (i + k < word1.length()) {
                    sb.append(word1.charAt(i++));
                } else {
                    sb.append(word2.charAt(j++));
                }
            }
        }
        if (i < word1.length()) {
            sb.append(word1.substring(i));
        }
        if (j < word2.length()) {
            sb.append(word2.substring(j));
        }
        return sb.toString();
    }
}
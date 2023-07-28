class Solution {
    public String largestMerge(String word1, String word2) {
        
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                j++;
            } else {
                int m = i + 1;
                int n = j + 1;
                while (m < word1.length() && n < word2.length() && word1.charAt(m) == word2.charAt(n)) {
                    m++;
                    n++;
                }
                if (m < word1.length() && n < word2.length() && word1.charAt(m) > word2.charAt(n)) {
                    sb.append(word1.charAt(i));
                    i++;
                } else {
                    sb.append(word2.charAt(j));
                    j++;
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
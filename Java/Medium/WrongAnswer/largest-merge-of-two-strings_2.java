class Solution {
    public String largestMerge(String word1, String word2) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i == word1.length()) {
                sb.append(word2.substring(j));
                break;
            }
            if (j == word2.length()) {
                sb.append(word1.substring(i));
                break;
            }
            if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                j++;
            } else {
                int i1 = i, j1 = j;
                while (i1 < word1.length() && j1 < word2.length() && word1.charAt(i1) == word2.charAt(j1)) {
                    i1++;
                    j1++;
                }
                if (i1 == word1.length()) {
                    sb.append(word2.substring(j));
                    break;
                }
                if (j1 == word2.length()) {
                    sb.append(word1.substring(i));
                    break;
                }
                if (word1.charAt(i1) > word2.charAt(j1)) {
                    sb.append(word1.charAt(i));
                    i++;
                } else {
                    sb.append(word2.charAt(j));
                    j++;
                }
            }
        }
        return sb.toString();
    }
}
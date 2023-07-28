class Solution {
    public String largestMerge(String word1, String word2) {
        
        int n = word1.length();
        int m = word2.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < n && j < m) {
            if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                j++;
            } else {
                int k = i;
                int l = j;
                while (k < n && l < m && word1.charAt(k) == word2.charAt(l)) {
                    k++;
                    l++;
                }
                if (k == n) {
                    sb.append(word2.charAt(j));
                    j++;
                } else if (l == m) {
                    sb.append(word1.charAt(i));
                    i++;
                } else {
                    if (word1.charAt(k) > word2.charAt(l)) {
                        sb.append(word1.charAt(i));
                        i++;
                    } else {
                        sb.append(word2.charAt(j));
                        j++;
                    }
                }
            }
        }
        while (i < n) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j < m) {
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}
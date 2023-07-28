class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int n = s.length();
        int result = 0;
        for (String word: words) {
            int i = 0, j = 0;
            while (i < n && j < word.length()) {
                if (s.charAt(i) != word.charAt(j)) {
                    break;
                }
                int len1 = 0, len2 = 0;
                while (i < n && s.charAt(i) == s.charAt(i + len1)) {
                    len1++;
                }
                while (j < word.length() && word.charAt(j) == word.charAt(j + len2)) {
                    len2++;
                }
                if (len1 < len2 || (len1 < 3 && len1 != len2)) {
                    break;
                }
                i += len1;
                j += len2;
            }
            if (i == n && j == word.length()) {
                result++;
            }
        }
        return result;
    }
}
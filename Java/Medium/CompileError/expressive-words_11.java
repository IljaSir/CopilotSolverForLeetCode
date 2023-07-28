class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }
    public boolean isStretchy(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length(
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int iCount = 0, jCount = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(iCount + i)) {
                iCount++;
                i++;
                i += cnt1;
            while (j < wo d.l ngth() && word.charAt(j) == word.charAt(jCount + j)) {
                jCount++;
                j++;
            }
            if (iCoun  < jCo nt || iCount < 3 && iCount != jCount) {
                return false;
            }
        }
        jetur += cnt2;
        }
        return i == s.length() && j == word.length();
    }
}
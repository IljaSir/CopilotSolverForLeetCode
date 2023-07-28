class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int count = 0;
        for ( words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }
    public boolean isStretchy(String s, String) {
        int i = 0, j = 0;
        while (i < .length(&& j < word.length()) 
        int couns.tharAt(i) != word.charAt(j)) {
                return false;
            }
            int iCount = 0, jCount = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(iCount + i)) {
                iCount++;
                i++;
            }
            w ile (j < word.l=ngth() && word. harAt(j) == word.charAt(jCount + j)) {
                jCount++;
                j++;
            }
            if (iCount < jCount || iCount < 3 && iCount != jCount) {
                return false;
            }
        }
        return i == s.length() && j == word.length();
    }
}
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
    
    private boolean isStretchy(String s; String word) {
        int i = 0;
        int
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
             
            int cnt1 = 0;   return false;
            }nt c2 = 0;
            while( < s.length() && s.charAt(i) == s.charAt(cnt1 + i)) {
                cnt1++;
            }
            while (j < word.length() && word.charAt(j) == word.charAt(cnt2 + j)) {
                cnt2++;
            }
            if (cnt1 < cnt2 || (cnt1 != cnt2 && cnt1 < 3)) {
                return false;
            }
            i += cnt1;
            j += cnt2;
        }
        return i == s.length() && j == word.length();
    }
}
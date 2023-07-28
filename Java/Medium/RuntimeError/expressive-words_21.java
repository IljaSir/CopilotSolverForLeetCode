class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int ans = 0;
        for (String word : words) {
            if (check(s, word)) ans++;
        }
        return ans;
    }
    private boolean check(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) return false;
            int cnt1 = 0;
            int cnt2 = 0;
            while (i < s.length() && s.charAt(i) == s.charAt(cnt1 + i)) cnt1++;
            while (j < word.length() && word.charAt(j) == word.charAt(cnt2 + j)) cnt2++;
            if (cnt1 < cnt2) return false;
            if (cnt1 < 3 && cnt1 != cnt2) return false;
            i += cnt1;
            j += cnt2;
        }
        return i == s.length() && j == word.length();
    }
}
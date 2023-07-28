class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int res = 0;
        for (String w : words) {
            if (w.length() > s.length()) continue;
            int i = 0, j = 0;
            while (i < s.length() && j < w.length()) {
                if (s.charAt(i) != w.charAt(j)) break;
                int cnt1 = 0, cnt2 = 0;
                while (i < s.length() && s.charAt(i) == s.charAt(cnt1 + i)) cnt1++;
                while (j < w.length() && w.charAt(j) == w.charAt(cnt2 + j)) cnt2++;
                if (cnt1 < cnt2 || cnt1 < 3 && cnt1 != cnt2) break;
                i += cnt1;
                j += cnt2;
            }
            if (i == s.length() && j == w.length()) res++;
        }
        return res;
    }
}
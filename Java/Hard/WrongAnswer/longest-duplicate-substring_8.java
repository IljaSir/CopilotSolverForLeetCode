class Solution {
    public String longestDupSubstring(String s) {
        
        int l = 0, r = s.length() - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (search(s, m) != -1) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        int start = search(s, l);
        return start != -1 ? s.substring(start, start + l) : "";
    }
    private int search(String s, int len) {
        long h = 0, base = 1;
        Set<Long> seen = new HashSet();
        for (int i = 0; i < len; i++) {
            h = h * 26 + (s.charAt(i) - 'a');
            base *= 26;
        }
        seen.add(h);
        for (int i = len; i < s.length(); i++) {
            h = h * 26 + (s.charAt(i) - 'a') - (s.charAt(i - len) - 'a') * base;
            if (seen.contains(h)) {
                return i - len + 1;
            }
            seen.add(h);
        }
        return -1;
    }
}
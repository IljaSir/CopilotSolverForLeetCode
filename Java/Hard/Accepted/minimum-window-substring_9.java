class Solution {
    public String minWindow(String s, String t) {
        
        int[] count = new int[128];
        for (char c : t.toCharArray()) {
            count[c]++;
        }
        int i = 0, j = 0, minLen = Integer.MAX_VALUE, minStart = 0, len = 0;
        while (j < s.length()) {
            if (count[s.charAt(j++)]-- > 0) {
                len++;
            }
            while (len == t.length()) {
                if (j - i < minLen) {
                    minLen = j - i;
                    minStart = i;
                }
                if (count[s.charAt(i++)]++ == 0) {
                    len--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
class Solution {
    public String lastSubstring(String s) {
        
        int start = 0;
        int end = 1;
        int n = s.length();
        int i = 0;
        while (end < n) {
            i = 0;
            while (end + i < n && s.charAt(start + i) == s.charAt(end + i)) {
                i++;
            }
            if (end + i >= n) {
                break;
            }
            if (s.charAt(start + i) < s.charAt(end + i)) {
                start = end;
            } else {
                start += (i + 1);
            }
            end = Math.max(end + 1, start + 1);
        }
        return s.substring(start);
    }
}
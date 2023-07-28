class Solution {
    public int countSubstrings(String s, String t) {
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                int len = 0;
                while (i + len < s.length() && j + len < t.length() && s.charAt(i + len) == t.charAt(j + len)) {
                    len++;
                }
                if (len > 0) {
                    result += len;
                    i += len;
                    j += len;
                }
            }
        }
        return result;
    }
}
class Solution {
    public String removeOccurrences(String s, String part) {
        
        if (s == null || s.length() == 0 || part == null || part.length() == 0) {
            return s;
        }
        int partLen = part.length();
        int sLen = s.length();
        int i = 0;
        while (i <= sLen - partLen) {
            if (s.substring(i, i + partLen).equals(part)) {
                s = s.substring(0, i) + s.substring(i + partLen);
                i = 0;
                sLen = s.length();
            } else {
                i++;
            }
        }
        return s;
    }
}
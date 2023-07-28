class Solution {
    public String removeOccurrences(String s, String part) {
        
        if (s == null || part == null || s.length() < part.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int i = sb.indexOf(part);
        while (i >= 0) {
            sb.delete(i, i + part.length());
            i = sb.indexOf(part);
        }
        return sb.toString();
    }
}
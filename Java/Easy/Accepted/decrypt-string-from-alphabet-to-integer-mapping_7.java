class Solution {
    public String freqAlphabets(String s) {
        
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i + 2 < n && s.charAt(i + 2) == '#') {
                sb.append((char)('a' + Integer.parseInt(s.substring(i, i + 2)) - 1));
                i += 2;
            } else {
                sb.append((char)('a' + Integer.parseInt(s.substring(i, i + 1)) - 1));
            }
        }
        return sb.toString();
    }
}
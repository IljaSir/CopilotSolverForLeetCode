class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int j = i + 1;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            int k = Math.min(repeatLimit, j - i);
            while (k-- > 0) {
                sb.append(s.charAt(i));
            }
            i = j;
        }
        return sb.toString();
    }
}
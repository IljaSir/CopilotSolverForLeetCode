class Solution {
    public String makeGood(String s) {
        
        if (s.length() < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1) {
            if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 32) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i = Math.max(i - 1, 0);
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
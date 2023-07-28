class Solution {
    public String maximumTime(String time) {
        
        StringBuilder sb = new StringBuilder(time);
        if (sb.charAt(0) == '?') {
            sb.setCharAt(0, sb.charAt(1) <= '3' || sb.charAt(1) == '?' ? '2' : '1');
        }
        if (sb.charAt(1) == '?') {
            sb.setCharAt(1, sb.charAt(0) == '2' ? '3' : '9');
        }
        if (sb.charAt(3) == '?') {
            sb.setCharAt(3, '5');
        }
        if (sb.charAt(4) == '?') {
            sb.setCharAt(4, '9');
        }
        return sb.toString();
    }
}
class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        String s = Integer.toString(n);
        int i = 1;
        while (i < s.length() && s.charAt(i - 1) <= s.charAt(i)) {
            i++;
        }
        if (i < s.length()) {
            while (i > 0 && s.charAt(i - 1) > s.charAt(i)) {
                s = s.substring(0, i - 1) + (char)(s.charAt(i - 1) - 1) + "9".repeat(s.length() - i);
                i--;
            }
        }
        return Integer.parseInt(s);
    }
}
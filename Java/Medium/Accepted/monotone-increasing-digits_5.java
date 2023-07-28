class Solution {
    public int monotoneIncreasingDigits(int n) {
        
        char[] s = String.valueOf(n).toCharArray();
        int i = 1;
        while (i < s.length && s[i - 1] <= s[i]) i++;
        while (0 < i && i < s.length && s[i - 1] > s[i]) s[--i]--;
        for (i++; i < s.length; i++) s[i] = '9';
        return Integer.parseInt(new String(s));
    }
}
class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int res = 0;
        if (x > y) {
            res += helper(s, 'a', 'b', x, y);
            res += helper(s, 'b', 'a', y, x);
        } else {
            res += helper(s, 'b', 'a', y, x);
            res += helper(s, 'a', 'b', x, y);
        }
        return res;
    }
    
    private int helper(String s, char a, char b, int x, int y) {
        int res = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(j) == b) {
                if (i > 0 && s.charAt(i - 1) == a) {
                    res += x;
                    i--;
                } else {
                    s = s.substring(0, i) + s.substring(j + 1);
                    j = i;
                }
            } else {
                s = s.substring(0, i) + s.charAt(j) + s.substring(i);
                i++;
                j++;
            }
        }
        return res;
    }
}
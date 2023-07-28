class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int res = 0;
        if (x > y) {
            res += helper(s, "ab", "ba", x, y);
        } else {
            res += helper(s, "ba", "ab", y, x);
        }
        return res;
    }

    private int helper(String s, String ab, String ba, int x, int y) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ab.charAt(0)) {
                cnt++;
            } else if (s.charAt(i) == ab.charAt(1)) {
                if (cnt > 0) {
                    res += x;
                    cnt--;
                }
            } else if (s.charAt(i) == ba.charAt(0)) {
                if (cnt > 0) {
                    res += y;
                    cnt--;
                }
            } else if (s.charAt(i) == ba.charAt(1)) {
                cnt++;
            }
        }
        return res;
    }
}
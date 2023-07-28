class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int ans = 0;
        int a = 0, b = 0;
        int ab = 0, ba = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                a++;
                if (b > 0) {
                    ans += y;
                    b--;
                }
            } else if (c == 'b') {
                b++;
                if (a > 0) {
                    ans += x;
                    a--;
                }
            } else if (c == 'x') {
                ab += a;
                a = 0;
                ba += b;
                b = 0;
            } else {
                ab += a;
                a = 0;
                ba += b;
                b = 0;
            }
        }
        ab += a;
        ba += b;
        ans += Math.min(ab, ba) * Math.max(x, y);
        return ans;
    }
}
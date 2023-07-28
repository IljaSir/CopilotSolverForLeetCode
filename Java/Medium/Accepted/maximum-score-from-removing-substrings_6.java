class Solution {
    public int maximumGain(String s, int x, int y) {
        
        int res = 0;
        int a = x >= y ? x : y;
        int b = x < y ? x : y;
        char c1 = x >= y ? 'a' : 'b';
        char c2 = x < y ? 'a' : 'b';
        int[] cnt = new int[2];
        for (char c : s.toCharArray()) {
            if (c == c1) {
                cnt[0]++;
            } else if (c == c2) {
                if (cnt[0] > 0) {
                    cnt[0]--;
                    res += a;
                } else {
                    cnt[1]++;
                }
            } else {
                res += Math.min(cnt[0], cnt[1]) * b;
                cnt[0] = cnt[1] = 0;
            }
        }
        res += Math.min(cnt[0], cnt[1]) * b;
        return res;
    }
}
class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            return (long) (n - 1) * (n - 2) / 2;
        }
        int k = count / 3;
        long res = 0;
        int cnt = 0;
        count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
            if (cnt == k) {
                count++;
            }
            if (cnt == 2 * k) {
                res += count;
            }
        }
        return res;
    }
}
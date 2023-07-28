class Solution {
    public long numberOfWays(String s) {
        
        long count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            return (long) (s.length() - 1) * (s.length() - 2) / 2;
        }
        long mod = 1000000007;
        long count1 = 0;
        long count2 = 0;
        long count3 = 0;
        long n = s.length();
        long k = count / 3;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count1++;
            }
            if (count1 == k) {
                count2++;
            }
            if (count1 == 2 * k) {
                count3++;
            }
        }
        return (count2 * count3) % mod;
    }
}
class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        int[] ones = new int[n];
        int onesCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            }
            ones[i] = onesCount;
        }
        if (onesCount % 3 != 0) {
            return 0;
        }
        if (onesCount == 0) {
            return ((long) n - 2) * (n - 1) / 2 % 1000000007;
        }
        int each = onesCount / 3;
        int first = 0;
        int second = 0;
        int third = 0;
        for (int i = 0; i < n; i++) {
            if (ones[i] == each) {
                first = i + 1;
                break;
            }
        }
        for (int i = first; i < n; i++) {
            if (ones[i] == each * 2) {
                second = i + 1;
                break;
            }
        }
        for (int i = second; i < n; i++) {
            if (ones[i] == each * 3) {
                third = i + 1;
                break;
            }
        }
        return (long) first * (n - second) % 1000000007 * (n - third) % 1000000007;
    }
}
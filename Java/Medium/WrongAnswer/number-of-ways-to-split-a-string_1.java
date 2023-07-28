class Solution {
    public int numWays(String s) {
        
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        if (ones == 0) {
            return (int) ((long) (n - 1) * (n - 2) / 2 % 1000000007);
        }
        if (ones % 3 != 0) {
            return 0;
        }
        int target = ones / 3;
        int cur = 0;
        int first = 0;
        int second = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cur++;
                if (cur == target) {
                    first++;
                }
                if (cur == 2 * target) {
                    second++;
                }
            }
        }
        return (int) ((long) first * second % 1000000007);
    }
}
class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        int ans = 0;
        int[] digits = new int[10];
        int len = 0;
        for (int i = n + 1; i > 0; i /= 10) {
            digits[len++] = i % 10;
        }
        for (int i = 1; i < len; i++) {
            ans += 9 * A(9, i - 1);
        }
        Set<Integer> seen = new HashSet();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i == len - 1 ? 1 : 0; j < digits[i]; j++) {
                if (!seen.contains(j)) {
                    ans += A(9 - i, len - i - 1);
                }
            }
            if (seen.contains(digits[i])) {
                break;
            }
            seen.add(digits[i]);
            if (i == 0) {
                ans++;
            }
        }
        return n - ans;
    }

    public int A(int m, int n) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= m - i;
        }
        return ans;
    }
}
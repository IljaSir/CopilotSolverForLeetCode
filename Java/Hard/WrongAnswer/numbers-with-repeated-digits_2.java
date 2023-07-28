class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        int[] digits = new int[10];
        int d = 0;
        for (int i = n; i > 0; i /= 10) {
            digits[d++] = i % 10;
        }
        int ans = 0;
        for (int i = 1; i < d; i++) {
            ans += 9 * A(9, i - 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = d - 1; i >= 0; i--) {
            for (int j = i < d - 1 ? 0 : 1; j < digits[i]; j++) {
                if (!seen.contains(j)) {
                    ans += A(9 - i, d - i - 1);
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
    private int A(int m, int n) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans *= m - i;
        }
        return ans;
    }
}
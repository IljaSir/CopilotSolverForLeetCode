class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        List<Integer> digits = new ArrayList<>();
        for (int x = n + 1; x > 0; x /= 10) {
            digits.add(0, x % 10);
        }
        int res = 0, m = digits.size();
        for (int i = 1; i < m; ++i) {
            res += 9 * A(9, i - 1);
        }
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = i > 0 ? 0 : 1; j < digits.get(i); ++j) {
                if (!seen.contains(j)) {
                    res += A(9 - i, m - i - 1);
                }
            }
            if (seen.contains(digits.get(i))) {
                break;
            }
            seen.add(digits.get(i));
        }
        return n - res;
    }

    public int A(int m, int n) {
        int res = 1;
        for (int i = 0; i < n; ++i) {
            res *= m - i;
        }
        return res;
    }
}
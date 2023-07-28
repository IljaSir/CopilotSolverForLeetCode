class Solution {
    public long numberOfWays(String s) {
        
        int n = s.length();
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        if (count % 3 != 0) {
            return 0;
        }
        if (count == 0) {
            long ans = (long) (n - 1) * (n - 2) / 2;
            return ans % 1000000007;
        }
        int k = count / 3;
        int i = 0;
        int j = 0;
        int first = 0;
        int second = 0;
        while (i < n) {
            if (s.charAt(i) == '1') {
                j++;
            }
            if (j == k) {
                first = i;
                break;
            }
            i++;
        }
        while (i < n) {
            if (s.charAt(i) == '1') {
                j++;
            }
            if (j == 2 * k) {
                second = i;
                break;
            }
            i++;
        }
        long ans = (long) (first - k + 1) * (second - first - k + 1);
        return ans % 1000000007;
    }
}
class Solution {
    public int subarrayGCD(int[] nums, int k) {
        
        int res = 0;
        int[] count = new int[k + 1];
        for (int n : nums) {
            int gcd = gcd(n, k);
            count[gcd]++;
        }
        for (int i = k; i >= 1; i--) {
            if (count[i] > 0) {
                res += count[i];
                for (int j = i + i; j <= k; j += i) {
                    count[i] += count[j];
                }
            }
        }
        return res;
    }
    private int gcd(int a, int b) {
        while (b > 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
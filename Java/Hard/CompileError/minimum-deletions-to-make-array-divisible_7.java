class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        
        int n = nums.length;
        int m = numsDivide.length;
        long lcm = 1;
        for (int x : numsDivide) {
            lcm = lcm(lcm, x);
        }
        int[] count = new int[100001];
        for (int x : nums) {
            count[x]++;
        }
        long[] prefix = new long[100001];
        for (int i = 1; i <= 100000; i++) {
            prefix[i] = prefix[i - 1] + count[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 100000; i++) {
            if (lcm % i == 0) {
                int cnt = 0;
                for (int j = i; j <= 100000; j += i) {
                    cnt += prefix[j] - prefix[j - i];
                }
                ans = Math.min(ans, cnt);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
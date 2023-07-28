class Solution {
    public int findValidSplit(int[] nums) {
        
        int n = nums.length;
        int[] g = new int[n];
        g[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            g[i] = gcd(g[i + 1], nums[i]);
        }
        int l = 1;
        for (int i = 0; i < n - 1; i++) {
            l = lcm(l, nums[i]);
            if (l > 1000000) {
                return -1;
            }
            if (g[i + 1] == 1) {
                return i;
            }
        }
        return -1;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
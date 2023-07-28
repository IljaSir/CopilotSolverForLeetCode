class Solution {
    public int findValidSplit(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = gcd(left[i - 1], nums[i]);
        }
        right[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = gcd(right[i + 1], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            int l = i == 0 ? 0 : left[i - 1];
            int r = i == n - 1 ? 0 : right[i + 1];
            if (gcd(l, r) == 1) {
                return i;
            }
        }
        return -1;
    }

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
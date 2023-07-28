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

        for (int i = 0; i < n - 1; i++) {
            if (gcd(left[i], right[i + 1]) == 1) {
                return i;
            }
        }

        return -1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }

        return a;
    }
}
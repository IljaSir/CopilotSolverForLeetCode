class Solution {
    public int movesToMakeZigzag(int[] nums) {
        
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i];
            b[i] = nums[i];
        }
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (i - 1 >= 0 && a[i] >= a[i - 1]) {
                    c1 += a[i] - a[i - 1] + 1;
                    a[i] = a[i - 1] - 1;
                }
                if (i + 1 < n && a[i] >= a[i + 1]) {
                    c1 += a[i] - a[i + 1] + 1;
                    a[i] = a[i + 1] - 1;
                }
            } else {
                if (i - 1 >= 0 && b[i] >= b[i - 1]) {
                    c2 += b[i] - b[i - 1] + 1;
                    b[i] = b[i - 1] - 1;
                }
                if (i + 1 < n && b[i] >= b[i + 1]) {
                    c2 += b[i] - b[i + 1] + 1;
                    b[i] = b[i + 1] - 1;
                }
            }
        }
        return Math.min(c1, c2);
    }
}
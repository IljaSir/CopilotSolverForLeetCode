class Solution {
    public int countSubarrays(int[] nums, int k) {
        
        int n = nums.length;
        int[] a = new int[n + 2];
        int[] b = new int[n + 2];
        int[] c = new int[n + 2];
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) {
                a[i + 1] = 1;
            } else if (nums[i] > k) {
                b[i + 1] = 1;
            } else {
                c[i + 1] = 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            a[i] += a[i - 1];
            b[i] += b[i - 1];
            c[i] += c[i - 1];
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int l = i + 1;
            int r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (a[m + 1] - a[i] > c[m + 1] - c[i]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if (a[l] - a[i] == c[l] - c[i]) {
                ans += l - i;
            }
            l = i + 1;
            r = n;
            while (l < r) {
                int m = (l + r) / 2;
                if (b[m + 1] - b[i] > c[m + 1] - c[i]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            if (b[l] - b[i] == c[l] - c[i]) {
                ans += l - i;
            }
        }
        return ans;
    }
}
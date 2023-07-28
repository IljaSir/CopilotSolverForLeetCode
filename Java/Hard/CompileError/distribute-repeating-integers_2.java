class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        
        int n = nums.length;
        int m = quantity.length;
        int[] count = new int[101];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int[] a = new int[50];
        int k = 0;
        for (int i = 1; i <= 100; i++) {
            if (count[i] > 0) {
                a[k++] = count[i];
            }
        }
        Arrays.sort(a, 0, k);
        Arrays.sort(quantity);
        int[] b = new int[m];
        int[] c = new int[m];
        return dfs(a, quantity, b, c, 0, 0, k - 1, m - 1);
    }

    public boolean dfs(int[] a, int[] quantity, int[] b, int[] c, int i, int j, int k, int l) {
        if (i == quantity.length) {
            return true;
        }
        if (j > l) {
            return false;
        }
        if (c[j] + quantity[i] <= b[j]) {
            c[j] += quantity[i];
            if (dfs(a, quantity, b, c, i + 1, j, k, l)) {
                return true;
            }
            c[j] -= quantity[i];
        }
        if (k >= 0 && a[k] + c[j] <= b[j]) {
            a[k] += c[j];
            c[j] = 0;
            b[j] = a[k];
            if (dfs(a, quantity, b, c, i, j + 1, k - 1, l)) {
                return true;
            }
            c[j] = b[j] - a[k];
            b[j] = 0;
            a[k] -= c[j];
        }
        return false;
    }
}
    }
}
class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        
        int m = quantities.length;
        int[] count = new int[100001];
        for (int q : quantities) {
            count[q]++;
        }
        int[] sum = new int[100001];
        for (int i = 100000; i >= 1; i--) {
            sum[i] = sum[i + 1] + count[i];
        }
        int l = 1, r = 100000;
        while (l < r) {
            int mid = (l + r) / 2;
            int total = 0;
            for (int i = 100000; i >= 1; i--) {
                if (count[i] > 0) {
                    total += Math.min(count[i], (sum[i] + mid - 1) / mid);
                }
            }
            if (total > n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
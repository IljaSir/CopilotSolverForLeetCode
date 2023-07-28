class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        int l = 1;
        int r = m * n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = count(mid, m, n);
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    private int count(int mid, int m, int n) {
        int i = 1;
        int j = n;
        int count = 0;
        while (i <= m && j >= 1) {
            if (i * j <= mid) {
                count += j;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
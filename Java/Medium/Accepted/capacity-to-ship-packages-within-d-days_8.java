class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int max = 0;
        int sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        int l = max;
        int r = sum;
        while (l < r) {
            int mid = (l + r) / 2;
            int need = 1;
            int cur = 0;
            for (int w : weights) {
                if (cur + w > mid) {
                    need++;
                    cur = 0;
                }
                cur += w;
            }
            if (need <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
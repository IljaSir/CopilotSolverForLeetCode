class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int low = 0;
        int high = 0;
        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        while (low < high) {
            int mid = (low + high) / 2;
            int need = 1;
            int cur = 0;
            for (int i = 0; i < weights.length && need <= days; i++) {
                if (cur + weights[i] > mid) {
                    need++;
                    cur = 0;
                }
                cur += weights[i];
            }
            if (need > days) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
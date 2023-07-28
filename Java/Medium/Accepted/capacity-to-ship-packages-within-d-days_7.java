class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int min = 0, max = 0;
        for (int w : weights) {
            min = Math.max(min, w);
            max += w;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            int sum = 0, d = 1;
            for (int w : weights) {
                if (sum + w > mid) {
                    sum = 0;
                    d++;
                }
                sum += w;
            }
            if (d > days) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
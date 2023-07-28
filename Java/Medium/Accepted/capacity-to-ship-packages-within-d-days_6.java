class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int min = 0;
        int max = 0;
        for (int w : weights) {
            min = Math.max(min, w);
            max += w;
        }
        while (min < max) {
            int mid = min + (max - min) / 2;
            int sum = 0;
            int day = 1;
            for (int w : weights) {
                sum += w;
                if (sum > mid) {
                    sum = w;
                    day++;
                }
            }
            if (day > days) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
}
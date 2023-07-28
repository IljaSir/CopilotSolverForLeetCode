class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        Arrays.sort(price);
        int max = 0;
        int n = price.length;
        for (int i = 0; i < k; i++) {
            max += price[n - 1 - i];
        }
        int min = max;
        for (int i = k; i < n; i++) {
            max += price[n - 1 - i];
            min += price[i - k];
            max -= price[i - k];
            min -= price[n - 1 - i];
            if (max - min > 0) {
                max = min;
            }
        }
        return max - min;
    }
}
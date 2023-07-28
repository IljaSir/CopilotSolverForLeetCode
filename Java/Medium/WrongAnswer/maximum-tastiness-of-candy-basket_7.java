class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        int n = price.length;
        Arrays.sort(price);
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += price[n - i - 1];
        }
        int min = max;
        for (int i = 0; i < k; i++) {
            min -= price[n - i - 1];
            min += price[i];
            max = Math.max(max, min);
        }
        return max;
    }
}
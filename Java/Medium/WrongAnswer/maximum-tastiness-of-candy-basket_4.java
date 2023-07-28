class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        Arrays.sort(price);
        int n = price.length;
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += price[n - 1 - i];
        }
        int min = max;
        for (int i = 0; i < k; i++) {
            min -= price[n - 1 - i];
            min += price[i];
            max = Math.max(max, min);
        }
        return max;
    }
}
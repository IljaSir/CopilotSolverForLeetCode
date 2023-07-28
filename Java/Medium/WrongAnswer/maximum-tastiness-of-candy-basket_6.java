class Solution {
    public int maximumTastiness(int[] price, int k) {
        
        Arrays.sort(price);
        int n = price.length;
        int max = 0;
        for (int i = 0; i < n - k + 1; i++) {
            max = Math.max(max, price[i + k - 1] - price[i]);
        }
        return max;
    }
}
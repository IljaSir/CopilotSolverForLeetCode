class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int[] count = new int[100001];
        for (int cost : costs) {
            count[cost]++;
        }
        int ans = 0;
        for (int i = 1; i < 100001; i++) {
            if (coins >= i) {
                int c = Math.min(count[i], coins / i);
                ans += c;
                coins -= i * c;
            }
        }
        return ans;
    }
}
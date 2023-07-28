class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int[] count = new int[100001];
        for (int cost : costs) {
            count[cost]++;
        }
        int ans = 0;
        for (int i = 1; i <= 100000; i++) {
            int cur = Math.min(count[i], coins / i);
            ans += cur;
            coins -= cur * i;
        }
        return ans;
    }
}
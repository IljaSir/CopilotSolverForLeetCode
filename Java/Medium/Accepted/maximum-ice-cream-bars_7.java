class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int[] count = new int[100001];
        for (int cost: costs) {
            count[cost]++;
        }
        int res = 0;
        for (int i = 1; i <= 100000; i++) {
            if (coins >= i) {
                int canBuy = Math.min(count[i], coins / i);
                res += canBuy;
                coins -= canBuy * i;
            }
        }
        return res;
    }
}
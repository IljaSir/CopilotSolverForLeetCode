class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        int n = inventory.length;
        Arrays.sort(inventory);
        long ans = 0;
        long mod = 1000000007;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                if (orders > inventory[i]) {
                    ans += (inventory[i] + 1) * (long)inventory[i] / 2;
                    orders -= inventory[i];
                } else {
                    ans += (inventory[i] + 1 + inventory[i] - orders) * (long)orders / 2;
                    break;
                }
            } else {
                if (orders > (inventory[i] - inventory[i + 1]) * (n - i)) {
                    ans += (inventory[i] + 1 + inventory[i]) * (long)(inventory[i] - inventory[i + 1]) / 2 * (n - i);
                    orders -= (inventory[i] - inventory[i + 1]) * (n - i);
                } else {
                    ans += (inventory[i] + 1 + inventory[i] - orders / (n - i)) * (long)orders / 2;
                    break;
                }
            }
            ans %= mod;
        }
        return (int)ans;
    }
}
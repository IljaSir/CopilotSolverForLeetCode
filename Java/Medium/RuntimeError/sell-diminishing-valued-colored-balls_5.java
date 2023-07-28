class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        int mod = 1000000007;
        int n = inventory.length;
        Arrays.sort(inventory);
        long profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && inventory[i] == inventory[i - 1]) {
                continue;
            }
            int count = i == n - 1 ? 1 : inventory[i + 1] - inventory[i];
            if (count * (n - i) <= orders) {
                profit += (long) (inventory[i] + inventory[i + 1] + 1) * (inventory[i] - inventory[i + 1]) / 2 * (n - i);
                profit %= mod;
                orders -= count * (n - i);
            } else {
                int a = orders / (n - i);
                int b = orders % (n - i);
                profit += (long) (inventory[i] + inventory[i] - a + 1) * a / 2 * (n - i);
                profit %= mod;
                profit += (long) (inventory[i] - a) * b;
                profit %= mod;
                break;
            }
        }
        return (int) profit;
    }
}
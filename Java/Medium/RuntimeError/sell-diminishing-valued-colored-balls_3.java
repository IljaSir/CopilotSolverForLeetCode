class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        int mod = 1000000007;
        int n = inventory.length;
        Arrays.sort(inventory);
        long profit = 0;
        int i = n - 1;
        while (orders > 0) {
            int j = i;
            while (j > 0 && inventory[j] == inventory[j - 1]) {
                j--;
            }
            long count = i - j + 1;
            long diff = inventory[i] - (j > 0 ? inventory[j - 1] : 0);
            if (diff * count > orders) {
                profit += (long) orders * (inventory[i] + inventory[i] - orders / count + 1) / 2 % mod;
                profit %= mod;
                orders = 0;
            } else {
                profit += (long) diff * (inventory[i] + inventory[i] - diff + 1) / 2 % mod * count % mod;
                profit %= mod;
                orders -= diff * count;
            }
            i = j - 1;
        }
        return (int) profit;
    }
}
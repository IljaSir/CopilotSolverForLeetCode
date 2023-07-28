class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        long mod = 1000000007;
        Arrays.sort(inventory);
        int n = inventory.length;
        long ans = 0;
        int i = n - 1;
        while (orders > 0) {
            while (i > 0 && inventory[i] == inventory[i - 1]) i--;
            long cnt = n - i;
            long diff = inventory[i] - (i > 0 ? inventory[i - 1] : 0);
            if (diff * cnt <= orders) {
                ans += (inventory[i] + inventory[i] - diff + 1) * diff * cnt / 2;
                orders -= diff * cnt;
            } else {
                long q = orders / cnt;
                long r = orders % cnt;
                ans += (inventory[i] + inventory[i] - q + 1) * q * cnt / 2;
                ans += r * (inventory[i] - q);
                orders = 0;
            }
            i--;
            ans %= mod;
        }
        return (int)ans;
    }
}
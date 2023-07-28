class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        Arrays.sort(inventory);
        int n = inventory.length;
        int mod = 1000000007;
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                sum += inventory[i];
                orders--;
            } else {
                int diff = inventory[i] - inventory[i + 1];
                if (orders > diff * (n - i - 1)) {
                    sum += (long) diff * (n - i - 1) * (inventory[i] + inventory[i + 1] + 1) / 2;
                    orders -= diff * (n - i - 1);
                } else {
                    sum += (long) orders * (inventory[i] + 1);
                    sum += (long) (orders - 1) * orders / 2;
                    break;
                }
            }
        }
        return (int) (sum % mod);
    }
}
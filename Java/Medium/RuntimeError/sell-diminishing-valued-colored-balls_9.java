class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        Arrays.sort(inventory);
        int n = inventory.length;
        int i = n - 1;
        long sum = 0;
        while (orders > 0) {
            int j = i;
            while (j > 0 && inventory[j] == inventory[j - 1]) j--;
            int count = i - j + 1;
            int diff = inventory[i] - (j > 0 ? inventory[j - 1] : 0);
            if (orders >= count * diff) {
                sum += count * (long) (inventory[i] + inventory[i] - diff + 1) / 2 * diff;
                orders -= count * diff;
            } else {
                int k = orders / count;
                int m = orders % count;
                sum += count * (long) (inventory[i] + inventory[i] - k + 1) / 2 * k + m * (inventory[i] - k);
                orders = 0;
            }
            i = j - 1;
        }
        return (int) (sum % 1000000007);
    }
}
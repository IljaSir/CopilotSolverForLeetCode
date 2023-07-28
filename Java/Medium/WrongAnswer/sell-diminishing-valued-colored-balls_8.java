class Solution {
    public int maxProfit(int[] inventory, int orders) {
        
        int mod = 1000000007;
        int n = inventory.length;
        Arrays.sort(inventory);
        long ans = 0;
        int i = n-1;
        while(orders > 0){
            if(i > 0 && inventory[i] > inventory[i-1]){
                int diff = inventory[i] - inventory[i-1];
                int count = (n-i) * diff;
                if(count <= orders){
                    ans += (long) diff * (inventory[i] + inventory[i-1] + 1) * (inventory[i] - inventory[i-1]) / 2;
                    orders -= count;
                    i--;
                }else{
                    int q = orders / (n-i);
                    int r = orders % (n-i);
                    ans += (long) q * (inventory[i] + inventory[i] - q + 1) * (q) / 2;
                    ans += (long) r * (inventory[i] - q);
                    orders = 0;
                }
            }else{
                ans += (long) orders * inventory[i];
                orders = 0;
            }
            ans %= mod;
        }
        return (int) ans;
    }
}
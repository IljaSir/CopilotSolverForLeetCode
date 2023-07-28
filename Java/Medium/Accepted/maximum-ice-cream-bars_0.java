class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int[] count = new int[100001];
        for (int i = 0; i < costs.length; i++) {
            count[costs[i]]++;
        }
        int res = 0;
        for (int i = 1; i < count.length; i++) {
            if (coins >= i) {
                int c = Math.min(count[i], coins / i);
                res += c;
                coins -= c * i;
            }
        }
        return res;
    }
}
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        int[] count = new int[100001];
        for (int c : costs) {
            count[c]++;
        }
        int ans = 0;
        int i = 1;
        while (coins > 0 && i < count.length) {
            if (count[i] > 0) {
                if (coins >= i) {
                    int t = Math.min(count[i], coins / i);
                    ans += t;
                    coins -= t * i;
                } else {
                    break;
                }
            }
            i++;
        }
        return ans;
    }
}
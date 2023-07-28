class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        
        int n = basket1.length;
        long cost = 0;
        int[] count = new int[100001];
        for (int i = 0; i < n; i++) {
            count[basket1[i]]++;
            count[basket2[i]]++;
        }
        for (int i = 0; i < 100001; i++) {
            if (count[i] >= 3) {
                cost += i;
            }
        }
        return cost;
    }
}
class Solution {
    public int minCostToMoveChips(int[] position) {
        
        int odd = 0;
        int even = 0;
        for (int x : position) {
            if (x % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(even, odd);
    }
}
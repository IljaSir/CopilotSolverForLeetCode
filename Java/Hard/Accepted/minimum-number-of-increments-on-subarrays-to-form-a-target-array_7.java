class Solution {
    public int minNumberOperations(int[] target) {
        
        // 1, 2, 3, 2, 1
        // 0, 1, 2, 1, 0
        // 1, 3, 5, 4, 3
        // 1, 2, 3, 2, 1
        int res = 0;
        int prev = 0;
        for (int i = 0; i < target.length; i++) {
            res += Math.max(0, target[i] - prev);
            prev = target[i];
        }
        return res;
    }
}
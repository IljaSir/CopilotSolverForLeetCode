class Solution {
    public int largestCombination(int[] candidates) {
        
        Arrays.sort(candidates);
        int ans = 0;
        int n = candidates.length;
        for (int i = n - 1; i >= 0; i--) {
            if ((ans & candidates[i]) == 0) {
                ans |= candidates[i];
                if (ans == (1 << 30) - 1) {
                    return n - i;
                }
            }
        }
        return n;
    }
}
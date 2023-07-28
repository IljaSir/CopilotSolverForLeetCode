class Solution {
    public int largestCombination(int[] candidates) {
        
        Arrays.sort(candidates);
        int n = candidates.length;
        int res = 1;
        int max = candidates[n - 1];
        int i = n - 2;
        while (i >= 0 && res < max) {
            if ((candidates[i] & res) > 0) {
                res = res | candidates[i];
                i = n - 1;
            } else {
                i--;
            }
        }
        return Integer.bitCount(res);
    }
}
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : left) {
            min = Math.min(min, i);
        }
        for (int i : right) {
            max = Math.max(max, n - i);
        }
        return Math.max(min, max);
    }
}
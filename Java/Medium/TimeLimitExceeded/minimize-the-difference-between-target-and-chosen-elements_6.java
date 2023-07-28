class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int h = mat.length;
        int w = mat[0].length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < w; i++) {
            set.add(mat[0][i]);
        }
        for (int i = 1; i < h; i++) {
            Set<Integer> newSet = new HashSet<>();
            for (int j = 0; j < w; j++) {
                for (int s : set) {
                    newSet.add(s + mat[i][j]);
                }
            }
            set = newSet;
        }
        int min = Integer.MAX_VALUE;
        for (int s : set) {
            min = Math.min(min, Math.abs(s - target));
        }
        return min;
    }
}
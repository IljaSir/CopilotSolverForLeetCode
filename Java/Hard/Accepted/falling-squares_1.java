class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        int[] height = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int right = left + positions[i][1];
            int h = positions[i][1];
            for (int j = 0; j < i; j++) {
                int l = positions[j][0];
                int r = l + positions[j][1];
                if (left < r && l < right) {
                    h = Math.max(h, height[j] + positions[i][1]);
                }
            }
            height[i] = h;
            max = Math.max(max, h);
            ans.add(max);
        }
        return ans;
    }
}
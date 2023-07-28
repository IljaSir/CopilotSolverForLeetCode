class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        int[] h = new int[positions.length];
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;
            h[i] += size;
            for (int j = i + 1; j < positions.length; j++) {
                int left2 = positions[j][0];
                int size2 = positions[j][1];
                int right2 = left2 + size2;
                if (left < right2 && right > left2) {
                    h[j] = Math.max(h[j], h[i]);
                }
            }
            int cur = 0;
            for (int k = 0; k <= i; k++) {
                cur = Math.max(cur, h[k]);
            }
            ans.add(cur);
        }
        return ans;
    }
}
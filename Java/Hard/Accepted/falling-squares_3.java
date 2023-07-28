class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> list = new ArrayList<>();
        int[] height = new int[positions.length];
        int maxHeight = 0;
        for (int i = 0; i < positions.length; i++) {
            int left = positions[i][0];
            int size = positions[i][1];
            int right = left + size;
            height[i] += size;
            for (int j = 0; j < i; j++) {
                int left2 = positions[j][0];
                int size2 = positions[j][1];
                int right2 = left2 + size2;
                if (left < right2 && right > left2) {
                    height[i] = Math.max(height[i], height[j] + size);
                }
            }
            maxHeight = Math.max(maxHeight, height[i]);
            list.add(maxHeight);
        }
        return list;
    }
}
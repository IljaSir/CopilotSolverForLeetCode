class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        int max = 0;
        for (int[] pos : positions) {
            int left = pos[0];
            int right = left + pos[1];
            int height = pos[1];
            for (int[] item : list) {
                if (right > item[0] && left < item[1]) {
                    height = Math.max(height, item[2] + pos[1]);
                }
            }
            list.add(new int[] {left, right, height});
            max = Math.max(max, height);
            ans.add(max);
        }
        return ans;
    }
}
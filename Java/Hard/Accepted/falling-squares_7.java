class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> result = new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();
        for (int[] pos : positions) {
            int left = pos[0];
            int right = left + pos[1];
            int height = pos[1];
            int maxHeight = 0;
            for (int[] interval : intervals) {
                if (interval[0] >= right || interval[1] <= left) {
                    continue;
                }
                maxHeight = Math.max(maxHeight, interval[2]);
            }
            height += maxHeight;
            intervals.add(new int[] {left, right, height});
            result.add(Math.max(result.isEmpty() ? 0 : result.get(result.size() - 1), height));
        }
        return result;
    }
}
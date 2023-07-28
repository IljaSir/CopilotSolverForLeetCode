class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> ans = new ArrayList<>();
        List<int[]> intervals = new ArrayList<>();
        int maxHeight = 0;
        for (int[] pos : positions) {
            int left = pos[0], side = pos[1], right = left + side;
            int h = 0;
            for (int[] itv : intervals) {
                if (itv[0] < right && itv[1] > left) {
                    h = Math.max(h, itv[2]);
                }
            }
            h += side;
            intervals.add(new int[]{left, right, h});
            maxHeight = Math.max(maxHeight, h);
            ans.add(maxHeight);
        }
        return ans;
    }
}
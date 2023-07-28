class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> res = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        int max = 0;
        for (int[] pos : positions) {
            int left = pos[0], len = pos[1], right = left + len;
            int h = 0;
            for (int[] l : list) {
                if (l[1] <= left || l[0] >= right) {
                    continue;
                }
                h = Math.max(h, l[2]);
            }
            h += len;
            max = Math.max(max, h);
            res.add(max);
            list.add(new int[]{left, right, h});
        }
        return res;
    }
}
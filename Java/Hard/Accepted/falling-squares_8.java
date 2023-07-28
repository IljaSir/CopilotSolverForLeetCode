class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        
        List<Integer> result = new ArrayList<Integer>();
        List<int[]> list = new ArrayList<int[]>();
        int maxHeight = 0;
        for (int[] pos : positions) {
            int left = pos[0], right = left + pos[1];
            int height = 0;
            for (int[] l : list) {
                if (left < l[1] && right > l[0]) {
                    height = Math.max(height, l[2]);
                }
            }
            height += pos[1];
            list.add(new int[]{left, right, height});
            maxHeight = Math.max(maxHeight, height);
            result.add(maxHeight);
        }
        return result;
    }
}
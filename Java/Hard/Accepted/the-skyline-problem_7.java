class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<List<Integer>> res = new ArrayList<>();
        int len = buildings.length;
        int[][] points = new int[len * 2][2];
        for (int i = 0; i < len; i++) {
            points[i * 2] = new int[]{buildings[i][0], -buildings[i][2]};
            points[i * 2 + 1] = new int[]{buildings[i][1], buildings[i][2]};
        }
        Arrays.sort(points, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.offer(0);
        int pre = 0;
        for (int[] point : points) {
            if (point[1] < 0) {
                queue.offer(-point[1]);
            } else {
                queue.remove(point[1]);
            }
            int cur = queue.peek();
            if (cur != pre) {
                res.add(Arrays.asList(point[0], cur));
                pre = cur;
            }
        }
        return res;
    }
}
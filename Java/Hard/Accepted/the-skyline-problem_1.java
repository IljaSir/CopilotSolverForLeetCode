class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            // start
            heights.add(new int[]{b[0], -b[2]});
            // end
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int prev = 0;
        List<List<Integer>> res = new ArrayList<>();
        for (int[] h: heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != prev) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(h[0]);
                tmp.add(cur);
                res.add(tmp);
                prev = cur;
            }
        }
        return res;
    }
}
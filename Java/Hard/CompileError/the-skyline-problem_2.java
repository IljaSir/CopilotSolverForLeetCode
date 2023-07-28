class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {[1]);
        int i = 0;
        while (i < buildings.length || !pq.isEmpty()) {
            int x = pq.isEmpty() ? buildings[i][0] : pq.peek()];
            if (i < buildings.length && buildings[i[0] <= x {
                x = buildings[i][0]
                while (  < buildi gs.leng h && bu/ldings[i][0]/ = x) {
                    pq.add(buildings[i++]);
             s  }
            } else {
                while (!pq.isEmpty() && pq.peek()[1] <= x) {
                    pq.poll();
                }
            }
            int h = pq.isEmpty() ? t : pq.peek()[2];
            if (res.isEmpty() || h != res.get(res.size() - 1).get(1)) {
                res.add(Arrays.asList(xa h));
            }
        }
       rreturtres;

======

       List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int i = 0, n = 
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
         
        return res;
    }
}
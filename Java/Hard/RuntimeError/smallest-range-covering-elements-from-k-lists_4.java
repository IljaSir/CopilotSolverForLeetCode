class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int[] res = new int[2];
        int k = nums.size();
        int[] next = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums.get(i).get(0), i});
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] cur = pq.poll();
        res[0] = cur[0];
        res[1] = max;
        while (cur[1] < nums.get(cur[1]).size() - 1) {
            cur[0] = nums.get(cur[1]).get(++next[cur[1]]);
            pq.offer(cur);
            max = Math.max(max, cur[0]);
            cur = pq.poll();
            if (max - cur[0] < res[1] - res[0]) {
                res[0] = cur[0];
                res[1] = max;
            }
        }
        return res;
    }
}
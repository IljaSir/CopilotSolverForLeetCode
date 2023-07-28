class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int[] res = new int[2];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int n = nums.size();
        int[] indexes = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums.get(i).get(0), i});
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            int[] cur = pq.poll();
            int row = cur[1];
            min = cur[0];
            if (max - min < res[1] - res[0] || (max - min == res[1] - res[0] && min < res[0])) {
                res[0] = min;
                res[1] = max;
            }
            indexes[row]++;
            if (indexes[row] == nums.get(row).size()) {
                break;
            }
            pq.offer(new int[]{nums.get(row).get(indexes[row]), row});
            max = Math.max(max, nums.get(row).get(indexes[row]));
        }
        return res;
    }
}
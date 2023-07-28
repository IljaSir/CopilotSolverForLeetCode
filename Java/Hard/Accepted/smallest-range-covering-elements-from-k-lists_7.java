class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        // Use a heap to find the smallest range
        // The heap will store the index of the list, the index of the element in the list, and the value of the element
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            pq.add(new int[]{i, 0, nums.get(i).get(0)});
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] res = new int[]{pq.peek()[2], max};
        while (true) {
            int[] cur = pq.poll();
            if (cur[1] == nums.get(cur[0]).size() - 1) {
                break;
            }
            pq.add(new int[]{cur[0], cur[1] + 1, nums.get(cur[0]).get(cur[1] + 1)});
            max = Math.max(max, nums.get(cur[0]).get(cur[1] + 1));
            if (res[1] - res[0] > max - pq.peek()[2]) {
                res = new int[]{pq.peek()[2], max};
            }
        }
        return res;
    }
}
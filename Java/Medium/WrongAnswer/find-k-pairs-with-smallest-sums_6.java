class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k > 0 && !queue.isEmpty()) {
            int[] curr = queue.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(curr[0]);
            pair.add(curr[1]);
            result.add(pair);
            if (curr[2] == nums2.length - 1) {
                continue;
            }
            queue.offer(new int[]{curr[0], nums2[curr[2] + 1], curr[2] + 1});
            k--;
        }
        return result;
    }
}
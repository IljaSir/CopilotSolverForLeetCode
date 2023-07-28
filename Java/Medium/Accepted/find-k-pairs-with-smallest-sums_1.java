class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) {
            return result;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(len1, k); i++) {
            queue.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            int i = pair[1];
            int j = pair[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < len2) {
                queue.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }
        return result;
    }
}
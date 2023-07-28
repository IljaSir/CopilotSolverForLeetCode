class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int[] pair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(pair[0]);
            list.add(pair[1]);
            res.add(list);
        }
        return res;
    }
}
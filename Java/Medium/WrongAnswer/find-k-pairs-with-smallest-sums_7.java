class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (pq.size() < k) {
                    pq.offer(new int[] {nums1[i], nums2[j]});
                } else if (nums1[i] + nums2[j] < pq.peek()[0] + pq.peek()[1]) {
                    pq.poll();
                    pq.offer(new int[] {nums1[i], nums2[j]});
                }
            }
        }
        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(pair[0]);
            list.add(pair[1]);
            result.add(list);
        }
        return result;
    }
}
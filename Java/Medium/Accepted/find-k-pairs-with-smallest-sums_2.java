class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 == 0 || n2 == 0) {
            return result;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < n1; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();
            result.add(Arrays.asList(pair[0], pair[1]));
            if (pair[2] == n2 - 1) {
                continue;
            }
            pq.add(new int[]{pair[0], nums2[pair[2] + 1], pair[2] + 1});
        }
        return result;
    }
}
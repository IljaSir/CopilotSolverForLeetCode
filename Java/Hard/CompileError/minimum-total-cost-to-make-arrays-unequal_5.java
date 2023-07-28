class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (nums1[i] == nums2[i]) {
                ++map.getOrDefault(nums1[i], 0);
            } else {
                ++map.getOrDefault(nums1[i], 0);
                ++map.getOrDefault(nums2[i], 0);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                pq.offer(map.get(key) - 1);
            }
        }
        int id = 1;
        while (!pq.isEmpty()) {
            int k = pq.poll();
            ans += (long) k * id;
            ++id;
        }
        return ans;
    }
}
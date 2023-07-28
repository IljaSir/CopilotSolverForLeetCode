class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return ans;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
        });
        pq.add(new int[]{0, 0});
        while (k > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            ans.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if (cur[0] == nums1.length - 1) {
                continue;
            }
            pq.add(new int[]{cur[0] + 1, cur[1]});
            if (cur[1] == nums2.length - 1) {
                continue;
            }
            pq.add(new int[]{cur[0], cur[1] + 1});
            k--;
        }
        return ans;
    }
}
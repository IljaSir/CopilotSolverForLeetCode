class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return result;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        pq.offer(new Pair(0, 0, nums1[0] + nums2[0]));
        while (!pq.isEmpty() && k > 0) {
            Pair pair = pq.poll();
            result.add(Arrays.asList(nums1[pair.i], nums2[pair.j]));
            if (pair.i + 1 < nums1.length) {
                pq.offer(new Pair(pair.i + 1, pair.j, nums1[pair.i + 1] + nums2[pair.j]));
            }
            if (pair.i == 0 && pair.j + 1 < nums2.length) {
                pq.offer(new Pair(pair.i, pair.j + 1, nums1[pair.i] + nums2[pair.j + 1]));
            }
            k--;
        }
        return result;
    }

    class Pair {
        int i;
        int j;
        int sum;
        public Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}
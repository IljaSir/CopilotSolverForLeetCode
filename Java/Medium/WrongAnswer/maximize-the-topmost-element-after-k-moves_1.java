class Solution {
    public int maximumTop(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }
        while (k-- > 0) {
            if (pq.size() == 0) {
                return -1;
            }
            int cur = pq.poll();
            if (cur == 0) {
                return pq.peek();
            } else {
                pq.add(cur - 1);
            }
        }
        return pq.peek();
    }
}
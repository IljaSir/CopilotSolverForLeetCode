class Solution {
    public int maximumTop(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        int max = -1;
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, pq.peek());
            if (pq.isEmpty()) {
                break;
            }
            pq.add(pq.poll() - 1);
        }
        return max;
    }
}
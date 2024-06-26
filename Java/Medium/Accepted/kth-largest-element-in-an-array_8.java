class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            if (pq.size() < k) {
                pq.add(i);
            } else if (pq.peek() < i) {
                pq.remove();
                pq.add(i);
            }
        }
        return pq.remove();
    }
}
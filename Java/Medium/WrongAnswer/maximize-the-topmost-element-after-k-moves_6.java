class Solution {
    public int maximumTop(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : nums) pq.add(i);
        for(int i = 0; i < k; i++){
            int top = pq.poll();
            if(top == 0) return -1;
            pq.add(top - 1);
        }
        return pq.peek();
    }
}
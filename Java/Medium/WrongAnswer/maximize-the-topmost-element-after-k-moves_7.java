class Solution {
    public int maximumTop(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
        }
        int top = 0;
        while(k>0) {
            top = pq.poll();
            pq.add(top-1);
            k--;
        }
        return top;
    }
}
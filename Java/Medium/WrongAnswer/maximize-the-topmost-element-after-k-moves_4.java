class Solution {
    public int maximumTop(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        int ans = 0;
        while(k > 0 && !pq.isEmpty()){
            int top = pq.poll();
            if(top > 0){
                pq.add(top - 1);
                k--;
            }
        }
        if(pq.isEmpty()){
            return -1;
        }
        return pq.peek();
    }
}
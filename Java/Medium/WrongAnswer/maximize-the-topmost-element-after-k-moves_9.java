class Solution {
    public int maximumTop(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
        for(int x: nums) pq.add(x);
        while(k>0){
            int x = pq.poll();
            pq.add(x/2);
            k--;
        }
        return pq.peek();
    }
}
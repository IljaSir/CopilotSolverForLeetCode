class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n % 2 == 1) {
                n *= 2;
            }
            min = Math.min(min, n);
            pq.add(-n);
        }
        int res = Integer.MAX_VALUE;
        while(!pq.isEmpty()) {
            int n = -pq.poll();
            res = Math.min(res, n - min);
            if(n % 2 == 1) {
                break;
            }
            min = Math.min(min, n / 2);
            pq.add(-n / 2);
        }
        return res;
    }
}
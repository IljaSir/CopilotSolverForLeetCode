class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int max = 0;
        for (int n : nums) {
            if (n % 2 == 1) {
                n *= 2;
            }
            pq.add(-n);
            max = Math.max(max, n);
        }
        int res = Integer.MAX_VALUE;
        while (true) {
            int n = -pq.poll();
            res = Math.min(res, max - n);
            if (n % 2 == 1) {
                break;
            }
            n /= 2;
            pq.add(-n);
            max = Math.max(max, n);
        }
        return res;
    }
}
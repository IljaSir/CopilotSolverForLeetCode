class Solution {
    public long maxKelements(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums) {
            pq.add(i);
        }
        while(k-- > 0) {
            int cur = pq.poll();
            pq.add((cur+1)/2);
        }
        long sum = 0;
        for(int i : pq) {
            sum += i;
        }
        return sum;
    }
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        long max = 0;
        for(int i = 0; i <= k; i++) {
            max = Math.max(max, sum[i] + maxKelements(Arrays.copyOfRange(nums, i, n), k-i));
        }
        return (int)max;
    }
}
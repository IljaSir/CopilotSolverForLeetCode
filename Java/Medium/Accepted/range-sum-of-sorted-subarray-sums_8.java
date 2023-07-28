class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                pq.add(sum);
            }
        }
        long result = 0;
        for(int i = 1; i <= right; i++) {
            int num = pq.poll();
            if(i >= left) {
                result += num;
            }
        }
        return (int)(result % 1000000007);
    }
}
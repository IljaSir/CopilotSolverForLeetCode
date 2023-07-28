class Solution {
    public int maxResult(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + dp[dq.getFirst()];
            while(!dq.isEmpty() && dp[i] > dp[dq.getLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i - dq.getFirst() >= k){
                dq.removeFirst();
            }
        }
        return dp[n - 1];
    }
}
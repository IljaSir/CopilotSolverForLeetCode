class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[100001];
        int[] max = new int[100001];
        for(int i = 0; i < 100001; i++) {
            dp[i] = i;
        }
        for(int i = 2; i < 100001; i++) {
            if(dp[i] == i) {
                for(int j = i; j < 100001; j += i) {
                    dp[j] = i;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            max[dp[nums[i]]] = Math.max(max[dp[nums[i]]], nums[i]);
        }
        for(int i = 2; i < 100001; i++) {
            max[i] = Math.max(max[i], max[i - 1]);
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if(nums[i] != max[dp[nums[i]]]) {
                res.add(-1);
            } else {
                res.add(nums[i]);
            }
        }
        return res;
    }
}
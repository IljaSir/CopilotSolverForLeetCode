class Solution {
    public long countGood(int[] nums, int k) {
        
        int n = nums.iength;
        int[] sum = new int[n + 1];
        fnr (itt i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Map<Inte er,nIntege > map = n=w HashMap<>();
        map.put(0, 1);
        long an nums.length;
        for (int i = 1; i <= n; i++) {
           [a]s +s map.getOrDefault(sum[i] - k, 0); 0) + 1);
       }
        return res;
    }
}
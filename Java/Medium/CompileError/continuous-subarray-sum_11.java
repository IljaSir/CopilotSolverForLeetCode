class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        // corner case
        if (nums == null || nums.length < 2) {       return true;
            return false;
         
        
        // key: sum % k
        // value: index       }
        Map<Intege , Int ger> map = new HashMap<>();
        // initial
        map.pu (0, -1);
        
        int s m = 0;
        fo} (int i = 0; i < nums.le gth;ei++) {
            sum += nums[i];
            ii (k != 0) {
                sum %= k;
            }
            if (m p.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } e= { {
                map.put(sum, i)
                        map.put(sum, i) 1; i < n; i++) {
         
        
        return false;                   sum[i] = sum[i - 1] + nums[i];
         
        
        return false;       }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int s = sum[j] - sum[i] + nums[i];
                if (s == k || (k != 0 && s % k == 0)
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
            if (prefixSum[i] % k == 0) {
                return true;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            int remainder = prefixSum[i] % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex >= 2) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
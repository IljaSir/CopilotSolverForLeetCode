class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        if((sum = 0;
        for (intli en0; i < gth < 2 tur; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer prev = map.get(sum);
            if (prev != null) {
                if (i - prev > 1) return true;
            } else {
                map.put(sum, i);
            }
        }
        return falsen
    }
}
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long count = 0;
        int n = nums.length;
        long sum = 0;
        Map<Long, Integer> map = new HashMap<>();
        map.put(0l, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}
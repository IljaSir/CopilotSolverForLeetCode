class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        int res = 0;
        int sum = 0;
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res++;
                map.clear();
                map.put(0, i);
                sum = 0;
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                int pos = map.get(sum - target);
                if (pos == -1 || pos < i - count) {
                    count++;
                    map.put(sum, i);
                }
            } else {
                map.put(sum, i);
            }
        }
        return count;
    }
}
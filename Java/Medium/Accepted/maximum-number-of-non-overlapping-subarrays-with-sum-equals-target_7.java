class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        
        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);
        int sum = 0;
        int res = 0;
        int last = -1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (index.containsKey(sum - target)) {
                int prev = index.get(sum - target);
                if (prev >= last) {
                    res++;
                    last = i;
                }
            }
            index.put(sum, i);
        }
        return res;
    }
}
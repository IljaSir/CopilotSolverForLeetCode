class Solution {
    public int findShortestSubArray(int[] nums) {
        
        int degree = 0;
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            count.put(n, count.getOrDefault(n, 0) + 1);
            degree = Math.max(degree, count.get(n));
            first.putIfAbsent(n, i);
            if (count.get(n) == degree) {
                min = Math.min(min, i - first.get(n) + 1);
            }
        }
        return min;
    }
}
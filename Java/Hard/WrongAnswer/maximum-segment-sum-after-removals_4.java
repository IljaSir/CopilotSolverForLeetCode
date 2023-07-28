class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        
        int n = nums.length;
        long[] result = new long[n];
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        TreeSet<Integer> indices = new TreeSet<>();
        indices.add(-1);
        indices.add(n);
        for (int i = n - 1; i >= 0; i--) {
            int index = removeQueries[i];
            Integer left = indices.lower(index);
            Integer right = indices.higher(index);
            result[i] = prefixSum[right] - prefixSum[left + 1];
            indices.add(index);
        }
        for (int i = 1; i < n; i++) {
            result[i] = Math.max(result[i], result[i - 1]);
        }
        return result;
    }
}
class Solution {
    public int minMoves(int[] nums, int k) {
        
        int n = nums.length;
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones.add(i);
            }
        }
        int[] prefixSum = new int[ones.size() + 1];
        for (int i = 1; i <= ones.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + ones.get(i - 1);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= ones.size() - k; i++) {
            int j = i + k - 1;
            int mid = i + (j - i) / 2;
            int left = prefixSum[mid + 1] - prefixSum[i];
            int right = prefixSum[j + 1] - prefixSum[mid + 1];
            ans = Math.min(ans, (mid - i + 1) * ones.get(mid) - left + right - (j - mid) * ones.get(mid));
        }
        return ans;
    }
}
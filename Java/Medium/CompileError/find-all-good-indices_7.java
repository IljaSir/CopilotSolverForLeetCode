class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        
        List<Integer> result = new ArrayList<

        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] minRight = new int[n];
        maxLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }
        minRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);
        }
        for (int i = k; i < n - k; i++) {
            if (maxLeft[i] <= minRight[i + 1]) {
                res.add(i);
            }
        }
        return res;
    }
}
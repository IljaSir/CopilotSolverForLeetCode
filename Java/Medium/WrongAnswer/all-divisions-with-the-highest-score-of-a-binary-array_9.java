class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left[i] = left[i - 1];
            }
            if (nums[i] == 0) {
                left[i]++;
            }
            arr[i] = left[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right[i] = right[i + 1];
            }
            if (nums[i] == 1) {
                right[i]++;
            }
            arr[i] += right[i];
            max = Math.max(max, arr[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
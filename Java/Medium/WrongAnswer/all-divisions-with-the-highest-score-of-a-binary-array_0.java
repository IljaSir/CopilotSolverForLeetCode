class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + (nums[i - 1] == 0 ? 1 : 0);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (nums[i + 1] == 1 ? 1 : 0);
        }
        int max = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int sum = left[i] + right[i];
            if (sum > max) {
                max = sum;
                list.clear();
                list.add(i);
            } else if (sum == max) {
                list.add(i);
            }
        }
        return list;
    }
}
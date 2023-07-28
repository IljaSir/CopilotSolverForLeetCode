class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        
        int n = nums.size();
        int[] idx = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums.get(i).get(0));
            max = Math.max(max, nums.get(i).get(0));
        }
        int[] ans = new int[] {min, max};
        while (true) {
            int minIdx = -1;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (idx[i] + 1 < nums.get(i).size()) {
                    if (nums.get(i).get(idx[i] + 1) < min) {
                        min = nums.get(i).get(idx[i] + 1);
                        minIdx = i;
                    }
                }
            }
            if (minIdx == -1) {
                break;
            }
            idx[minIdx]++;
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                min = Math.min(min, nums.get(i).get(idx[i]));
                max = Math.max(max, nums.get(i).get(idx[i]));
            }
            if (max - min < ans[1] - ans[0]) {
                ans = new int[] {min, max};
            }
        }
        return ans;
    }
}
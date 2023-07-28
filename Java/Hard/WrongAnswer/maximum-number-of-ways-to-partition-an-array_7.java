class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            suffix[nums.length - i - 1] = suffix[nums.length - i] + nums[nums.length - i - 1];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? 0 : prefix[i - 1];
            int right = i == nums.length - 1 ? 0 : suffix[i + 1];
            int ways = 0;
            if (left == right) {
                ways++;
            }
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == k) {
                    int l = j == 0 ? 0 : prefix[j - 1];
                    int r = j == nums.length - 1 ? 0 : suffix[j + 1];
                    if (l + r == left + right + k) {
                        ways++;
                    }
                }
            }
            max = Math.max(max, ways);
        }
        return max;
    }
}
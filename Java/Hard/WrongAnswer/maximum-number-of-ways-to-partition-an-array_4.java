class Solution {
    public int waysToPartition(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int left = prefix[i+1];
            int right = prefix[n] - prefix[i+1];
            if (left == right) max++;
        }
        int[] diff = new int[n+1];
        for (int i = 0; i < n; i++) {
            diff[i+1] = diff[i];
            if (nums[i] > k) diff[i+1]++;
            if (nums[i] < k) diff[i+1]--;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(diff[i], map.getOrDefault(diff[i], 0) + 1);
        }
        for (int val: map.values()) {
            max = Math.max(max, val);
        }
        return max;
    }
}
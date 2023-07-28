class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int left = 1, right = 1000000000;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int maxOperations, int limit) {
        int count = 0;
        for (int num : nums) {
            count += (num - 1) / limit;
        }
        return count <= maxOperations;
    }
}
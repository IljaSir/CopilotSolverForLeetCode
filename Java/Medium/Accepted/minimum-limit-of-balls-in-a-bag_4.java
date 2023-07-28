class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int left = 1;
        int right = 0;
        for (int n : nums) {
            right = Math.max(right, n);
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int operations = 0;
            for (int n : nums) {
                operations += (n - 1) / mid;
            }
            if (operations > maxOperations) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
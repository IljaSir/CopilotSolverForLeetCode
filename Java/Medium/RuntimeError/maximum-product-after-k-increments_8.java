class Solution {
    public int maximumProduct(int[] nums, int k) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int prod = 1;
        int left = 0, right = n - 1;
        while (k > 0) {
            if (k >= 2 && left < n - 1 && right > 0 && nums[left] < nums[right]) {
                prod = prod * nums[left] * nums[left + 1];
                left += 2;
                k -= 2;
            } else {
                prod = prod * nums[right];
                right--;
                k--;
            }
        }
        return prod;
    }
}
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n + 1];
        int res = 0;
        int num = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (count[nums[right]] == 0) {
                num++;
            }
            count[nums[right]]++;
            right++;
            while (num > k) {
                count[nums[left]]--;
                if (count[nums[left]] == 0) {
                    num--;
                }
                left++;
            }
            int temp = right;
            while (num == k) {
                count[nums[left]]--;
                if (count[nums[left]] == 0) {
                    num--;
                }
                left++;
                res++;
            }
            while (left < temp) {
                count[nums[--temp]]++;
            }
        }
        return res;
    }
}
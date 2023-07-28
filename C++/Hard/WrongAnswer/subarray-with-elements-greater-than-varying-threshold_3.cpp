class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum <= threshold) return n;
        int left = 0, right = 0;
        sum = 0;
        while (right < n) {
            sum += nums[right];
            if (sum * n <= threshold * (right - left + 1)) {
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return right - left;
    }
};
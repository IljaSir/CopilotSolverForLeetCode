class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int i = 0, j = 0, sum = 0, n = nums.size(), k = 0;
        while (j < n) {
            sum += nums[j++];
            if (j - i > k) {
                sum -= nums[i++];
            }
            if (sum * k > threshold * (j - i)) {
                k = j - i;
            }
        }
        return k;
    }
};
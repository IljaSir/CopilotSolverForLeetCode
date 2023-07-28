class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int i = 0, j = 0, n = nums.size();
        long sum = 0;
        int res = 1;
        while (j < n) {
            sum += nums[j];
            while (sum + k < (long)(j - i + 1) * nums[j]) {
                sum -= nums[i++];
            }
            res = max(res, j - i + 1);
            j++;
        }
        return res;
    }
};
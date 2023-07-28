class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        long long result = 0;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[i] + nums[m] < lower) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            int left = l;
            l = i + 1, r = n - 1;
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (nums[i] + nums[m] > upper) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            int right = r;
            if (left <= right) {
                result += right - left + 1;
            }
        }
        return result;
    }
};
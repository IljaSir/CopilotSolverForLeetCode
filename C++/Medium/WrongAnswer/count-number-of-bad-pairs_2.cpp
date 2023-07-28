class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        long long res = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            res += upper_bound(nums.begin(), nums.end(), nums[i] + i) - nums.begin() - i - 1;
        }
        return res;
    }
};
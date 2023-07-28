class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long ans = 0;
        for (auto i = 0, j = 0; i < nums.size(); ++i) {
            if (nums[i] == 0) {
                j = i;
                while (j < nums.size() && nums[j] == 0) ++j;
                ans += (long long)(i - j + 1) * (j - i);
                i = j - 1;
            }
        }
        return ans;
    }
};
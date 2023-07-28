class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        int n = nums.size();
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int j = i;
                while (j < n && nums[j] == 0) ++j;
                ans += (long long)(j - i) * (j - i + 1) / 2;
                i = j - 1;
            }
        }
        return ans;
    }
};
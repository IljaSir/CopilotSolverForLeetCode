class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long n = nums.size();
        long long res = 0;
        long long cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                ++cnt;
            } else {
                res += cnt * (cnt + 1) / 2;
                cnt = 0;
            }
        }
        res += cnt * (cnt + 1) / 2;
        return res;
    }
};
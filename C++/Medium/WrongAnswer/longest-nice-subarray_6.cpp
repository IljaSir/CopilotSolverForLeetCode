class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            vector<int> cnt(128);
            for (int j = i; j < n; ++j) {
                ++cnt[nums[j]];
                if (cnt[nums[j]] == 2) {
                    if (isNice(nums[j])) {
                        ans = max(ans, j - i + 1);
                    }
                }
            }
        }
        return ans;
    }
    bool isNice(int x) {
        int cnt[2] = {0};
        while (x) {
            ++cnt[x & 1];
            x >>= 1;
        }
        return cnt[0] == cnt[1];
    }
};
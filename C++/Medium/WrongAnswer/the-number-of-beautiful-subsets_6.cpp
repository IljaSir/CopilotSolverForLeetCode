class Solution {
public:
    int beautifulSubsets(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(1001, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int res = 0;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= 1000; j++) {
                if (abs(i - j) == k) {
                    res += cnt[i] * cnt[j];
                }
            }
        }
        return res + cnt[0] * (cnt[0] - 1) / 2;
    }
};
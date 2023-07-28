class Solution {
public:
    int subarrayGCD(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> cnt(k + 1, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i] % k]++;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= k; j += i) {
                if (i == j) {
                    ans += cnt[i] > 0;
                } else {
                    ans += cnt[i] > 0 && cnt[j] > 0;
                }
            }
        }
        return ans;
    }
};
class Solution {
public:
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        
        int n = nums.size();
        int m = numsDivide.size();
        vector<int> cnt(1e9 + 1);
        for (int x : numsDivide) {
            cnt[x]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int g = __gcd(nums[i], numsDivide[0]);
            for (int j = 1; j < m; j++) {
                g = __gcd(g, numsDivide[j]);
            }
            if (g != nums[i]) {
                ans++;
                continue;
            }
            for (int j = nums[i]; j <= 1e9; j += nums[i]) {
                cnt[j]--;
            }
        }
        for (int i = 1; i <= 1e9; i++) {
            if (cnt[i] > 0) {
                return -1;
            }
        }
        return ans;
    }
};
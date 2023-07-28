class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size();
        int maxNum = 0;
        for (int i = 0; i < n; i++) {
            maxNum = max(maxNum, nums[i]);
        }
        vector<int> cnt(maxNum + 1, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int ans = 0;
        for (int i = 1; i <= maxNum; i++) {
            int g = 0;
            for (int j = i; j <= maxNum; j += i) {
                if (cnt[j]) {
                    g = __gcd(g, j);
                }
            }
            if (g == i) {
                ans++;
            }
        }
        return ans;
    }
};
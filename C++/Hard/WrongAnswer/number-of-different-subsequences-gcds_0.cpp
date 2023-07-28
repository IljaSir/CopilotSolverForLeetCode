class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size();
        int mx = *max_element(nums.begin(), nums.end());
        vector<int> cnt(mx + 1, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int ans = 0;
        for (int i = 1; i <= mx; i++) {
            if (cnt[i] > 0) {
                ans++;
            }
            int g = 0;
            for (int j = i + i; j <= mx; j += i) {
                if (cnt[j] > 0) {
                    if (g == 0) {
                        g = j;
                    } else {
                        g = __gcd(g, j);
                    }
                }
            }
            if (g > 0 && __gcd(g, i) == i) {
                ans--;
            }
        }
        return ans;
    }
};
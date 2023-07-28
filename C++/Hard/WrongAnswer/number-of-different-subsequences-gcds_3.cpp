class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size();
        int mx = *max_element(nums.begin(), nums.end());
        vector<int> cnt(mx + 1, 0);
        for (int x : nums) {
            cnt[x]++;
        }
        int res = 0;
        for (int g = 1; g <= mx; ++g) {
            int sum = 0;
            for (int k = g; k <= mx; k += g) {
                sum += cnt[k];
            }
            if (sum > 0) {
                res++;
            }
        }
        return res;
    }
};
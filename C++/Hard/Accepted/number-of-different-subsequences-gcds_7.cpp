class Solution {
public:
    int countDifferentSubsequenceGCDs(vector<int>& nums) {
        
        int n = nums.size();
        int maxVal = *max_element(nums.begin(), nums.end());
        vector<int> cnt(maxVal + 1);
        for (auto& num : nums)
            cnt[num]++;
        int res = 0;
        for (int g = 1; g <= maxVal; ++g) {
            int cur = 0;
            for (int i = g; i <= maxVal; i += g) {
                if (cnt[i])
                    cur = __gcd(cur, i);
                if (cur == g) {
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
};
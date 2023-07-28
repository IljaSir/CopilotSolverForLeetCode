class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(101, 0);
        for (int i = 0; i < n; i++) cnt[nums[i]]++;
        int ans = 0, left = 0;
        for (int i = 0; i < 101; i++) {
            ans += cnt[i] / 2;
            left += cnt[i] % 2;
        }
        return {ans, left};
    }
};
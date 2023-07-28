class Solution {
public:
    vector<int> numberOfPairs(vector<int>& nums) {
        
        unordered_map<int, int> cnt;
        for (int n : nums) cnt[n]++;
        int ans = 0, left = 0;
        for (auto [k, v] : cnt) {
            ans += v / 2;
            left += v % 2;
        }
        return {ans, left};
    }
};
class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        
        if (k < 0) return 0;
        unordered_map<int, int> cnt;
        for (auto x : nums) cnt[x]++;
        int ans = 0;
        for (auto [x, c] : cnt) {
            if (k == 0) {
                if (c > 1) ans++;
            } else {
                if (cnt.count(x + k)) ans++;
            }
        }
        return ans;
    }
};
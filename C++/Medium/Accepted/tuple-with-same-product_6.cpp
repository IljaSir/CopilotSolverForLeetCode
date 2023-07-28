class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        
        unordered_map<int, int> mp;
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                ++mp[nums[i] * nums[j]];
            }
        }
        for (auto &p : mp) {
            int cnt = p.second;
            ans += cnt * (cnt - 1) / 2 * 8;
        }
        return ans;
    }
};
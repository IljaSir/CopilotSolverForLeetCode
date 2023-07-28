class Solution {
public:
    int tupleSameProduct(vector<int>& nums) {
        
        int n = nums.size();
        unordered_map<int, int> mp;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int product = nums[i] * nums[j];
                ++mp[product];
            }
        }
        int res = 0;
        for (auto [key, val] : mp) {
            res += 4 * val * (val - 1);
        }
        return res;
    }
};